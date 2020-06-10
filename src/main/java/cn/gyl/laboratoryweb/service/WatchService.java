package cn.gyl.laboratoryweb.service;

import java.util.List;

import cn.gyl.laboratoryweb.model.Watch;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface WatchService extends BaseService<Watch> {

	/**
	 * @Decription
	 */
	Watch getWatchByStuAndExper(Long stuAccount, Long experimentalProjectId);

	/**
	 * @Decription
	 */
	int getPreStudyNum(Integer orderPKID);

	/**
	 * @Decription
	 */
	List<Watch> getUnStudyLog(Integer orderPKID);

	/**
	 * @Decription
	 */
	List<Watch> getUndoWatch();

}
