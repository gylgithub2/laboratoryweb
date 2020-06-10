package cn.gyl.laboratoryweb.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Decription 信息表表映射类
 * @authorEmail 1076030424@qq.com
 */
public class Message {

	//主键
	private Integer messagePKID;
	//用户账号
	private Long userId;
	//用户名字
	private String userName;
	//用户角色
	private String userRole;
	//消息类型 1为学生申诉 0为普通留言 大于1时为回复消息的被回复信息pkid+1的值
	private Integer msgType;
	//主要的内容
	private String messageContent;
	//学生请求的批准情况 1/未查看 2/已同意解封或普通消息被查看  3/不同意解封 或普通消息有被回复
	private Integer status;
	//消息时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date msgDate;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getMsgType() {
		return msgType;
	}
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the messagePKID
	 */
	public Integer getMessagePKID() {
		return messagePKID;
	}
	/**
	 * @param messagePKID the messagePKID to set
	 */
	public void setMessagePKID(Integer messagePKID) {
		this.messagePKID = messagePKID;
	}
	/**
	 * @return the msgDate
	 */
	public Date getMsgDate() {
		return msgDate;
	}
	/**
	 * @param msgDate the msgDate to set
	 */
	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (messageContent == null) {
			if (other.messageContent != null)
				return false;
		} else if (!messageContent.equals(other.messageContent))
			return false;
		if (messagePKID == null) {
			if (other.messagePKID != null)
				return false;
		} else if (!messagePKID.equals(other.messagePKID))
			return false;
		if (msgDate == null) {
			if (other.msgDate != null)
				return false;
		} else if (!msgDate.equals(other.msgDate))
			return false;
		if (msgType == null) {
			if (other.msgType != null)
				return false;
		} else if (!msgType.equals(other.msgType))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}
	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
}
