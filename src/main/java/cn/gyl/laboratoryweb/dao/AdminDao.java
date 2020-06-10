package cn.gyl.laboratoryweb.dao;

import java.util.List;

import cn.gyl.laboratoryweb.model.Admin;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription 管理员信息数据库访问类接口
 * @authorEmail 1076030424@qq.com
 */
public interface AdminDao extends BaseDao<Admin> {
	
	/**
	 * 
	 * @Decription 获取所有管理员
	 */
	public List<Admin> getAllAdmins();
	
	/**
	 * 
	 * @param admin  管理员对象
	 * @Decription 分页获取所有管理员
	 */
	public Pager<Admin> getAllPageAdmins(Admin admin);

	/**
	 * @Decription 根据账号获取管理员
	 */
	public Admin getAdminByAccount(Long userAccountNum);

}
