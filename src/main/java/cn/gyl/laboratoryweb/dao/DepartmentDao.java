package cn.gyl.laboratoryweb.dao;

import java.util.List;

import cn.gyl.laboratoryweb.model.Department;

/**
 * @Decription 学院信息数据库访问类接口
 * @authorEmail 1076030424@qq.com
 */
public interface DepartmentDao extends BaseDao<Department> {
	/**
	 * 
	 * @Decription 获取所有的学院信息
	 */
	public List<Department> getAllDepartment();
}
