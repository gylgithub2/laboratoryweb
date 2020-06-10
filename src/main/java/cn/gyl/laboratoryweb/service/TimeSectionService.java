package cn.gyl.laboratoryweb.service;

import java.util.List;

import cn.gyl.laboratoryweb.model.TimeSection;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface TimeSectionService extends BaseService<TimeSection> {
	public List<TimeSection> getAllTimeSection();

}
