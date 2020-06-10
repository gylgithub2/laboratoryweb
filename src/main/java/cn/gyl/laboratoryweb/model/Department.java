package cn.gyl.laboratoryweb.model;

/**
 * @Decription 学院数据库映射类
 * @authorEmail 1076030424@qq.com
 */
public class Department {
	/**
	 * 数据库主键,对象唯一标识
	 */
	private Integer departmentPKID;
	/**
	 * 学院名字
	 */
	private String departmentName;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getDepartmentPKID() {
		return departmentPKID;
	}

	public void setDepartmentPKID(Integer departmentPKID) {
		this.departmentPKID = departmentPKID;
	}
}
