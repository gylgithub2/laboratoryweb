package cn.gyl.laboratoryweb.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @Decription 预约表数据库映射
 * @authorEmail 1076030424@qq.com
 */
public class Order {
	/**
	 * 数据库主键
	 */
	private Integer orderPKID;
	/**
	 * 预约人
	 */
	private Long userId;
	/**
	 * 预约人姓名
	 */
	private String userName;
	/**
	 * 预约申请时间 ,日期json解析注解,下同,用于界面显示
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date orderTime;
	/**
	 * 预约具体开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	/**
	 * 预约具体结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	
	// 该条预约申请状态 : 0/未审核 1/审核通过 2/审核不通过 3/已手动撤销
	private Integer status = 0;
	
	//实验室的编号
	private Long roomId;

	// 实验室的座位号
	private Integer roomSitId;

	// 实验室的名字
	private String roomName;

	/**
	 * 班级预约时的班级编号
	 */
	private Long stuClass;

	/**
	 * 班级预约时的班级名称
	 */
	private String stuClassName;
	/**
	 * 班级预约时的实验编号
	 */
	private Long experProjectAccount;
	/**
	 * 预约人角色 1教师 2学生
	 */
	private Integer userRole;

	public Long getStuClass() {
		return stuClass;
	}

	public void setStuClass(Long stuClass) {
		this.stuClass = stuClass;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the experProjectAccount
	 */
	public Long getExperProjectAccount() {
		return experProjectAccount;
	}

	/**
	 * @param experProjectAccount the experProjectAccount to set
	 */
	public void setExperProjectAccount(Long experProjectAccount) {
		this.experProjectAccount = experProjectAccount;
	}

	/**
	 * @return the orderPKID
	 */
	public Integer getOrderPKID() {
		return orderPKID;
	}

	/**
	 * @param orderPKID the orderPKID to set
	 */
	public void setOrderPKID(Integer orderPKID) {
		this.orderPKID = orderPKID;
	}

	/**
	 * @return the userRole
	 */
	public Integer getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the roomName
	 */
	public String getRoomName() {
		return roomName;
	}

	/**
	 * @param roomName the roomName to set
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
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
	 * @return the stuClassName
	 */
	public String getStuClassName() {
		return stuClassName;
	}

	/**
	 * @param stuClassName the stuClassName to set
	 */
	public void setStuClassName(String stuClassName) {
		this.stuClassName = stuClassName;
	}

	/**
	 * @return the roomSitId
	 */
	public Integer getRoomSitId() {
		return roomSitId;
	}

	/**
	 * @param roomSitId the roomSitId to set
	 */
	public void setRoomSitId(Integer roomSitId) {
		this.roomSitId = roomSitId;
	}

}