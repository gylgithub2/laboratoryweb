package cn.gyl.laboratoryweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gyl.laboratoryweb.model.Department;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Repository(value="departmentDao")
public class DepartmentDaoimpl extends BaseDaoimpl<Department> implements DepartmentDao {

	@Override
	public List<Department> getAllDepartment() {
		String hql = "select d from Department d";
		return super.getList(hql, null, null);
	}

}
