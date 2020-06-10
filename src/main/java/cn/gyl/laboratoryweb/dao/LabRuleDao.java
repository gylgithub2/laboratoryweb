package cn.gyl.laboratoryweb.dao;

import java.util.List;

import cn.gyl.laboratoryweb.model.LabRule;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription 实验室规章制度信息数据库访问类接口
 * @authorEmail 1076030424@qq.com
 */
public interface LabRuleDao extends BaseDao<LabRule>{

	/**
	 * @Decription 获取所有数据
	 */
	List<LabRule> getAll();

	/**
	 * @Decription 获取分页数据
	 */
	Pager<LabRule> getPagerRule();

}
