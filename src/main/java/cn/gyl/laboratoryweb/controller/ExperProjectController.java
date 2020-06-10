package cn.gyl.laboratoryweb.controller;

import java.util.ArrayList;
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

import cn.gyl.laboratoryweb.model.ExperimentalProject;
import cn.gyl.laboratoryweb.model.Order;
import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.Student;
import cn.gyl.laboratoryweb.model.SystemContext;
import cn.gyl.laboratoryweb.service.ExperProjectService;
import cn.gyl.laboratoryweb.service.LaboratoryService;
import cn.gyl.laboratoryweb.service.OrderService;
import cn.gyl.laboratoryweb.service.StuClassService;
import cn.gyl.laboratoryweb.service.StudentService;

/**
 * @Decription 主要用于有关实验项目的数据请求
 * @authorEmail 1076030424@qq.com
 */
@Controller
public class ExperProjectController {
	
	@Autowired
	private LaboratoryService laboratoryService;
	@Autowired
	private ExperProjectService experProjectService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private StuClassService stuClassService;
	@Autowired
	private OrderService orderService;
	
	/**
	 * 
	 * @Decription 实验项目查看,根据不同的角色返回界面
	 */
	@RequestMapping("/experProjectManager")
	public String experProjectManager(HttpSession session) {
		if("教师".equals(session.getAttribute("role"))) {
		
			return "teacher/t-experProject-manager";
		}
		return "admin/experProject-manager";
	}
	/**
	 * 
	 * @Decription 返回学生要做的项目界面
	 */
	@RequestMapping("/myExperProject")
	public String myExperProject(HttpSession session) {
		return "student/stu-myExperProject";
	}
	/**
	 * 
	 * @Decription 返回学生端所有项目信息界面
	 */
	@RequestMapping("/experProjectInfo")
	public String experProjectInfo(HttpSession session) {
		return "student/s-experProject-Info";
	}
	
	/**
	 * 
	 * @Decription 所有项目信息展示数据源
	 */
	@ResponseBody
	@RequestMapping(value = "/getPagerExperProjects", method = RequestMethod.POST)
	public Pager<ExperimentalProject> getPagerExperProjects(
			@RequestParam("rows") Integer rows, 
			@RequestParam("page") Integer page,
			@RequestParam(value = "experProjectName", required = false) String experProjectName) {
		
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) {
				SystemContext.setPageOffset((page - 1) * rows);
			}
		}
		Pager<ExperimentalProject> allPagers = experProjectService.getPagerExperimentalProjects(experProjectName);
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return allPagers;
	}
	
	/**
	 * 
	 * @Decription 学生项目信息展示数据源
	 */
	@ResponseBody
	@RequestMapping(value = "/getPagerStuExperProjects", method = RequestMethod.POST)
	public Pager<ExperimentalProject> getPagerStuExperProjects(
			HttpSession session,
			@RequestParam("rows") Integer rows, 
			@RequestParam("page") Integer page) {
		
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) {
				SystemContext.setPageOffset((page - 1) * rows);
			}
		}
		Long stuAccount = (Long)session.getAttribute("userAccount");
		Student studentByAccount = studentService.getStudentByAccount(stuAccount);
		Long stuClass = studentByAccount.getStuClass();
		Long stuClassId = stuClassService.getStuClassByAccount(stuClass).getStuClassId();
		Pager<Order>  pagerOrders= orderService.getOrderByClassId(stuClassId);
		Pager<ExperimentalProject> pager = new Pager<ExperimentalProject>();
		List<ExperimentalProject> lists = new ArrayList<ExperimentalProject>();
		int total = 0;
		List<Order> rows2 = pagerOrders.getRows();
		for(int i=0;i<rows2.size();i++) {
			lists.add(experProjectService.getOneByAccount(rows2.get(i).getExperProjectAccount()));
			total++;
		}
		pager.setRows(lists);
		pager.setTotal(total);
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return pager;
	}
	
	/***
	 * 
	 * @Decription 更新项目信息
	 */
	@ResponseBody
	@RequestMapping(value = "/updateExperProject", method = RequestMethod.POST)
	public String updateExperProject(String id,String experProjectName,String laboratoryId) {
		ExperimentalProject experimentalProject = experProjectService.getOne(Integer.parseInt(id));
		experimentalProject.setLaboratory(laboratoryService.getOne(Integer.parseInt(laboratoryId)));
		experimentalProject.setExperimentalProjectName(experProjectName);
		experProjectService.update(experimentalProject);
		return "ok";
	}
	@ResponseBody
	@RequestMapping(value = "/getExperPjtList", method = RequestMethod.GET)
	public List<ExperimentalProject> getExperPjtList(String id,String experProjectName,String laboratoryId) {
		return experProjectService.getAllExperimentalProjects();
	}
	
	/**
	 * 
	 * @Decription 删除项目信息
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteExperProject", method = RequestMethod.GET)
	public String deleteExperProject(@RequestParam(value="ids[]") int[] ids) {
		for(int i : ids) {
			experProjectService.delete(i);
		}
		return "ok";
	}
	
	/**
	 * 
	 * @Decription 增加项目信息
	 */
	@ResponseBody
	@RequestMapping(value="/addExperProject",method=RequestMethod.POST)
	public String addExperProject(String experProjectName,Integer laboratoryId,Long experId) {
		System.out.println(experProjectName+":"+laboratoryId);
		ExperimentalProject experimentalProject = new ExperimentalProject();
		experimentalProject.setExperimentalProjectName(experProjectName);
		experimentalProject.setExperimentalProjectId(experId);
		experimentalProject.setLaboratory(laboratoryService.getOne(laboratoryId));
		try {
			experProjectService.insert(experimentalProject);
		} catch (Exception e) {
			return "error";
		}
		return "ok";
	}
	
	/**
	 * 
	 * @Decription 获取指定实验室所含项目信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getExperProjectByLabId")
	public List<Map<String,String>> getExperProjectByLabId(HttpSession session) {
		Integer labId = (Integer)session.getAttribute("labId");
		if(labId == null) {
			return null;
		}
		List<ExperimentalProject> experimentalProjects = experProjectService.getExperProjectByLabId(labId);
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		
		for(ExperimentalProject experimentalProject:experimentalProjects) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("id", experimentalProject.getExperimentalProjectId()+"");
			map.put("text", experimentalProject.getExperimentalProjectName());
			list.add(map);
		}
		session.removeAttribute("labId");
		session.removeAttribute("laboratoryName");
		session.removeAttribute("laboratoryId");
		return list;
	}
	

}
