package cn.gyl.laboratoryweb.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gyl.laboratoryweb.model.Attendance;
import cn.gyl.laboratoryweb.model.Laboratory;
import cn.gyl.laboratoryweb.model.Order;
import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.StuClass;
import cn.gyl.laboratoryweb.model.Student;
import cn.gyl.laboratoryweb.model.SystemContext;
import cn.gyl.laboratoryweb.model.Teacher;
import cn.gyl.laboratoryweb.model.TimeSection;
import cn.gyl.laboratoryweb.model.Watch;
import cn.gyl.laboratoryweb.service.AttendanceService;
import cn.gyl.laboratoryweb.service.LaboratoryService;
import cn.gyl.laboratoryweb.service.OrderService;
import cn.gyl.laboratoryweb.service.StuClassService;
import cn.gyl.laboratoryweb.service.StudentService;
import cn.gyl.laboratoryweb.service.TeacherService;
import cn.gyl.laboratoryweb.service.TimeSectionService;
import cn.gyl.laboratoryweb.service.WatchService;

/**
 * @Decription 处理与预约信息相关的请求
 * @authorEmail 1076030424@qq.com
 */
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private StuClassService stuClassService;

	@Autowired
	private LaboratoryService laboratoryService;

	@Autowired
	private TimeSectionService timeSectionService;

	@Autowired
	private WatchService watchService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private AttendanceService attendanceService;

	@Autowired
	private TeacherService teacherService;

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// 学生能预约3天内的实验室
	private static final long STU_PRE_DAY = 5 * 24 * 60 * 60 * 1000L;
	// 教师能预约15天内的实验室
	private static final long TEACHER_PRE_DAY = 30 * 24 * 60 * 60 * 1000L;
	// 学生能够同时存在几次未达时间的预约
	private static final int MAX_ORDER = 5;

	/**
	 * 
	 * @Decription 返回暂未通过的预约申请信息界面
	 */
	@RequestMapping("/orderManager")
	public String adminManager() {
		return "admin/order-manager";
	}

	/**
	 * 
	 * @Decription 返回已通过的预约申请信息界面
	 */
	@RequestMapping("/oldOrderInfo")
	public String OldOrderManager() {
		return "admin/oldOrder-info";
	}

	/**
	 * 
	 * @Decription 获取分页下的未通过的预约申请
	 */
	@ResponseBody
	@RequestMapping(value = "/getPagerOrders", method = RequestMethod.POST)
	public Pager<Order> getAllPagers(@RequestParam("rows") Integer rows, @RequestParam("page") Integer page) {
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) {
				SystemContext.setPageOffset((page - 1) * rows);
			}
		}
		Pager<Order> allPagers = orderService.getAllPageOrders();
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return allPagers;
	}

	/**
	 * 
	 * @Decription 获取分页下的已通过的预约申请
	 */
	@ResponseBody
	@RequestMapping(value = "/getPagerOldOrders", method = RequestMethod.POST)
	public Pager<Order> getAllOldPagers(@RequestParam("rows") Integer rows, @RequestParam("page") Integer page,
			@RequestParam(value = "id", required = false) Integer id) {
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) {
				SystemContext.setPageOffset((page - 1) * rows);
			}
		}
		if (id == null) {
			id = 0;
		}
		Pager<Order> allOldPagers = orderService.getAllPageOldOrders(id);
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return allOldPagers;
	}

	/**
	 * 
	 * @Decription 用于管理员同意预约申请
	 */
	@ResponseBody
	@RequestMapping(value = "/confirmOrder", method = RequestMethod.GET)
	public String confirmOrder(@RequestParam(value = "ids[]") int[] ids,
			@RequestParam(value = "flag", required = false) Integer flag) {
		for (int i : ids) {
			orderService.confirmOrder(i);
			Order order = orderService.getOne(i);
			// 有班级信息,则是老师预约,批量为班级插入初始签到与打卡记录
			if (order.getUserRole() == 1) {
				addWatchAndATD(order,flag);
			} else {
				Attendance attendance = new Attendance();
				attendance.setStudentAccount(order.getUserId());
				attendance.setStartDate(order.getStartTime());
				attendance.setEndDate(order.getEndTime());
				attendance.setLaboratoryId(order.getRoomId());
				if (flag != null && flag == 1) {
					attendance.setIsOpen(true);
				}
				attendanceService.insert(attendance);
			}
		}
		return "success";
	}

	/**
	 * @Decription 当教师用户的预约成立过后,将会为该班级学生批量导入预习记录,即视频观看进度为0;将会为该班级学生批量导入签到,显示未打卡状态
	 *             即status=0;
	 */
	private void addWatchAndATD(Order order,Integer flag) {
		Long stuClass = order.getStuClass();
		Date startTime = order.getStartTime();
		Date endTime = order.getEndTime();
		Long experProjectAccount = order.getExperProjectAccount();
		Long teacherAccount = order.getUserId();
		List<Student> students = studentService.getStudentByClass(stuClass);

		for (int i = 0; i < students.size(); i++) {
			Watch watch = new Watch();
			watch.setRelateOrder(order.getOrderPKID());
			watch.setDeadline(order.getStartTime());
			watch.setWatchDate(new Date());
			watch.setExperimentalProjectId(experProjectAccount);
			watch.setStuClassId(stuClass);
			Attendance attendance = new Attendance();
			if (flag != null && flag == 1) {
				attendance.setIsOpen(true);
			}
			attendance.setStartDate(startTime);
			attendance.setEndDate(endTime);
			attendance.setTeacherAccount(teacherAccount);
			attendance.setLaboratoryId(order.getRoomId());
			attendance.setExperProjectId(experProjectAccount);
			Long studentAccount = students.get(i).getStudentAccount();
			watch.setStudentAccount(studentAccount);
			attendance.setStudentAccount(studentAccount);
			watchService.insert(watch);
			attendanceService.insert(attendance);
		}
	}

	/**
	 * 
	 * @Decription 用于驳回预约请求(删除)
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteOrder", method = RequestMethod.GET)
	public String deleteOrder(@RequestParam(value = "ids[]") int[] ids) {
		for (int i : ids) {
			Order one = orderService.getOne(i);
			one.setStatus(2);
			orderService.update(one);
		}
		return "success";
	}

	/**
	 * 
	 * @Decription 用户撤销预约
	 */
	@ResponseBody
	@RequestMapping(value = "/cancelOrder", method = RequestMethod.GET)
	public String cancelOrder(@RequestParam(value = "ids[]") int[] ids) {
		for (int i : ids) {
			Order one = orderService.getOne(i);
			one.setStatus(3);
			orderService.update(one);
		}
		return "success";
	}

	/**
	 * 
	 * @Decription 用于获取所有的一天中的预约时间段,以键值的方式返回
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllTimeSection", method = RequestMethod.POST)
	public List<Map<String, String>> getAllTimeSection() {
		List<TimeSection> TimeSections = timeSectionService.getAllTimeSection();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (TimeSection timeSection : TimeSections) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", timeSection.getTimeSectionPKID() + "");
			map.put("text", timeSection.getStartTime() + "~" + timeSection.getEndTime());
			list.add(map);
		}
		return list;
	}

	/**
	 * 
	 * @throws ParseException
	 * @Decription 区分老师预学生的预约请求,处理并存储用户预约信息,包括数据校验
	 */
	@ResponseBody
	@RequestMapping(value = "/orderLaboratory", method = RequestMethod.POST)
	public String orderLaboratory(HttpSession session, @RequestParam(value = "laboratoryId") Long laboratoryId,
			@RequestParam(value = "orderTimeSectionId") String orderTimeSectionId,
			@RequestParam(value = "orderDay") String orderDay,
			@RequestParam(value = "stuClass", required = false) Long stuClass,
			@RequestParam(value = "experProjectId", required = false) Long experProjectId) throws ParseException {
		Order order = new Order();
		Laboratory orderLab = laboratoryService.getOneByLabId(laboratoryId);
		Date inDate = simpleDateFormat.parse(orderDay + " 00:00:00");
		Date nowDate = new Date();

		TimeSection timeSection = timeSectionService.getOne(Integer.parseInt(orderTimeSectionId));
		String startTime = orderDay + " " + timeSection.getStartTime() + ":00";
		String endTime = orderDay + " " + timeSection.getEndTime() + ":00";
		order.setStatus(0);
		order.setStartTime(simpleDateFormat.parse(startTime));
		order.setEndTime(simpleDateFormat.parse(endTime));
		// 1.判断实验室状态
		if (orderLab.getLaboratoryStatus() == 0) {
			return "labForbidden";
		}
		// 2.判断该实验室在这个时间段是否被教师所预约;
		if (orderService.getLabIsClasOrdered(laboratoryId, order.getStartTime())) {
			return "classordered";
		}
		// 用户类型的判断
		String roleString = (String) session.getAttribute("role");
		Long userId = Long.parseLong((session.getAttribute("userAccount") + ""));
		int labOrderedSits = orderService.getLabOrderedSits(laboratoryId, order.getStartTime());
		int labSits = orderLab.getLaboratorySitNum();
		if (roleString.equals("学生")) {
			Student student = studentService.getStudentByAccount(userId);
			// 3A.1学生状态判断
			if (student.getStatus() != 1) {
				return "forbidden";
			}
			// 3A.2学生一个时间段只能预约一个实验室
			if (orderService.isStuOrdered(order.getStartTime(), userId)) {
				return "ordered";
			}
			// 3A.3预约时间的判断,默认为未来5天内
			if (inDate.getTime() < nowDate.getTime() || inDate.getTime() > (nowDate.getTime() + STU_PRE_DAY)) {
				return "swrongday";
			}
			// 3A.4判断该实验室 该时间段 被预约的座位数是否超过限制
			if (labOrderedSits >= labSits) {
				return "outofnum";
			}
			// 3A.5学生预约请求限制
			int nowAlreayOrder = orderService.queryUserNowOrder(userId);
			if (nowAlreayOrder >= MAX_ORDER) {
				return "outMaxOrder";
			}
			order.setUserName(studentService.getStudentByAccount(userId).getStudentName());
			order.setUserRole(2);
			// 随机分配座位策略
			for (int i = labOrderedSits + 1; i <= labSits; i++) {
				if (!orderService.getLabSitIsOrder(laboratoryId, order.getStartTime(), i)) {
					order.setRoomSitId(i);
					break;
				}
				if (i == labSits) {
					i = 1;
				}
			}
		} else if (roleString.equals("教师")) {
			Teacher teacher = teacherService.getTeacherByAccount(userId);
			// 3B.1教师状态
			if (teacher.getStatus() != 1) {
				return "forbidden";
			}
			// 3B.2已经被学生预约,无法预约
			if (labOrderedSits != 0) {
				return "ordered";
			}
			// 3B.3时间判断
			if (inDate.getTime() < nowDate.getTime() || inDate.getTime() > (nowDate.getTime() + TEACHER_PRE_DAY)) {
				return "twrongday";
			}
			// 3B.4班级人数判断
			StuClass stuClassByAccount = stuClassService.getStuClassByAccount(stuClass);
			if (stuClassByAccount.getStuNum() > labSits) {
				return "overStuNum";
			}
			order.setUserName(teacherService.getTeacherByAccount(userId).getTeacherName());
			order.setUserRole(1);
			order.setStuClass(stuClass);
			order.setStuClassName(stuClassService.getStuClassByAccount(stuClass).getStuClassName());
			order.setExperProjectAccount(experProjectId);
		} else {
			throw new RuntimeException();
		}
		order.setUserId(userId);
		order.setOrderTime(nowDate);
		order.setRoomId(laboratoryId);
		order.setRoomName(laboratoryService.getOneByLabId(laboratoryId).getLaboratoryName());
		Order flag = orderService.insert(order);
		if (flag != null) {
			return "ok";
		} else {
			return "fail";
		}

	}

	/**
	 * 
	 * @Decription 用户查询自己的预约信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getPagerOrderByUser", method = RequestMethod.POST)
	public Pager<Order> getPagerOrderByUser(HttpSession session, @RequestParam("rows") Integer rows,
			@RequestParam("page") Integer page) {
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) {
				SystemContext.setPageOffset((page - 1) * rows);
			}
		}
		Pager<Order> allPagers = null;
		Long userAccount = (Long) session.getAttribute("userAccount");
		String role = (String) session.getAttribute("role");
		if (userAccount != null) {
			if ("学生".equals(role)) {
				Student student = studentService.getStudentByAccount(userAccount);
				allPagers = orderService.getStudentOrder(userAccount, student.getStuClass());
			} else {
				allPagers = orderService.getPagerOrderByAccount(userAccount);
			}
		}
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return allPagers;
	}

	/**
	 * 
	 * @Decription 教师根据自己的预约信息查看未完成的学生
	 */
	@ResponseBody
	@RequestMapping(value = "/getPassOrderByAccount", method = RequestMethod.POST)
	public Pager<Order> getPassOrderByAccount(HttpSession session, @RequestParam("rows") Integer rows,
			@RequestParam("page") Integer page) {
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) {
				SystemContext.setPageOffset((page - 1) * rows);
			}
		}
		Long userAccount = (Long) session.getAttribute("userAccount");
		Pager<Order> allPagers = null;
		if (userAccount != null) {
			allPagers = orderService.getPassOrderByAccount(userAccount);
		}
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return allPagers;
	}

	@RequestMapping(value = "/myOrderInfo")
	public String myOrderInfo() {
		return "my-order-info";
	}
}
