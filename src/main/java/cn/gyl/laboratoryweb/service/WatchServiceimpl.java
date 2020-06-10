package cn.gyl.laboratoryweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyl.laboratoryweb.dao.WatchDao;
import cn.gyl.laboratoryweb.model.Watch;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Service("watchService")
public class WatchServiceimpl extends BaseServiceimpl<Watch> implements WatchService {
	
	@Autowired
	private WatchDao watchDao;
	@Override
	public Watch getWatchByStuAndExper(Long stuAccount, Long experimentalProjectId) {
		return watchDao.getWatchByStuAndExper(stuAccount,experimentalProjectId);
		
	}
	@Override
	public int getPreStudyNum(Integer orderPKID) {
		return watchDao.getPreStudyNum(orderPKID);
	}
	@Override
	public List<Watch> getUnStudyLog(Integer orderPKID) {
		return watchDao.getUnStudyLog(orderPKID);
	}
	@Override
	public List<Watch> getUndoWatch() {
		// TODO Auto-generated method stub
		return watchDao.getUndoWatch();
	}
	
	
	

}
