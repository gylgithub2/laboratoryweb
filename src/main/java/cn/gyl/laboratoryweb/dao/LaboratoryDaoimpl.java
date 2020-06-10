package cn.gyl.laboratoryweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gyl.laboratoryweb.model.Laboratory;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Repository("laboratoryDao")
public class LaboratoryDaoimpl extends BaseDaoimpl<Laboratory> implements LaboratoryDao {

	@Override
	public Pager<Laboratory> getAllPageLaboratorys(String laboratoryName) {
		String hql = "from Laboratory l where 1=1 ";
		if (laboratoryName!= null && !"".equals(laboratoryName))
			hql += " AND l.laboratoryName like '%" + laboratoryName + "%'";
		return super.getPageList(hql, null, null);
	}

	@Override
	public List<Laboratory> getAllLaboratory() {
		String hql="select l from Laboratory l";
		return super.getList(hql, null, null);
	}

	@Override
	public Laboratory getOneByLabId(Long labId) {
		String hql="select l from Laboratory l where laboratoryId = ?0";
		return super.queryByHql(hql, new Object[]{labId}, null);
	}

}
