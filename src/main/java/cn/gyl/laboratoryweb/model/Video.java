package cn.gyl.laboratoryweb.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * @Decription 视频信息数据库映射
 * @authorEmail 1076030424@qq.com
 */
public class Video {
	/**
	 * 数据库主键
	 */
	private Integer videoPKID;
	/**
	 * 上传日期
	 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date uploadDate;
	/**
	 * 视频原名
	 */
	private String videoName;
	/**
	 * 视频路径
	 */
	private String videoPath;
	/**
	 * 文件名
	 */
	private String fileName;
	/**
	 * 文件路径
	 */
	private String filePath;
	/**
	 * 上传老师编号
	 */
	private Long teacherAccount;

	/**
	 * 从属项目
	 */
	private ExperimentalProject experimentalProject;


	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}



	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Long getTeacherAccount() {
		return teacherAccount;
	}

	public void setTeacherAccount(Long teacherAccount) {
		this.teacherAccount = teacherAccount;
	}

	public ExperimentalProject getExperimentalProject() {
		return experimentalProject;
	}

	public void setExperimentalProject(ExperimentalProject experimentalProject) {
		this.experimentalProject = experimentalProject;
	}

	public Integer getVideoPKID() {
		return videoPKID;
	}

	public void setVideoPKID(Integer videoPKID) {
		this.videoPKID = videoPKID;
	}

}