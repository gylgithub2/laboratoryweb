package cn.gyl.laboratoryweb.dao;

import java.util.List;

import cn.gyl.laboratoryweb.model.TimeSection;

/**
 * @Decription 实验室单天开放时段信息数据库访问类接口
 * @authorEmail 1076030424@qq.com
 */
public interface TimeSectionDao extends BaseDao<TimeSection> {
	/**
	 * 
	 * @Decription 获取所有时段
	 */
	public List<TimeSection> getAllTimeSection();
}
