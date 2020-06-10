package cn.gyl.laboratoryweb.service;

import java.util.List;

import cn.gyl.laboratoryweb.model.LabRule;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface LabRuleService extends BaseService<LabRule> {

	/**
	 * @Decription
	 */
	public List<LabRule> getAll();

	/**
	 * @Decription
	 */
	public Pager<LabRule> getPagerRule();

}
