package cn.gyl.laboratoryweb.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gyl.laboratoryweb.model.Laboratory;
import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.SystemContext;
import cn.gyl.laboratoryweb.service.AttendanceService;
import cn.gyl.laboratoryweb.service.LaboratoryService;

/**
 * @Decription 用于处理有关实验室数据的请求
 * @authorEmail 1076030424@qq.com
 */

@Controller
public class LaboratoryController {

	@Autowired
	private LaboratoryService laboratoryService;

	@Autowired
	private AttendanceService attendanceService;

	/**
	 * 
	 * @Decription 返回管理员实验室管理界面
	 */
	@RequestMapping(value = "laboratoryManager")
	public String laboratoryManager() {
		return "admin/laboratory-manager";
	}

	/**
	 * 
	 * @Decription 返回学生以及老师的不同的实验室信息界面
	 */
	@RequestMapping(value = "laboratoryInfo")
	public String laboratoryInfo(HttpSession session) {
		if ("教师".equals(session.getAttribute("role"))) {
			return "teacher/t-laboratory-info";
		}
		return "student/laboratory-info";
	}

	/**
	 * 
	 * @Decription 获取实验室数据源
	 */
	@ResponseBody
	@RequestMapping(value = "/getPagerLaboratorys", method = RequestMethod.POST)
	public Pager<Laboratory> getAllPager(@RequestParam("rows") Integer rows, @RequestParam("page") Integer page,
			@RequestParam(value = "laboratoryName", required = false) String laboratoryName) {

		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) {
				SystemContext.setPageOffset((page - 1) * rows);
			}
		}
		Pager<Laboratory> allPagers = laboratoryService.getAllPageLaboratorys(laboratoryName);
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return allPagers;
	}

	/**
	 * 
	 * @Decription 获取所有实验室数据
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllLaboratory", method = RequestMethod.POST)
	public List<Map<String, String>> getAllLaboratory() {
		List<Laboratory> Laboratorys = laboratoryService.getAllLaboratory();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		for (Laboratory laboratory : Laboratorys) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", laboratory.getLaboratoryPKID() + "");
			map.put("text", laboratory.getLaboratoryName());
			list.add(map);
		}
		return list;
	}

	/**
	 * 
	 * @Decription 更新实验室信息
	 */
	@ResponseBody
	@RequestMapping(value = "/updateLaboratory", method = RequestMethod.POST)
	public String updateLaboratory(@RequestBody Laboratory laboratory) {
		System.out.println(laboratory.getLaboratoryPKID());
		laboratoryService.update(laboratory);
		return "ok";
	}

	/**
	 * 
	 * @Decription 删除实验室
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteLaboratory", method = RequestMethod.GET)
	public String deleteLaboratory(@RequestParam(value = "ids[]") int[] ids) {
		for (int i : ids) {
			laboratoryService.delete(i);
		}
		return "ok";
	}

	/**
	 * 
	 * @Decription 增加实验室
	 */
	@ResponseBody
	@RequestMapping(value = "/addLaboratory", method = RequestMethod.POST)
	public String addLaboratory(@RequestBody Laboratory laboratory) {
		try {
			laboratoryService.insert(laboratory);
		} catch (Exception e) {
			return "error";
		}
		return "ok";
	}
	@ResponseBody
	@RequestMapping(value = "/getLabList", method = RequestMethod.GET)
	public List<Laboratory> getLabList() {
		return  laboratoryService.getAllLaboratory();
	}

	@ResponseBody
	@RequestMapping(value = "/getLabRankList", method = RequestMethod.GET)
	public List<Laboratory> getLabRankList() {
		List<Laboratory> allLaboratory = laboratoryService.getAllLaboratory();
		Map<Laboratory, Integer> map = new HashMap<>();
		for (Laboratory lab : allLaboratory) {
			int i = attendanceService.getLabUseTime(lab.getLaboratoryId());
			int time = i * 2;
			map.put(lab, time);
		}
		List<Map.Entry<Laboratory, Integer>> entryList1 = new ArrayList<Map.Entry<Laboratory, Integer>>(map.entrySet());
		Collections.sort(entryList1, new Comparator<Map.Entry<Laboratory, Integer>>() {
			@Override
			public int compare(Entry<Laboratory, Integer> me1, Entry<Laboratory, Integer> me2) {
				return me2.getValue().compareTo(me1.getValue()); // 升序排序
			}
		});
		List<Laboratory> list = new ArrayList<>();
		for (int i = 0; i < (entryList1.size()>4?4:entryList1.size()); i++) {
			list.add(entryList1.get(i).getKey());
		}
		return list;
	}

	@ResponseBody
	@RequestMapping(value = "/getLabTime", method = RequestMethod.GET)
	public Integer getLabTime(Long id) {
		return attendanceService.getLabUseTime(id)*2;
	}
	@ResponseBody
	@RequestMapping(value = "/getLabName", method = RequestMethod.GET, produces = { "text/html;charset=UTF-8;",
			"application/json;" })
	public String getLabName(Long labId) {
		Laboratory laboratory = null;
		if (labId != null) {
			laboratory = laboratoryService.getOneByLabId(labId);
		}
		return laboratory.getLaboratoryName();
	}

	/**
	 * 
	 * @Decription 预约实验室时,保存被预约实验室的信息
	 */
	@ResponseBody
	@RequestMapping(value = "/saveOrderData", method = RequestMethod.GET)
	public String saveLoratoryId(HttpSession session, Integer labId, String laboratoryName, Long laboratoryId) {
		session.setAttribute("labId", labId);
		session.setAttribute("laboratoryName", laboratoryName);
		session.setAttribute("laboratoryId", laboratoryId);
		return "ok";
	}
}
