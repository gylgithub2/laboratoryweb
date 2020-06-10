	package cn.gyl.laboratoryweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gyl.laboratoryweb.model.Admin;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Repository
public class AdminDaoimpl extends BaseDaoimpl<Admin> implements AdminDao {

	@Override
	public List<Admin> getAllAdmins() {
		String hql = "from Admin";
		return super.getList(hql, null, null);
	}

	@Override
	public Pager<Admin> getAllPageAdmins(Admin admin) {
		String hql = "from Admin a where 1=1 ";
		if (admin.getAdminPKID() != null && admin.getAdminPKID() > 0)
			hql += " AND a.admin_pk_id= " + admin.getAdminPKID();
		if (admin.getAdminName() != null && !"".equals(admin.getAdminName()))
			hql += "AND a.adminName like '%" + admin.getAdminName() + "%'";
		return super.getPageList(hql, null, null);
	}

	@Override
	public Admin getAdminByAccount(Long userAccountNum) {
		String hql = "select a from Admin a where a.adminAccount = ?0";
		return (Admin)super.queryByHql(hql, new Object[] {userAccountNum}, null);
	}
}
