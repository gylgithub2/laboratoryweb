package cn.gyl.laboratoryweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyl.laboratoryweb.dao.AdminDao;
import cn.gyl.laboratoryweb.model.Admin;
import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.utils.PasswordSecurity;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Service("adminService")
public class AdminServiceimpl extends BaseServiceimpl<Admin> implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public List<Admin> getAllAdmins() {
		return adminDao.getAllAdmins();
	}

	@Override
	public Pager<Admin> getAllPageAdmins(Admin admin) {
		return adminDao.getAllPageAdmins(admin);
	}

	@Override
	public void updateAdmin(Admin admin) {
		Admin dataAdmin = adminDao.getOne(admin.getAdminPKID());
		dataAdmin.setAdminAccount(admin.getAdminAccount());
		dataAdmin.setAdminName(admin.getAdminName());
		if (admin.getAdminPassword() == null && "".equals(admin.getAdminPassword())) {

		} else {
			String password = PasswordSecurity.MD5(admin.getAdminName(), admin.getAdminPassword());
			dataAdmin.setAdminPassword(password);
		}
		adminDao.update(dataAdmin);
	}

	@Override
	public Admin login(Long userAccountNum, String password) {
		Admin admin = adminDao.getAdminByAccount(userAccountNum);
		if (admin == null)
			return null;
		String md5Password = PasswordSecurity.MD5(admin.getAdminName(), password);
		if (!admin.getAdminPassword().equals(md5Password))
			return null;
//		if(admin.getState!=1) throw new RuntimeException("用户被禁用!");
		return admin;
	}

	@Override
	public Admin getAdminByAccount(Long adminAccount) {
		return adminDao.getAdminByAccount(adminAccount);
	}
}
