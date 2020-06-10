package cn.gyl.laboratoryweb.controller;

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

import cn.gyl.laboratoryweb.model.Admin;
import cn.gyl.laboratoryweb.model.LabRule;
import cn.gyl.laboratoryweb.model.Message;
import cn.gyl.laboratoryweb.model.Notice;
import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.Student;
import cn.gyl.laboratoryweb.model.SystemContext;
import cn.gyl.laboratoryweb.model.Teacher;
import cn.gyl.laboratoryweb.service.LabRuleService;
import cn.gyl.laboratoryweb.service.MessageService;
import cn.gyl.laboratoryweb.service.NoticeService;
import cn.gyl.laboratoryweb.service.StudentService;

/**
 * @Decription 处理消息数据的请求
 * @authorEmail 1076030424@qq.com
 */
@Controller
public class MessageController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private MessageService messageService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private LabRuleService labRuleService;

	/**
	 * 
	 * @Decription 学生申请解除对自己的封禁
	 */
	@ResponseBody
	@RequestMapping(value = "/stuAppeal")
	public String stuAppeal(@RequestParam(value = "appealText") String appealText, HttpSession session) {
		Student student = (Student) session.getAttribute("user");
		Integer status = student.getStatus();
		if (status == 1) {
			return "useless";
		}
		Message message = new Message();
		message.setMessageContent(appealText);
		message.setStatus(1);
		message.setMsgDate(new Date());
		message.setUserId(student.getStudentAccount());
		message.setMsgType(1);
		message.setUserRole("学生");
		message.setUserName(student.getStudentName());
		messageService.insert(message);
		return "ok";
	}

	/**
	 * 
	 * @Decription 留言消息存储
	 */
	@ResponseBody
	@RequestMapping(value = "/msgStore")
	public String msgStore(@RequestParam(value = "content") String content, HttpSession session) {

		String role = session.getAttribute("role") + "";
		String userName = "";
		Long userId = 0L;
		if ("教师".equals(role)) {
			Teacher teacher = (Teacher) session.getAttribute("user");
			userName = teacher.getTeacherName();
			userId = teacher.getTeacherAccount();
		} else if ("学生".equals(role)) {
			Student student = (Student) session.getAttribute("user");
			userName = student.getStudentName();
			userId = student.getStudentAccount();
		} else {
			return "fail";
		}
		Message message = new Message();
		message.setMessageContent(content);
		message.setStatus(1);
		message.setMsgDate(new Date());
		message.setUserId(userId);
		message.setMsgType(0);
		message.setUserRole(role);
		message.setUserName(userName);
		messageService.insert(message);
		return "ok";
	}

	/**
	 * 
	 * @Decription 消息回复
	 */
	@ResponseBody
	@RequestMapping(value = "/returnMSG")
	public String returnMSG(@RequestParam(value = "content") String content, @RequestParam(value = "id") Integer id,
			HttpSession session) {
		String role = session.getAttribute("role") + "";
		String userName = "";
		Long userId = 0L;
		Admin admin = (Admin) session.getAttribute("user");
		userName = admin.getAdminName();
		userId = admin.getAdminAccount();
		Message one = messageService.getOne(id);
		if (one.getStatus() == 3) {
			return "fail";
		}
		one.setStatus(3);
		messageService.update(one);
		Message message = new Message();
		message.setMessageContent(content);
		message.setStatus(1);
		message.setMsgDate(new Date());
		message.setUserId(userId);
		message.setMsgType(id + 1);
		message.setUserRole(role);
		message.setUserName(userName);
		messageService.insert(message);
		return "ok";
	}

	/**
	 * 
	 * @Decription 动态查看消息信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getMsgContent", method = RequestMethod.GET, produces = { "text/html;charset=UTF-8;",
			"application/json;" })
	public String getMsgContent(@RequestParam(value = "id") Integer id) {
		Message message = messageService.getOne(id);
		return message.getMessageContent();
	}

	@ResponseBody
	@RequestMapping(value = "/findMsg", method = RequestMethod.GET)
	public String findMsg() {
		List<Message> messages = messageService.getNewMsg();
		if (messages.size() > 0) {
			return "ok";
		}
		return "fail";
	}
	@ResponseBody
	@RequestMapping(value = "/findUserMsg", method = RequestMethod.GET)
	public String findUserMsg(HttpSession session) {
		String role = session.getAttribute("role")+"";
		Long userId=0L;
		if("教师".equals(role)) {
			Teacher teacher= (Teacher)session.getAttribute("user");
			userId = teacher.getTeacherAccount();
		}else if("学生".equals(role)){
			Student student= (Student)session.getAttribute("user");
			userId = student.getStudentAccount();
		}else {
			return "fail";
		}
		List<Message> messages = messageService.getUserNewMsg(userId);
		if (messages.size() > 0) {
			return "ok";
		}
		return "fail";
	}

	/**
	 * 
	 * @Decription 管理员阅读信息,并把学生的状态设为正常
	 */
	@ResponseBody
	@RequestMapping(value = "/relieveForbidden", method = RequestMethod.GET)
	public String relieveForbidden(@RequestParam(value = "id") Integer id, HttpSession session) {
		Message message = messageService.getOne(id);
		Long userId = message.getUserId();
		Student student = studentService.getStudentByAccount(userId);
		student.setStatus(1);
		studentService.update(student);
		message.setStatus(2);
		messageService.update(message);
		return "ok";
	}

	/**
	 * 
	 * @Decription 管理员已查看信息,但不做出其他行为(不解封学生)
	 */
	@ResponseBody
	@RequestMapping(value = "/readMsg", method = RequestMethod.GET)
	public String readMsg(@RequestParam(value = "id") Integer id, HttpSession session) {
		Message message = messageService.getOne(id);
		message.setStatus(2);
		messageService.update(message);
		return "ok";
	}

	/**
	 * 
	 * @Decription 管理员已查看信息,但不做出其他行为(不解封学生)
	 */
	@ResponseBody
	@RequestMapping(value = "/addNotice", method = RequestMethod.POST)
	public String addNotice(@RequestParam(value = "noticeHead") String noticeHead,
			@RequestParam(value = "content") String content, HttpSession session) {
		Notice notice = new Notice();
		notice.setHeadline(noticeHead);
		notice.setContent(content);
		notice.setUpDateTime(new Date());
		noticeService.insert(notice);
		session.setAttribute("notice", noticeService.getAll());
		return "ok";
	}

	/**
	 * 
	 * @Decription 管理员已查看信息,但不做出其他行为(不解封学生)
	 */
	@ResponseBody
	@RequestMapping(value = "/addRule", method = RequestMethod.POST)
	public String addRule(@RequestParam(value = "ruleHead") String ruleHead,
			@RequestParam(value = "content") String content, HttpSession session) {
		LabRule rule = new LabRule();
		rule.setHeadline(ruleHead);
		rule.setContent(content);
		rule.setUploadDate(new Date());
		labRuleService.insert(rule);
		return "ok";
	}

	@ResponseBody
	@RequestMapping(value = "/getNoticeContent", method = RequestMethod.GET)
	public Map<String, String> getNoticeContent(@RequestParam(value = "id") Integer noticeId) {
		Notice notice = noticeService.getOne(noticeId);
		Map<String, String> map = new HashMap<String, String>();
		map.put("headline", notice.getHeadline());
		map.put("date", notice.getUpDateTime() + "");
		map.put("content", notice.getContent());
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/getRuleContent", method = RequestMethod.GET)
	public Map<String, String> getRuleContent(@RequestParam(value = "id") Integer ruleId) {
		LabRule labRule = labRuleService.getOne(ruleId);
		Map<String, String> map = new HashMap<String, String>();
		map.put("headline", labRule.getHeadline());
		map.put("date", labRule.getUploadDate() + "");

		map.put("content", labRule.getContent());
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/deleteRule", method = RequestMethod.GET)
	public String deleteRule(@RequestParam(value = "id") Integer ruleId) {
		labRuleService.delete(ruleId);

		return "ok";
	}

	@ResponseBody
	@RequestMapping(value = "/deleteNotice", method = RequestMethod.GET)
	public String deleteNotice(@RequestParam(value = "id") Integer noticeId, HttpSession session) {
		noticeService.delete(noticeId);
		return "ok";
	}

	@ResponseBody
	@RequestMapping(value = "/getNoticeList", method = RequestMethod.GET)
	public List<Notice> getNoticeList() {
		List<Notice> list = noticeService.getAll();
		return list.subList(0, list.size() > 5 ? 5 : list.size());
	}

	@ResponseBody
	@RequestMapping(value = "/getRuleList", method = RequestMethod.GET)
	public List<LabRule> getRuleList() {
		List<LabRule> list = labRuleService.getAll();
		return list.subList(0, list.size() > 5 ? 5 : list.size());
	}

	@ResponseBody
	@RequestMapping(value = "/getPagerMessage", method = RequestMethod.GET)
	public Pager<Message> getPagerMessage(HttpSession session, @RequestParam("flag") Integer flag) {
		Integer msgOffset = (Integer) session.getAttribute("msgPage");
		Long allRows = (Long) session.getAttribute("allRows");
		msgOffset += flag * 8;
		if (msgOffset < 0) {
			return null;
		}
		if (allRows != null) {
			if (msgOffset >= allRows) {
				return null;
			}
		}
		session.setAttribute("msgPage", msgOffset);
		SystemContext.setPageSize(8);
		SystemContext.setPageOffset(msgOffset);
		Pager<Message> appealLists = messageService.getStuAppeal();
		session.setAttribute("allRows", appealLists.getTotal());
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return appealLists;
	}

	@ResponseBody
	@RequestMapping(value = "/getPagerNotice", method = RequestMethod.POST)
	public Pager<Notice> getPagerNotice(@RequestParam("rows") Integer rows, @RequestParam("page") Integer page) {
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) {
				SystemContext.setPageOffset((page - 1) * rows);
			}
		}
		Pager<Notice> ntcLists = noticeService.getPagerNotice();
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return ntcLists;
	}

	@ResponseBody
	@RequestMapping(value = "/getPagerNMSG", method = RequestMethod.POST)
	public Pager<Message> getPagerNMSG(@RequestParam("rows") Integer rows, @RequestParam("page") Integer page) {
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) {
				SystemContext.setPageOffset((page - 1) * rows);
			}
		}
		Pager<Message> messages = messageService.getPagerNMSG();
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return messages;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getPagerUserNMSG", method = RequestMethod.POST)
	public Pager<Message> getPagerUserNMSG(HttpSession session,@RequestParam("rows") Integer rows, @RequestParam("page") Integer page) {
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) {
				SystemContext.setPageOffset((page - 1) * rows);
			}
		}
		String role = session.getAttribute("role")+"";
		Long userId=0L;
		if("教师".equals(role)) {
			Teacher teacher= (Teacher)session.getAttribute("user");
			userId = teacher.getTeacherAccount();
		}else if("学生".equals(role)){
			Student student= (Student)session.getAttribute("user");
			userId = student.getStudentAccount();
		}else {
		}
		Pager<Message> messages = messageService.getPagerUserNMSG(userId);
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return messages;
	}

	@ResponseBody
	@RequestMapping(value = "/getPagerRule", method = RequestMethod.POST)
	public Pager<LabRule> getPagerRule(@RequestParam("rows") Integer rows, @RequestParam("page") Integer page) {
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) {
				SystemContext.setPageOffset((page - 1) * rows);
			}
		}
		Pager<LabRule> labRuleLists = labRuleService.getPagerRule();
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return labRuleLists;
	}
}
