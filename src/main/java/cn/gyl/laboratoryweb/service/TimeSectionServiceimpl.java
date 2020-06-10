package cn.gyl.laboratoryweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyl.laboratoryweb.dao.TimeSectionDao;
import cn.gyl.laboratoryweb.model.TimeSection;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Service("timeSectionService")
public class TimeSectionServiceimpl extends BaseServiceimpl<TimeSection> implements TimeSectionService{

	@Autowired
	TimeSectionDao timeSectionDao;
	@Override
	public List<TimeSection> getAllTimeSection() {
		// TODO Auto-generated method stub
		return timeSectionDao.getAllTimeSection();
	}

}
