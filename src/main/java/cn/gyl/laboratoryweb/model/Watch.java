package cn.gyl.laboratoryweb.model;

import java.util.Date;

/**
 * 
 * @Decription 学生视频观看信息数据库映射类
 * @authorEmail 1076030424@qq.com
 */
public class Watch {
	/**
	 * 数据库主键
	 */
	private Integer watchPKID;

	/**
	 * 学生账号
	 */
	private Long studentAccount;
	/**
	 * 播放状态
	 */
	private Integer status = 0;

	/**
	 * 观看日期
	 */
	private Date watchDate;

	/**
	 * 项目编号
	 */
	private Long experimentalProjectId;
	
	//对应的预约ID
	private Integer relateOrder;

	/**
	 * 学生班级信息
	 */
	private Long stuClassId;
	// 实验开始时间
	private Date deadline;
	// 是否被核查过 0没被检查  1被检查过了
	private Integer isCheck = 0;

	public Long getStuClassId() {
		return stuClassId;
	}

	public void setStuClassId(Long stuClassId) {
		this.stuClassId = stuClassId;
	}

	public Date getWatchDate() {
		return watchDate;
	}

	public void setWatchDate(Date watchDate) {
		this.watchDate = watchDate;
	}

	public Long getExperimentalProjectId() {
		return experimentalProjectId;
	}

	public void setExperimentalProjectId(Long experimentalProjectId) {
		this.experimentalProjectId = experimentalProjectId;
	}

	public Long getStudentAccount() {
		return studentAccount;
	}

	public void setStudentAccount(Long studentAccount) {
		this.studentAccount = studentAccount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getWatchPKID() {
		return watchPKID;
	}

	public void setWatchPKID(Integer watchPKID) {
		this.watchPKID = watchPKID;
	}

	/**
	 * @return the deadLine
	 */
	public Date getDeadline() {
		return deadline;
	}

	/**
	 * @param deadLine the deadLine to set
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	/**
	 * @return the isCheck
	 */
	public Integer getIsCheck() {
		return isCheck;
	}

	/**
	 * @param isCheck the isCheck to set
	 */
	public void setIsCheck(Integer isCheck) {
		this.isCheck = isCheck;
	}
	

	/**
	 * @return the relateOrder
	 */
	public Integer getRelateOrder() {
		return relateOrder;
	}

	/**
	 * @param relateOrder the relateOrder to set
	 */
	public void setRelateOrder(Integer relateOrder) {
		this.relateOrder = relateOrder;
	}
}