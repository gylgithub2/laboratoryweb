package cn.gyl.laboratoryweb.controller;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gyl.laboratoryweb.model.Admin;
import cn.gyl.laboratoryweb.model.Notice;
import cn.gyl.laboratoryweb.model.Order;
import cn.gyl.laboratoryweb.model.Student;
import cn.gyl.laboratoryweb.model.Teacher;
import cn.gyl.laboratoryweb.service.AdminService;
import cn.gyl.laboratoryweb.service.NoticeService;
import cn.gyl.laboratoryweb.service.OrderService;
import cn.gyl.laboratoryweb.service.StudentService;
import cn.gyl.laboratoryweb.service.TeacherService;

/**
 * @Decription 登录请求信息的处理
 * @author gyl Email:1076030424@qq.com
 * @version 1.0
 * @date 2020年2月21日下午2:20:54
 *
 */
@Controller
public class LoginController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = { "", "/", "/homePage" }, method = RequestMethod.GET)
	public String gotoIndex() {
		return "homePage";
	}
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String loginView() {
		return "login";
	}

	/**
	 * 
	 * @Decription 登录验证
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(HttpServletRequest request, String userAccount, String password, String status, HttpSession session,
			HttpServletResponse response) {
		int statusNum;
		Long userAccountNum;
		List<Notice> notices = noticeService.getAll();
		session.setAttribute("notices", notices);
		try {
			statusNum = Integer.parseInt(status);
			userAccountNum = Long.parseLong(userAccount);
		} catch (NumberFormatException e) {
			return "0";
		}
		if (statusNum == 1) {
			Student student = studentService.login(userAccountNum, password);
			if (student == null) {
				return "0";
			}
			if (student.getStatus() != 1 && student.getStatus() != 2) {
				return "4";
			}
			Map<String, String> map = new HashMap<>();
			int studentNowOrderNum = orderService.getStudentNowOrderNum(userAccountNum, student.getStuClass());
			int studentOrderNum = orderService.getStudentOrderNum(userAccountNum, student.getStuClass());
			List<Order> rows = orderService.getStudentNowOrder(userAccountNum, student.getStuClass());
			session.setAttribute("stuNowOrder", rows);
			map.put("orderNumber", studentNowOrderNum + "");
			map.put("allOrderNumber", studentOrderNum + "");
			map.put("absenceNumber", student.getAbsenceTime() + "");
			map.put("lateNumber", student.getLateTime() + "");
			map.put("violateScore", student.getViolateScore() + "");
			session.setAttribute("stuInfoMap", map);
			session.setAttribute("user", student);
			session.setAttribute("userName", student.getStudentName());
			session.setAttribute("role", "学生");
			session.setAttribute("userAccount", student.getStudentAccount());
		} else if (statusNum == 2) {
			Teacher teacher = teacherService.login(userAccountNum, password);
			if (teacher == null) {
				return "0";
			}
			Map<String, String> map = new HashMap<>();
			int teacherOrderNum = orderService.getTeacherOrderNum(userAccountNum);
			List<Order> rows = orderService.getTeacherNowOrder(userAccountNum);
			map.put("orderNumber", rows.size() + "");
			map.put("allOrderNumber", teacherOrderNum + "");
			map.put("classNum", teacher.getStuClasses().size()+"");
			session.setAttribute("teacherNowOrder", rows);
			session.setAttribute("teaInfoMap", map);
			session.setAttribute("user", teacher);
			session.setAttribute("userName", teacher.getTeacherName());
			session.setAttribute("role", "教师");
			session.setAttribute("userAccount", teacher.getTeacherAccount());
		} else if (statusNum == 3) {
			Admin admin = adminService.login(userAccountNum, password);
			if (admin == null) {
				return "0";
			}
			Map<String, String> map = new HashMap<>();

			map.put("os", System.getProperty("os.name"));
			map.put("osVersion", System.getProperty("os.version"));
			map.put("systemUser", System.getProperty("user.name"));
			map.put("jdkVersion", System.getProperty("java.version"));
			map.put("tempFilePath", System.getProperty("java.io.tmpdir"));
			map.put("filePath",  request.getSession().getServletContext().getRealPath("/resources"));
			session.setAttribute("msgPage", 0);
			session.setAttribute("systemInfo", map);
			session.setAttribute("user", admin);
			session.setAttribute("userName", admin.getAdminName());
			session.setAttribute("role", "管理员");
			session.setAttribute("userAccount", admin.getAdminAccount());
		} else {
			return "0";
		}
		return status;
	}

	/**
	 * 
	 * @Decription 学生界面
	 */
	@RequestMapping(value = "/studentPage")
	public String studentPage() {
		return "student/studentPage";
	}

	/**
	 * 
	 * @Decription 教师界面
	 */
	@RequestMapping(value = "/teacherPage")
	public String teacherPage() {
		return "teacher/teacherPage";
	}

	/**
	 * 
	 * @Decription 管理员界面
	 */
	@RequestMapping(value = "/adminPage")
	public String adminPage() {
		return "admin/adminPage";
	}

	/**
	 * 
	 * @Decription 验证码设置
	 */
	@ResponseBody
	@RequestMapping(value = "/getCheckWord")
	public String getCheckWord(HttpServletRequest hsr) {
		HttpSession session = hsr.getSession();
		String checkWord = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
		session.removeAttribute(KAPTCHA_SESSION_KEY);
		return checkWord;
	}

}
