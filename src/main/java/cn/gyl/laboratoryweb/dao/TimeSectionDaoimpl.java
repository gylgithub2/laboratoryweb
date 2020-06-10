package cn.gyl.laboratoryweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gyl.laboratoryweb.model.TimeSection;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Repository(value="timeSectionDao")
public class TimeSectionDaoimpl extends BaseDaoimpl<TimeSection> implements TimeSectionDao {
	@Override
	public List<TimeSection> getAllTimeSection() {
		String hql = "select t from TimeSection t";
		return super.getList(hql, null, null);
	}
	
}
