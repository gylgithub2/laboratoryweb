package cn.gyl.laboratoryweb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.StuClass;
import cn.gyl.laboratoryweb.model.SystemContext;
import cn.gyl.laboratoryweb.model.Teacher;
import cn.gyl.laboratoryweb.service.DepartmentService;
import cn.gyl.laboratoryweb.service.StuClassService;
import cn.gyl.laboratoryweb.service.StudentService;
import cn.gyl.laboratoryweb.service.TeacherService;

/**
 * @Decription 有关学生班级的请求
 * @authorEmail 1076030424@qq.com
 */
@Controller
public class StuClassController {

	@Autowired
	private StuClassService stuClassService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;

	/**
	 * 
	 * @Decription 获取教师管理的班级信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getTeacherStuClass")
	public List<Map<String, String>> getTeacherStuClass(HttpSession session) {
		Long teacherAccount = Long.parseLong(session.getAttribute("userAccount") + "");
		List<StuClass> stuClasses = stuClassService.getTeacherStuClass(teacherAccount);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (StuClass s : stuClasses) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", s.getStuClassId() + "");
			map.put("text", s.getStuClassName());
			list.add(map);
		}
		return list;
	}

	@ResponseBody
	@RequestMapping(value = "/getStuClassName", produces = { "text/html;charset=UTF-8;", "application/json;" })
	public String getStuClassName(Long stuClassId) {
		StuClass stuClass = stuClassService.getStuClassByAccount(stuClassId);
		return stuClass.getStuClassName();
	}

	/**
	 * 
	 * @Decription 获取某个教师管理的班级信息源,用于教师页面展示
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllPageTeacherClasses", method = RequestMethod.POST)
	public Pager<StuClass> getAllPageTeacherClasses(@RequestParam("rows") Integer rows,
			@RequestParam("page") Integer page, HttpSession session) {
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) {
				SystemContext.setPageOffset((page - 1) * rows);
			}
		}
		Long teacherAccount = Long.parseLong(session.getAttribute("userAccount") + "");
		Pager<StuClass> allPagers = stuClassService.getAllPageTeacherClasses(teacherAccount);
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return allPagers;
	}

	/**
	 * 
	 * @Decription 获取班级信息源,用于管理员界面管理
	 */
	@ResponseBody
	@RequestMapping(value = "/getPageClasses", method = RequestMethod.POST)
	public Pager<StuClass> getAllPageClasses(@RequestParam("rows") Integer rows, @RequestParam("page") Integer page,
			@RequestParam(value = "stuClassName", required = false) String stuClassName,
			@RequestParam(value = "stuClassId", required = false) Long stuClassId,
			@RequestParam(value = "searchDepartment", required = false) Integer searchDepartment) {
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) {
				SystemContext.setPageOffset((page - 1) * rows);
			}
		}
		StuClass stuClass = new StuClass();
		if (stuClassName != null && !"".equals(stuClassName)) {
			stuClass.setStuClassName(stuClassName);
		}
		if (stuClassId != null) {
			stuClass.setStuClassId(stuClassId);
		}
		if (searchDepartment != null) {
			stuClass.setDepartment(searchDepartment);
		}
		Pager<StuClass> allPagers = stuClassService.getAllPageClasses(stuClass);
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return allPagers;
	}

	/**
	 * 
	 * @Decription 获取班级学院名
	 */
	@ResponseBody
	@RequestMapping(value = "/getClassDepartName", method = RequestMethod.GET, produces = { "text/html;charset=UTF-8;",
			"application/json;" })
	public String getClassDepartName(Integer departmentId) {
		return departmentService.getOne(departmentId).getDepartmentName();
	}

	/**
	 * 
	 * @Decription 跳转教师管理班级界面
	 */
	@RequestMapping(value = "/myClasses")
	public String myClasses() {
		return "teacher/t-classes-manager";
	}

	/**
	 * 
	 * @Decription 跳转班级管理界面、班级查看界面
	 */
	@RequestMapping("/classManager")
	public String classManager(HttpSession session) {
		String role = (String) session.getAttribute("role");
		if ("教师".equals(role)) {
			return "teacher/t-class-info";
		} else if ("管理员".equals(role)) {
			return "admin/class-manager";
		}
		return "error";
	}

	/**
	 * 
	 * @Decription 删除班级
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteClass", method = RequestMethod.GET)
	public String deleteClass(@RequestParam(value = "ids[]") int[] ids) {
		for (int i : ids) {
			StuClass stuClass = stuClassService.getOne(i);
			// 班级有学生则无法删除
			if (!studentService.getStudentByClass(stuClass.getStuClassId()).isEmpty()) {
				return "hasStudent";
			}
			//如果该空班级被老师关联了;则排开与老师的关联并删除
			Set<Teacher> teachers = stuClass.getTeachers();
			if (!teachers.isEmpty()) {
				for(Teacher teacher : teachers) {
					Set<StuClass> stuClasses = teacher.getStuClasses();
					//教师与班级的多对多关系仅给教师端维护,所以需要教师进行排开
					stuClasses.remove(stuClass);
					teacherService.update(teacher);
				}
			}
			stuClassService.delete(i);

		}
		return "ok";
	}
      /**
       *
       * @Decription 删除班级与老师之间的关系
       */
	@ResponseBody
	@RequestMapping(value = "/deleteMyClass", method = RequestMethod.GET)
	public String deleteMyClass(@RequestParam(value = "ids[]") int[] ids, HttpSession session) {
		Long teacherAccount = (Long) session.getAttribute("userAccount");
		Teacher teacher = teacherService.getTeacherByAccount(teacherAccount);
		Set<StuClass> stuClasses = teacher.getStuClasses();
		for (int i : ids) {
			stuClasses.remove(stuClassService.getOne(i));
		}
		teacherService.update(teacher);
		return "ok";
	}

	/**
	 * 
	 * @Decription 增加班级信息
	 */
	@ResponseBody 
	@RequestMapping(value = "/addClass", method = RequestMethod.POST)
	public String addClass(@RequestBody StuClass stuClass) {
		stuClass.setStuNum(0);
		stuClassService.insert(stuClass);
		return "ok";
	}

	/**
	 * 
	 * @Decription 增加教师管理的班级
	 */
	@ResponseBody 
	@RequestMapping(value = "/addManagerClass", method = RequestMethod.GET)
	public String addManagerClass(@RequestParam(value = "stuClassPKID") Integer stuClassPKID, HttpSession session) {
		System.out.println(stuClassPKID);
		StuClass stuClass = stuClassService.getOne(stuClassPKID);
		Long teacherAccount = (Long) session.getAttribute("userAccount");
		Teacher teacher = teacherService.getTeacherByAccount(teacherAccount);
		Set<StuClass> stuClasses = teacher.getStuClasses();
		stuClasses.add(stuClass);
		teacherService.update(teacher);
		return "ok";
	}

	/**
	 * 
	 * @Decription 更新班级
	 */
	@ResponseBody
	@RequestMapping(value = "/updateClass", method = RequestMethod.POST)
	public String updateClass(@RequestBody StuClass stuClass) {
		stuClassService.update(stuClass);
		return "ok";
	}

}
