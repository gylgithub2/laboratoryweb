package cn.gyl.laboratoryweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gyl.laboratoryweb.model.LabSit;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Repository(value="labSitDao")
public class LabSitDaoimpl extends BaseDaoimpl<LabSit> implements LabSitDao {

	@Override
	public List<LabSit> getAll() {
		String hql = "select l from LabSit l";
		return super.getList(hql, null, null);
	}


	
}
