package cn.gyl.laboratoryweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gyl.laboratoryweb.model.Watch;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Repository("watchDao")
public class WatchDaoimpl extends BaseDaoimpl<Watch> implements WatchDao {
	@Override
	public Watch getWatchByStuAndExper(Long stuAccount, Long experimentalProjectId) {
		String hql = "select w from Watch w where studentAccount = ?0 And experimentalProjectId = ?1";
		return super.queryByHql(hql, new Object[] {stuAccount,experimentalProjectId}, null);
	}

	@Override
	public int getPreStudyNum(Integer orderPKID) {
		String hql = "select count(*) from Watch where relateOrder = ?0  And status >=90";
		
		return super.getCountByHql(hql, new Object[] {orderPKID});
	}

	@Override
	public List<Watch> getUnStudyLog(Integer orderPKID) {
		String hql = "select w from Watch w where relateOrder = ?0 And status < 90 AND TO_DAYS(now()) >= TO_DAYS(deadline)";
		return super.getList(hql, new Object[] {orderPKID},null);
	}

	@Override
	public List<Watch> getUndoWatch() {
		String hql = "select w from Watch w where isCheck = 0 And TO_DAYS(now()) >= TO_DAYS(deadline) And status < 90";
		return super.getList(hql, null,null);
	}

}
