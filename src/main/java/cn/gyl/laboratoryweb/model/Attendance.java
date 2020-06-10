package cn.gyl.laboratoryweb.model;

import java.util.Date;
/**
 * 
 * @Decription 出席表表映射类
 * @authorEmail 1076030424@qq.com
 */
public class Attendance {
    private Integer attendancePKID;
    /**
     * 学生学号
     */
    private Long studentAccount;
    /**
     * 打卡时间
     */
    private Date punchDate;
    /**
     * 实验开始时间
     */
    private Date startDate;
    /**
     * 实验结束时间
     */
    private Date endDate;
    /**
          * 班级实验时的老师
     */
    private Long teacherAccount;
    /**
          * 学生出席状态信息:
     *          0/缺席(初始状态,未签到)
     *          1/迟到(实验时间内签到)  
     *          2/正常(正常签到签退)   
     */
    private Integer status = 0;
    /**
          * 该次实验项目编号
     */
    private Long experProjectId;
    /**
          * 实验室编号
     */
    private Long laboratoryId;
    
    // 是否对该条记录进行违纪判断了
    private Boolean isCheck = false;
    //是否具有开门权限
    private Boolean isOpen = false;
	public Long getStudentAccount() {
		return studentAccount;
	}
	public void setStudentAccount(Long studentAccount) {
		this.studentAccount = studentAccount;
	}
	public Date getPunchDate() {
		return punchDate;
	}
	public void setPunchDate(Date punchDate) {
		this.punchDate = punchDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Long getTeacherAccount() {
		return teacherAccount;
	}
	public void setTeacherAccount(Long teacherAccount) {
		this.teacherAccount = teacherAccount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getExperProjectId() {
		return experProjectId;
	}
	public void setExperProjectId(Long experProjectId) {
		this.experProjectId = experProjectId;
	}
	public Long getLaboratoryId() {
		return laboratoryId;
	}
	public void setLaboratoryId(Long laboratoryId) {
		this.laboratoryId = laboratoryId;
	}
	/**
	 * @return the attendancePKID
	 */
	public Integer getAttendancePKID() {
		return attendancePKID;
	}
	/**
	 * @param attendancePKID the attendancePKID to set
	 */
	public void setAttendancePKID(Integer attendancePKID) {
		this.attendancePKID = attendancePKID;
	}
	/**
	 * @return the isChecked
	 */
	public Boolean getIsCheck() {
		return isCheck;
	}
	/**
	 * @param isChecked the isChecked to set
	 */
	public void setIsCheck(Boolean isCheck) {
		this.isCheck = isCheck;
	}
	/**
	 * @return the isOpen
	 */
	public Boolean getIsOpen() {
		return isOpen;
	}
	/**
	 * @param isOpen the isOpen to set
	 */
	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}
 
}