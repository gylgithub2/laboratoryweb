package cn.gyl.laboratoryweb.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.gyl.laboratoryweb.model.ExperimentalProject;
import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.Student;
import cn.gyl.laboratoryweb.model.SystemContext;
import cn.gyl.laboratoryweb.model.Video;
import cn.gyl.laboratoryweb.model.Watch;
import cn.gyl.laboratoryweb.service.ExperProjectService;
import cn.gyl.laboratoryweb.service.StudentService;
import cn.gyl.laboratoryweb.service.VideoService;
import cn.gyl.laboratoryweb.service.WatchService;

/**
 * @Decription 数字化资源请求处理
 * @authorEmail 1076030424@qq.com
 */
@Controller
public class VideoAndFileController {

	@Autowired
	private VideoService videoService;
	@Autowired
	private ExperProjectService experProjectService;
	@Autowired
	private WatchService watchService;
	@Autowired
	private StudentService studentService;

	/**
	 * 
	 * @Decription 存储视频以及文档 存储在该工程目录下
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadVideo", method = RequestMethod.POST)
	public String uploadVideo(
			HttpServletRequest request, 
			@RequestParam(value = "video") MultipartFile video,
			@RequestParam(value = "experimentalProjectId") String experProId,
			@RequestParam(value = "hasVideo") Boolean hasVideo,
			@RequestParam(value = "learnfile") MultipartFile learnfile) {
		if (!video.isEmpty() && !learnfile.isEmpty()) {
			// 视频保存地
			String videoPath = request.getSession().getServletContext().getRealPath("/resources/videos/");
			String learnfilePath = request.getSession().getServletContext().getRealPath("/resources/learnfiles/");
			String videoName = video.getOriginalFilename();
			String learnfileName = learnfile.getOriginalFilename();
			int i = (int) (Math.random() * 10000);
			String videoSuffix = videoName.split("\\.")[1];
			String fileSuffix = learnfileName.split("\\.")[1];
			if (!videoSuffix.equalsIgnoreCase("mp4") && !videoSuffix.equalsIgnoreCase("rmvb")
					&& !videoSuffix.equalsIgnoreCase("asf") && !videoSuffix.equalsIgnoreCase("avi")
					&& !videoSuffix.equalsIgnoreCase("rm") && !videoSuffix.equalsIgnoreCase("mpg")) {
				return "falseVideo";
			}
			String saveVideoName = videoName.split("\\.")[0] + i + "." + videoSuffix;
			String saveLearnfileName = learnfileName.split("\\.")[0] + i + "." + fileSuffix;
			File storeVideoFile = new File(videoPath, saveVideoName);
			File storeLearnfileFile = new File(learnfilePath, saveLearnfileName);
			Video videoLog = new Video();
			Long teacherAccount = (Long) request.getSession().getAttribute("userAccount");
			videoLog.setFileName(learnfileName);
			videoLog.setVideoName(videoName);
			videoLog.setVideoPath(videoPath + saveVideoName);
			videoLog.setFilePath(learnfilePath + saveLearnfileName);
			videoLog.setTeacherAccount(teacherAccount);
			videoLog.setUploadDate(new Date());
			ExperimentalProject experimentalProject = experProjectService.getOneByAccount(Long.parseLong(experProId));
			experimentalProject.setHasVideo(true);
			videoLog.setExperimentalProject(experimentalProject);
			if(hasVideo) {
				Video video2 = videoService.getVideoByExperProId(experimentalProject.getExperProjectPKID());
				File learnFile = new File(video2.getFilePath());
				File videoFile = new File(video2.getVideoPath());
				learnFile.delete();
				videoFile.delete();
				videoService.delete(video2.getVideoPKID());
			}
			Video insert = videoService.insert(videoLog);
			experProjectService.update(experimentalProject);
			if (insert == null) {
				return "";
			}
			if (!storeVideoFile.getParentFile().exists()) {
				storeVideoFile.getParentFile().mkdirs();
			}
			if (!storeLearnfileFile.getParentFile().exists()) {
				storeLearnfileFile.getParentFile().mkdirs();
			}
			try {
				video.transferTo(storeVideoFile);
				learnfile.transferTo(storeLearnfileFile);
				return "ok";
			} catch (Exception e) {
				return "";
			}
		}
		return "";
	}

	/**
	 * 
	 * @Decription 返回教师的历史上传信息界面--数字化资源管理
	 */
	@RequestMapping(value = "/myUpload")
	public String MyUpload() {
		return "teacher/myUpload";
	}

	/**
	 * 
	 * @Decription 返回教师的历史上传信息界面
	 */
	@RequestMapping(value = "/digitalManager")
	public String digitalManager() {
		return "admin/digital-manager";
	}

	/**
	 * 
	 * @Decription 学生观看视频界面
	 */
	@RequestMapping(value = "/watchVideo")
	public String watchVideo() {
		return "student/t-watch-video";
	}
	@RequestMapping(value = "/tWatchVideo")
	public String tWatchVideo() {
		return "teacher/watch-video";
	}


	/**
	 * 
	 * @Decription 获取教师历史上传信息源
	 */
	@ResponseBody
	@RequestMapping(value = "/getMyUpload")
	public Pager<Video> getMyUpload(HttpSession session, @RequestParam("rows") Integer rows,
			@RequestParam("page") Integer page) {
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) {
				SystemContext.setPageOffset((page - 1) * rows);
			}
		}
		Pager<Video> allPagers = videoService.getPageVideoByAccount((Long) session.getAttribute("userAccount"));
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return allPagers;
	}

	/**
	 * 
	 * @Decription 获取所有的数字化资源信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllUpload")
	public Pager<Video> getAllUpload(HttpSession session, @RequestParam("rows") Integer rows,
			@RequestParam("page") Integer page) {
		if (rows != null && rows > 0) {
			SystemContext.setPageSize(rows);
			if (page != null && page > 0) {
				SystemContext.setPageOffset((page - 1) * rows);
			}
		}
		Pager<Video> allPagers = videoService.getPageVideo();
		SystemContext.removePageOffset();
		SystemContext.removePageSize();
		return allPagers;
	}

	/**
	 * 
	 * @Decription 删除教师的上传
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteMyUpload")
	public String delete(@RequestParam(value = "ids[]") int[] ids) {
		for (int i : ids) {
			Video video = videoService.getOne(i);
			ExperimentalProject experimentalProject = video.getExperimentalProject();
			experimentalProject.setHasVideo(false);
			experProjectService.update(experimentalProject);
			File learnFile = new File(video.getFilePath());
			File videoFile = new File(video.getVideoPath());
			learnFile.delete();
			videoFile.delete();
			videoService.delete(i);
		}
		return "ok";
	}

	/**
	 * 
	 * @Decription 获取视频地址
	 */
	@ResponseBody
	@RequestMapping(value = "/getVideoAddress", produces = { "text/html;charset=UTF-8;", "application/json;" })
	public String getVideoArddress(HttpSession session,
			@RequestParam(value = "experProjectPKID") Integer experProjectPKID,
			@RequestParam(value = "experimentalProjectId") Long experimentalProjectId) {
		Video video = videoService.getVideoByExperProId(experProjectPKID);
		session.removeAttribute("videoPath");
		if(video==null) {
			return "fail";
		}
		session.setAttribute("videoPath", video.getVideoPath().split("\\\\videos\\\\")[1]);
		session.setAttribute("experimentalProjectId", experimentalProjectId);
		return "ok";
	}	


	/**
	 * 
	 * @Decription 下载文件
	 */
	@RequestMapping(value = "/downloadFile")
	public ResponseEntity<byte[]> downloadFile(@RequestParam(value = "experProjectPKID") Integer experProjectPKID)
			throws IOException {
		Video video = videoService.getVideoByExperProId(experProjectPKID);
		if(video==null) {
			return null;
		}
		File file = new File(video.getFilePath());
		if(!file.exists()) {
			return null;
		}
		HttpHeaders headers = new HttpHeaders();
		String fileName = null;
		try {
			String oldName = video.getFilePath().split("\\\\learnfiles\\\\")[1];
			String suffix = oldName.split("\\.")[1];
			String newName = oldName.split("\\.")[0].substring(0, oldName.split("\\.")[0].length() - 4) + "." + suffix;
			fileName = new String(newName.getBytes("UTF-8"), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @Decription 下载视频
	 */
	@RequestMapping(value = "/downloadVideo")
	public ResponseEntity<byte[]> downloadVideo(@RequestParam(value = "experProjectPKID") Integer experProjectPKID)
			throws IOException {
		Video video = videoService.getVideoByExperProId(experProjectPKID);
		File file = new File(video.getVideoPath());
		HttpHeaders headers = new HttpHeaders();
		String fileName = null;
		try {
			String oldName = video.getVideoPath().split("\\\\videos\\\\")[1];
			String suffix = oldName.split("\\.")[1];
			String newName = oldName.split("\\.")[0].substring(0, oldName.split("\\.")[0].length() - 4) + "." + suffix;
			fileName = new String(newName.getBytes("UTF-8"), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @Decription 学生观看记录
	 */
	@ResponseBody
	@RequestMapping("/stuWatchLog")
	public String stuWatchLog(String stuId, String videoTime, String watchTime, HttpSession session) {
		Long experimentalProjectId = (Long) session.getAttribute("experimentalProjectId");
		Long stuAccount = Long.parseLong(stuId);
		if (experimentalProjectId != null && stuAccount != null) {
			Watch watch = watchService.getWatchByStuAndExper(stuAccount, experimentalProjectId);
			if (watch.getStatus() == 100) {
				return "watched";
			}
			Date deadline = watch.getDeadline();
			if (deadline.before(new Date())) {
				return "overDate";
			}
			Double videoTimei = Double.parseDouble(videoTime);
			Double watchTimei = Double.parseDouble(watchTime);
			Date date = new Date();
			watch.setWatchDate(date);
			watch.setStatus((int) ((watchTimei / videoTimei) * 100));
			watchService.update(watch);
		}
		return "ok";
	}

	/**
	 * 
	 * @Decription 返回该此实验 一个班级中已经完成的学生的数量以及学生总数
	 */
	@ResponseBody
	@RequestMapping(value = "getPreStudyNum", method = RequestMethod.POST)
	public Map<String, Integer> getPreStudyNum(Integer orderPKID, Long stuClassId) {
		int stuNum = studentService.getStuNum(stuClassId);
		int preStudyNum = watchService.getPreStudyNum(orderPKID);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("studentNum", stuNum);
		map.put("preStudyStuNum", preStudyNum);
		return map;
	}

	/**
	 * 
	 * @Decription 没有预习的学生注入session
	 */
	@ResponseBody
	@RequestMapping(value = "/setWatches", method = RequestMethod.POST)
	public String setWatches(Integer orderPKID, HttpSession session) {
		List<Watch> watches = watchService.getUnStudyLog(orderPKID);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (int i = 0; i < watches.size(); i++) {
			Map<String, String> map = new HashMap<String, String>();
			Long stuClassId = watches.get(i).getStudentAccount();
			Student student = studentService.getStudentByAccount(stuClassId);
			map.put("stuName", student.getStudentName());
			map.put("stuAccount", student.getStudentAccount() + "");
			map.put("status", watches.get(i).getStatus() + "");
			list.add(map);
		}
		session.setAttribute("watches", list);
		return "ok";
	}

	/**
	 * 
	 * @Decription 获取学生的观看进度状态:完成/未完成
	 */
	@ResponseBody
	@RequestMapping(value = "/getStuStudyInfo", method = RequestMethod.GET, produces = { "text/html;charset=UTF-8;",
			"application/json;" })
	public String getStuStudyInfo(Long experId, HttpSession session) {
		Long stuAccount = (Long) session.getAttribute("userAccount");
		Watch watch = watchService.getWatchByStuAndExper(stuAccount,experId );
		if (watch.getStatus() >= 90) {
			return "完成";
		} else if (watch.getDeadline().after(new Date())) {
			return "待完成";
		} else {
			return "未完成";
		}
	}
}
