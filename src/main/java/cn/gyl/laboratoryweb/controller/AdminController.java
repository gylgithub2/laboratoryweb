package cn.gyl.laboratoryweb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gyl.laboratoryweb.model.Admin;
import cn.gyl.laboratoryweb.model.Attendance;
import cn.gyl.laboratoryweb.model.Laboratory;
import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.Student;
import cn.gyl.laboratoryweb.model.SystemContext;
import cn.gyl.laboratoryweb.model.Teacher;
import cn.gyl.laboratoryweb.model.TimeSection;
import cn.gyl.laboratoryweb.service.AdminService;
import cn.gyl.laboratoryweb.service.AttendanceService;
import cn.gyl.laboratoryweb.service.LaboratoryService;
import cn.gyl.laboratoryweb.service.StudentService;
import cn.gyl.laboratoryweb.service.TeacherService;
import cn.gyl.laboratoryweb.service.TimeSectionService;
import cn.gyl.laboratoryweb.utils.PasswordSecurity;

/**
 * @Decription 主要用于处理管理员页面的请求,以及设计管理员数据的请求
 * @author gyl Email:1076030424@qq.com
 * @version 1.0
 * @date 2020年2月21日下午2:19:25
 *
 */
@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private LaboratoryService laboratoryService;
	@Autowired
	private AttendanceService attendanceService;
	@Autowired
	private TimeSectionService timeSectionService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;

	@ResponseBody
	@RequestMapping(value = "/getalladmin", method = RequestMethod.POST)
	public List<Admin> getAllAdmins() {
		List<Admin> allAdmin = adminService.getAllAdmins();
		return allAdmin;
	}

	/**
	 * 
	 * @Decription 统计信息界面
	 */
	@RequestMapping(value = "/statisticsInfo")
	public String statisticsInfo() {
		return "admin/a-tatistics-info";
	}

	@RequestMapping(value = "/exit")
	public String exit() {
		return "exit";
	}

	@RequestMapping("/adminIndex")
	public String mainIndex() {
		return "admin/admin-index";
	}

	/**
	 * 
	 * @Decription 检查用户和密码,修改密码
	 */
	@ResponseBody
	@RequestMapping(value = "/checkAdminPsword", method = RequestMethod.POST)
	public boolean checkPassword(String userAccount, String password, String newPassword) {
		try {
			Admin admin = adminService.getAdminByAccount(Long.parseLong(userAccount));
			if (!admin.getAdminPassword().equals(PasswordSecurity.MD5(admin.getAdminName(), password))) {
				return false;
			}
			admin.setAdminPassword(PasswordSecurity.MD5(admin.getAdminName(), newPassword));
			adminService.update(admin);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @Decription 统计信息数据源
	 */
	@ResponseBody
	@RequestMapping(value = "/searchStatistic")
	public Pager<Map<String, String>> searchStatistic(
			@RequestParam("rows") Integer rows,
			@RequestParam("page") Integer page, 
			@RequestParam(value = "id") Integer id,
			@RequestParam(value = "date") String date, 
			@RequestParam(value = "timesectionId") Integer timesectionId,
			@RequestParam(value = "account", required = false) Long account) {
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);//线程变量记录请求数据条数
			if (page != null && page > 0) SystemContext.setPageOffset((page - 1) * rows);
		}
		List<Map<String, String>> listmap = new ArrayList<Map<String, String>>();
		TimeSection timesection = timeSectionService.getOne(timesectionId);
		String searcherDateTime = date + " " + timesection.getStartTime() + ":00";
		if (id == 1) {//三种情况分别调用不同方法进行统计
			laboratoryStat(listmap, searcherDateTime, timesection, date);
		} else if (id == 2) {
			teacherStat(listmap, searcherDateTime, timesection, date);
		} else if (id == 3) {
			studentStat(listmap, searcherDateTime, timesection, date);
		}
		Pager<Map<String, String>> pager = new Pager<Map<String, String>>();//分页数据集合
		int size = listmap.size();
		pager.setTotal(size);//数据总数
		List<Map<String, String>> pageList = new ArrayList<Map<String, String>>();
		for (int i = rows * (page - 1); i < size; i++) {	// 分页处理
			pageList.add(listmap.get(i));
			if (rows-- == 0) break;
		}
		pager.setRows(pageList);
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return pager;
	}

	/**
	 * @param listmap2
	 * @Decription
	 */
	private void studentStat(List<Map<String, String>> listmap, String searcherDateTime, TimeSection timesection,
			String date) {
		List<Student> studentList = studentService.getAllStudent();
		for (Student student : studentList) {
			Map<String, String> map = new HashMap<String, String>();
			double statisticnum = 0;
			Attendance attendance = attendanceService.getAttendanceByStu(searcherDateTime, student.getStudentAccount());
			map.put("timesection", timesection.getStartTime() + "-" + timesection.getEndTime());
			map.put("studentName", student.getStudentName());
			map.put("studentAccount", student.getStudentAccount() + "");
			map.put("date", date + "");
			if (attendance == null) {
				map.put("statisticnum", statisticnum + "");
				listmap.add(map);
				continue;
			}
			statisticnum = statusDeal(attendance);
			map.put("statisticnum", statisticnum + "");
			listmap.add(map);
		}
	}

	/**
	 *
	 * @Decription 对出席的信息进行状态筛选,计算该条信息的人时数
	 */
	private double statusDeal(Attendance attendance) {
		Integer status = attendance.getStatus();
		if (status == 2) {
			return 2;
		} else if (status == 1) {
			double endTime = attendance.getEndDate().getTime();
			double punchTime = attendance.getPunchDate().getTime();
			double hour = (endTime - punchTime) / 1000 / 60 / 60;
			return hour;
		} else {
			return 0;
		}
	}

	/**
	 * @param listmap2
	 * @Decription
	 */
	private void teacherStat(List<Map<String, String>> listmap, String searcherDateTime, TimeSection timesection,
			String date) {
		List<Teacher> teacherLists = teacherService.getAllTeacher();
		for (Teacher teacher : teacherLists) {
			Map<String, String> map = new HashMap<String, String>();
			double statisticnum = 0;
			List<Attendance> attendances = attendanceService.getAttendanceByTea(searcherDateTime,
					teacher.getTeacherAccount());
			for (Attendance attendance : attendances) {
				statisticnum += statusDeal(attendance);
			}
			statisticnum = ((double) ((int) (statisticnum * 1000))) / 1000;
			map.put("statisticnum", statisticnum + "");
			map.put("timesection", timesection.getStartTime() + "-" + timesection.getEndTime());
			map.put("teacherName", teacher.getTeacherName());
			map.put("teacherAccount", teacher.getTeacherAccount() + "");
			map.put("date", date + "");
			listmap.add(map);

		}
	}

	/**
	 *
	 * @param listmap 0-x
	 * @Decription
	 */
	private void laboratoryStat(List<Map<String, String>> listmap, String searcherDateTime, TimeSection timesection,
			String date) {
		List<Laboratory> allLaboratorys = laboratoryService.getAllLaboratory();
		for (Laboratory laboratory : allLaboratorys) {
			Map<String, String> map = new HashMap<String, String>();
			double statisticnum = 0;
			List<Attendance> attendances = attendanceService.getAttendanceByLab(searcherDateTime,
					laboratory.getLaboratoryId());
			for (Attendance attendance : attendances) {
				statisticnum += statusDeal(attendance);
			}
			statisticnum = ((double) ((int) (statisticnum * 1000))) / 1000;
			map.put("statisticnum", statisticnum + "");
			map.put("timesection", timesection.getStartTime() + "-" + timesection.getEndTime());
			map.put("laboratoryName", laboratory.getLaboratoryName() + "");
			map.put("laboratoryId", laboratory.getLaboratoryId() + "");
			map.put("date", date + "");
			listmap.add(map);
		}
	}

}
