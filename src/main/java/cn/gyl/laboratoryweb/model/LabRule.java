package cn.gyl.laboratoryweb.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Decription 实验室规章制度映射类
 * @authorEmail 1076030424@qq.com
 */
public class LabRule {

	private Integer labRulePKID;
	private String headline;
	private String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date uploadDate;
	public Integer getLabRulePKID() {
		return labRulePKID;
	}
	public void setLabRulePKID(Integer labRulePKID) {
		this.labRulePKID = labRulePKID;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the uploadDate
	 */
	public Date getUploadDate() {
		return uploadDate;
	}
	/**
	 * @param uploadDate the uploadDate to set
	 */
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
}
