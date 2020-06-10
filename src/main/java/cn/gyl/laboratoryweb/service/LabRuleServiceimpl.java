package cn.gyl.laboratoryweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyl.laboratoryweb.dao.LabRuleDao;
import cn.gyl.laboratoryweb.model.LabRule;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Service("labRuleService")
public class LabRuleServiceimpl extends BaseServiceimpl<LabRule> implements LabRuleService  {

	@Autowired
	private LabRuleDao labRuleDao;
	@Override
	public List<LabRule> getAll() {
		// TODO Auto-generated method stub
		return labRuleDao.getAll();
	}
	@Override
	public Pager<LabRule> getPagerRule() {
		// TODO Auto-generated method stub
		return labRuleDao.getPagerRule();
	}

}
