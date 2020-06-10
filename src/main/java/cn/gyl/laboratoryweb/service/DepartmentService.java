package cn.gyl.laboratoryweb.service;

import java.util.List;

import cn.gyl.laboratoryweb.model.Department;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface DepartmentService extends BaseService<Department>{

	
	public List<Department> getAllDepartment();
}
