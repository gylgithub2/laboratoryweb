package cn.gyl.laboratoryweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyl.laboratoryweb.dao.DepartmentDao;
import cn.gyl.laboratoryweb.model.Department;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Service("departmentService")
public class DepartmentServiceimpl  extends BaseServiceimpl<Department> implements DepartmentService{

	@Autowired
	private DepartmentDao departmentDao;
	@Override
	public List<Department> getAllDepartment() {
		return departmentDao.getAllDepartment();
	}

}
