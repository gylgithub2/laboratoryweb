package cn.gyl.laboratoryweb.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 
 * @Decription 教师数据库映射类
 * @authorEmail 1076030424@qq.com
 */
public class Teacher {
	/**
	 * 数据库主键
	 */
    private Integer teacherPKID;

    /**
     * 教师账号,登录账号,工号
     */
	private Long teacherAccount;

	/**
	 * 教师密码
	 */
    private String teacherPassword;
    /**
     * 教师姓名
     */
    private String teacherName;
    /**
     * 教师状态  1可用 2禁用
     */
    private Integer status;
    
    /**
     * 教师管理的班级
     */
    @JsonIgnore
    private Set<StuClass> stuClasses;
    /**
     * 教师所在学院
     */
    @JsonIgnore
    private Department department;

    public Set<StuClass> getStuClasses() {
		return stuClasses;
	}

	public void setStuClasses(Set<StuClass> stuClasses) {
		this.stuClasses = stuClasses;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


    public Long getTeacherAccount() {
        return teacherAccount;
    }

    public void setTeacherAccount(Long teacherAccount) {
        this.teacherAccount = teacherAccount;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getTeacherPKID() {
		return teacherPKID;
	}


	public void setTeacherPKID(Integer teacherPKID) {
		this.teacherPKID = teacherPKID;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
}