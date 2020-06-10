package cn.gyl.laboratoryweb.model;

/**
 * 
 * @Decription 学生信息表映射类
 * @authorEmail 1076030424@qq.com
 */
public class Student {
	/**
	 * 数据库主键
	 */
	private Integer studentPKID;

	/**
	 * 学生账号,登录账号,学号
	 */
	private Long studentAccount;

	/**
	 * 学生姓名
	 */
	private String studentName;

	/**
	 * 学生当前状态, 1正常 2禁用
	 */
	private Integer status;
	/**
	 * 违纪次数 缺席+2次 迟到+1次,达到 6 状态封禁,需要账号申诉;
	 */
	private Integer violateScore;
	/**
	 * 缺席次数
	 */
	private Integer absenceTime;
	/**
	 * 迟到次数
	 */
	private Integer lateTime;


	/**
	 * 学生登录密码
	 */
	private String studentPassword;

	/**
	 * 学生所在班级编号
	 */
	private Long stuClass;
	/**
	 * 学生ic卡号
	 */
	private Long icCard;

	public Long getStuClass() {
		return stuClass;
	}

	public void setStuClass(Long stuClass) {
		this.stuClass = stuClass;
	}

	public Student() {
		super();
	}

	public Long getStudentAccount() {
		return studentAccount;
	}

	public void setStudentAccount(Long studentAccount) {
		this.studentAccount = studentAccount;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public Integer getStudentPKID() {
		return studentPKID;
	}

	public void setStudentPKID(Integer studentPKID) {
		this.studentPKID = studentPKID;
	}

	/**
	 * @return the lateTime
	 */
	public Integer getLateTime() {
		return lateTime;
	}

	/**
	 * @param lateTime the lateTime to set
	 */
	public void setLateTime(Integer lateTime) {
		this.lateTime = lateTime;
	}

	/**
	 * @return the abenceTime
	 */
	public Integer getAbsenceTime() {
		return absenceTime;
	}

	/**
	 * @param abenceTime the abenceTime to set
	 */
	public void setAbsenceTime(Integer absenceTime) {
		this.absenceTime = absenceTime;
	}

	/**
	 * @return the violateScore
	 */
	public Integer getViolateScore() {
		return violateScore;
	}

	/**
	 * @param violateScore the violateScore to set
	 */
	public void setViolateScore(Integer violateScore) {
		this.violateScore = violateScore;
	}

	/**
	 * @return the icCard
	 */
	public Long getIcCard() {
		return icCard;
	}

	/**
	 * @param icCard the icCard to set
	 */
	public void setIcCard(Long icCard) {
		this.icCard = icCard;
	}
}