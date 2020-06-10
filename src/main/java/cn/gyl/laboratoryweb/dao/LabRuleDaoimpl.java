package cn.gyl.laboratoryweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gyl.laboratoryweb.model.LabRule;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription 实验规则的数据库访问实现类
 * @authorEmail 1076030424@qq.com
 */
@Repository("labRuleDao")
public class LabRuleDaoimpl extends BaseDaoimpl<LabRule> implements LabRuleDao {

	@Override
	public List<LabRule> getAll() {
		String hql = "select l from LabRule l";
		return super.getList(hql, null, null);
	}

	@Override
	public Pager<LabRule> getPagerRule() {
		String hql = "from LabRule";
		return super.getPageList(hql, null, null);
	}
	
}
