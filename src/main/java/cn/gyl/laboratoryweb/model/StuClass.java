package cn.gyl.laboratoryweb.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Decription 学生班级信息表
 * @authorEmail 1076030424@qq.com
 */
public class StuClass {
	/**
	 * 数据库主键
	 */
	private int stuClassPKID;
	/**
	 * 班级名
	 */
	private String stuClassName;
	/**
	 * 该班级的编号
	 */
	private Long stuClassId;

	/**
	 * 班级学生人数
	 */
	private Integer stuNum;
	/**
	 * 可以统一调度该班级实验的老师
	 */
	@JsonIgnore
	private Set<Teacher> teachers = new HashSet<Teacher>();
	/**
	 * 所属院系
	 */
	private Integer department;


	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Integer getStuNum() {
		return stuNum;
	}

	public void setStuNum(Integer stuNum) {
		this.stuNum = stuNum;
	}

	public String getStuClassName() {
		return stuClassName;
	}

	public void setStuClassName(String stuClassName) {
		this.stuClassName = stuClassName;
	}

	public Long getStuClassId() {
		return stuClassId;
	}

	public void setStuClassId(Long stuClassId) {
		this.stuClassId = stuClassId;
	}

	public int getStuClassPKID() {
		return stuClassPKID;
	}

	public void setStuClassPKID(int stuClassPKID) {
		this.stuClassPKID = stuClassPKID;
	}


}
