package cn.gyl.laboratoryweb.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Decription 公告表映射类
 * @authorEmail 1076030424@qq.com
 */
public class Notice {
	private Integer noticePKID;
	private String headline;
	private String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date upDateTime;
	public Integer getNoticePKID() {
		return noticePKID;
	}
	public void setNoticePKID(Integer noticePKID) {
		this.noticePKID = noticePKID;
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
	 * @return the upDateTime
	 */
	public Date getUpDateTime() {
		return upDateTime;
	}
	/**
	 * @param upDateTime the upDateTime to set
	 */
	public void setUpDateTime(Date upDateTime) {
		this.upDateTime = upDateTime;
	}
}
