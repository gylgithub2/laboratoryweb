package cn.gyl.laboratoryweb.service;

import java.util.List;

import cn.gyl.laboratoryweb.model.Admin;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface AdminService extends BaseService<Admin> {
	/**
	 * 
	 * @Decription 获取所有管理员
	 */
	public List<Admin> getAllAdmins();
	public Admin getAdminByAccount(Long adminAccount);
	
	/**
	 * 
	 * @param admin 
	 * @Decription 分页获取所有管理员
	 */
	public Pager<Admin> getAllPageAdmins(Admin admin);
	
	public void updateAdmin(Admin admin);

	/**
	 * @Decription
	 */
	public Admin login(Long userAccountNum, String password);
}
