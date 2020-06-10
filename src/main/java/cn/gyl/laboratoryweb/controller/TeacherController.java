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

import cn.gyl.laboratoryweb.model.Department;
import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.SystemContext;
import cn.gyl.laboratoryweb.model.Teacher;
import cn.gyl.laboratoryweb.service.DepartmentService;
import cn.gyl.laboratoryweb.service.TeacherService;
import cn.gyl.laboratoryweb.utils.CheckUtils;
import cn.gyl.laboratoryweb.utils.PasswordSecurity;

/**
 * @Decription 处理涉及教师信息操作的控制器
 * @authorEmail 1076030424@qq.com
 */
@Controller
public class TeacherController {

	@Autowired
	TeacherService teacherService;

	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "/teacherOrder")
	public String teacherOrder() {
		return "teacher/teacherOrder";
	}
	
	@RequestMapping(value = "/teacherIndex")
	public String teacherIndex() {
		return "teacher/teacher-index";
	}

	@RequestMapping(value = "/teacherManager")
	public String teacherManager() {
		return "admin/teacher-manager";
	}

	// 删除用户
	@ResponseBody
	@RequestMapping(value = "/deleteTeacher", method = RequestMethod.GET)
	public String deleteTeacher(@RequestParam(value = "ids[]") int[] ids) {
		for (int i : ids) {
			teacherService.delete(i);
		}
		return "ok";
	}

	@ResponseBody
	@RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
	public String addTeacher(Integer departmentId, Integer id, Integer status, String teacherName, Long teacherAccount,
			String teacherPassword) {
		boolean idOKPsword = CheckUtils.checkPasswordStandard(teacherPassword);
		if (!idOKPsword) {
			return "wrongPassword";
		}
		Teacher teacher = new Teacher();
		String password = PasswordSecurity.MD5(teacherName, teacherPassword);
		teacher.setTeacherPassword(password);
		teacher.setTeacherName(teacherName);
		teacher.setTeacherAccount(teacherAccount);
		teacher.setStatus(status);
		teacher.setDepartment(departmentService.getOne(departmentId));
		teacherService.insert(teacher);
		return "ok";
	}

	@ResponseBody
	@RequestMapping(value = "/getPagerTeachers", method = RequestMethod.POST)
	public Pager<Teacher> getPagerTeachers(@RequestParam("rows") Integer rows, @RequestParam("page") Integer page,
			@RequestParam(value = "teacherAccount", required = false) Long userAccount,
			@RequestParam(value = "teacherName", required = false) String userName,
			@RequestParam(value = "searchDepartment", required = false) Integer departmentId) {
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) {
				SystemContext.setPageOffset((page - 1) * rows);
			}
		}
		Teacher teacher = new Teacher();
		if (userName != null || !"".equals(userName))
			teacher.setTeacherName(userName);
		if (userAccount != null)
			teacher.setTeacherAccount(userAccount);
		if (departmentId != null)
			teacher.setDepartment(departmentService.getOne(departmentId));
		Pager<Teacher> allPagers = teacherService.getAllPageTeachers(teacher);
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return allPagers;
	}

	@ResponseBody
	@RequestMapping(value = "/getAllDepartments", method = RequestMethod.POST)
	public List<Map<String, String>> getAllDepartments() {
		List<Department> departments = departmentService.getAllDepartment();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (Department department : departments) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", department.getDepartmentPKID() + "");
			map.put("text", department.getDepartmentName());
			list.add(map);
		}
		return list;
	}

	@ResponseBody
	@RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
	public String updateTeacher(Integer departmentId, Integer id, Integer status, String teacherName,
			Long teacherAccount, String teacherPassword) {
		Teacher teacher = teacherService.getOne(id);
		if (teacherPassword == null || "".equals(teacherPassword)) {
			Teacher oldOne = teacherService.getOne(teacher.getTeacherPKID());
			teacher.setTeacherPassword(oldOne.getTeacherPassword());
		} else {
			boolean idOKPsword = CheckUtils.checkPasswordStandard(teacherPassword);
			if (!idOKPsword) {
				return "wrongPassword";
			}
			String password = PasswordSecurity.MD5(teacher.getTeacherName(), teacher.getTeacherPassword());
			teacher.setTeacherPassword(password);
		}
		teacher.setTeacherName(teacherName);
		teacher.setStatus(status);
		teacher.setTeacherAccount(teacherAccount);
		teacher.setDepartment(departmentService.getOne(departmentId));
		teacherService.update(teacher);
		return "ok";
	}

	@ResponseBody
	@RequestMapping(value = "/getTeacherDepart", method = RequestMethod.GET)
	public Map<String, String> getTeacherDepart(Integer teacherId) {
		Teacher teacher = teacherService.getOne(teacherId);
		Department department = teacher.getDepartment();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", department.getDepartmentPKID() + "");
		map.put("text", department.getDepartmentName());
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/getTeacherName", method = RequestMethod.GET)
	public String getTeacherName(Long teacherAccount) {
		Teacher teacher = teacherService.getTeacherByAccount(teacherAccount);
		if (teacher != null) {
			return teacher.getTeacherName();
		} else {

			return null;
		}
	}
	/**
	 * 
	 * @Decription 教师修改密码
	 */
	@ResponseBody
	@RequestMapping(value = "/checkTeacherPsword", method = RequestMethod.POST)
	public boolean checkPassword(String userAccount, String password, String newPassword) {
		try {
			Teacher teacher = teacherService.getTeacherByAccount(Long.parseLong(userAccount));
			if (!teacher.getTeacherPassword().equals(PasswordSecurity.MD5(teacher.getTeacherName(), password))) {
				return false;
			}
			teacher.setTeacherPassword(PasswordSecurity.MD5(teacher.getTeacherName(), newPassword));
			teacherService.update(teacher);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
