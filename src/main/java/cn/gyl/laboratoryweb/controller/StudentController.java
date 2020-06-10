package cn.gyl.laboratoryweb.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.StuClass;
import cn.gyl.laboratoryweb.model.Student;
import cn.gyl.laboratoryweb.model.SystemContext;
import cn.gyl.laboratoryweb.service.StuClassService;
import cn.gyl.laboratoryweb.service.StudentService;
import cn.gyl.laboratoryweb.utils.CheckUtils;
import cn.gyl.laboratoryweb.utils.PasswordSecurity;

/**
 * @Decription 有关学生的请求处理
 * @authorEmail 1076030424@qq.com
 */
@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private StuClassService stuClassService;

	/**
	 * 
	 * @Decription 返回学生页面
	 */
	@RequestMapping("/studentManager")
	public String studentManager() {
		return "admin/student-manager";
	}

	/**
	 * 
	 * @Decription 列表数据提供
	 */
	@ResponseBody
	@RequestMapping(value = "/getPagerStudents", method = RequestMethod.POST)
	public Pager<Student> getPagerStudents(@RequestParam("rows") Integer rows, @RequestParam("page") Integer page,
			@RequestParam(value = "studentAccount", required = false) Long studentAccount,
			@RequestParam(value = "studentName", required = false) String studentName,
			@RequestParam(value = "classn", required = false) String classn) {
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) SystemContext.setPageOffset((page - 1) * rows);
		}
		Long classId = null;//使用学生班级的账号查询
		if (classn != null && !"".equals(classn)) {
			boolean flag = CheckUtils.isLong(classn);
			if (flag) {
				classId = Long.parseLong(classn);
			} else {
				StuClass stuClass = stuClassService.getClassByName(classn);
				if (stuClass != null) classId = stuClass.getStuClassId();
			}
		}
		Student student = new Student();//模糊查询数据注入对象
		if (studentName != null || !"".equals(studentName)) student.setStudentName(studentName);
		if (studentAccount != null) student.setStudentAccount(studentAccount);
		Pager<Student> allPagers = studentService.getAllPageStudents(student, classId);
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return allPagers;
	}

	/**
	 * 
	 * @Decription 学生修改密码
	 */
	@ResponseBody
	@RequestMapping(value = "/checkStudentPsword", method = RequestMethod.POST)
	public boolean checkPassword(String userAccount, String password, String newPassword) {
		try {
			Student student = studentService.getStudentByAccount(Long.parseLong(userAccount));
			if (!student.getStudentPassword().equals(PasswordSecurity.MD5(student.getStudentName(), password))) {
				return false;
			}
			student.setStudentPassword(PasswordSecurity.MD5(student.getStudentName(), newPassword));
			studentService.update(student);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @Decription 修改学生并选择更新班级信息
	 */
	@ResponseBody
	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public String updateStudent(@RequestBody Student student) {
		String flag = checkStudent(student, 0);
		if (!"ok".equals(flag)) {
			return flag;
		}
		if (student.getStudentPassword() == null || "".equals(student.getStudentPassword())) {
			Student oldOne = studentService.getOne(student.getStudentPKID());
			if (!student.getStudentName().equals(oldOne.getStudentName())) {
				return "nameFalse";
			}
			student.setStudentPassword(oldOne.getStudentPassword());
		} else {
			String password = PasswordSecurity.MD5(student.getStudentName(), student.getStudentPassword());
			student.setStudentPassword(password);
		}
		Student oldStudent = studentService.getOne(student.getStudentPKID());
		if (oldStudent.getStuClass() != student.getStuClass()) {
			StuClass oldStuClass = stuClassService.getStuClassByAccount(oldStudent.getStuClass());
			StuClass newStuClass = stuClassService.getStuClassByAccount(student.getStuClass());
			int oldStuClassStuNum = oldStuClass.getStuNum();
			int newStuClassStuNum = newStuClass.getStuNum();
			oldStuClass.setStuNum(oldStuClassStuNum - 1);
			newStuClass.setStuNum(newStuClassStuNum + 1);
			stuClassService.update(oldStuClass);
			stuClassService.update(newStuClass);
		}
		sessionFactory.getCurrentSession().clear();
		studentService.update(student);
		return "ok";
	}

	/**
	 * 
	 * @Decription 删除学生并更新班级信息
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public String deleteStudent(@RequestParam(value = "ids[]") int[] ids) {
		for (int i : ids) {
			Student student = studentService.getOne(i);
			StuClass stuClass = stuClassService.getStuClassByAccount(student.getStuClass());
			int stuNum = stuClass.getStuNum();
			stuClass.setStuNum(stuNum - 1);
			stuClassService.update(stuClass);
			studentService.delete(i);
		}
		return "ok";
	}

	/**
	 * 
	 * @Decription 添加学生,并更新班级信息
	 */
	@ResponseBody
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@RequestBody Student student) {
		String flag = checkStudent(student, 1);
		if (!"ok".equals(flag)) {
			return flag;
		}
		String password = PasswordSecurity.MD5(student.getStudentName(), student.getStudentPassword());
		student.setStudentPassword(password);
		student.setAbsenceTime(0);
		student.setLateTime(0);
		student.setViolateScore(0);
		student.setStatus(1);
		StuClass stuClass = stuClassService.getStuClassByAccount(student.getStuClass());
		int stuNum = stuClass.getStuNum();
		stuClass.setStuNum(stuNum + 1);
		stuClassService.update(stuClass);
		try {
			studentService.insert(student);
		} catch (Exception e) {
			return "error";
		}
		return "ok";
	}

	/**
	 * 
	 * @Decription 返回学生主页界面
	 */
	@RequestMapping(value = "/student/index")
	public String studentIndex() {
		return "student/stu-index";
	}

	/**
	 * 
	 * @Decription 返回未预习的学生界面
	 */
	@RequestMapping(value = "unPreStudyStu")
	public String unPreStudyStu() {
		return "teacher/unPreStudyStu";
	}

	/**
	 * 
	 * @Decription 返回学习记录信息
	 */
	@RequestMapping(value = "studyRecord")
	public String studyRecord() {
		return "teacher/t-study-record";
	}

	public String checkStudent(Student student, int i) {
		boolean checkPasswordStandard = CheckUtils.checkPasswordStandard(student.getStudentPassword());
		if (i == 0 && ("".equals(student.getStudentPassword()) || student.getStudentPassword() == null)) {
			checkPasswordStandard = true;
		}
		if (!checkPasswordStandard) {
			return "wrongPassword";
		}
		StuClass stuClass = stuClassService.getStuClassByAccount(student.getStuClass());
		if (stuClass == null) {
			return "wrongClass";
		}
		if (i == 1) {
			if (studentService.getStudentByAccount(student.getStudentAccount()) != null) {
				return "wrongAccount";
			}
		}
		return "ok";
	}
}
