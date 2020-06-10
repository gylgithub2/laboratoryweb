package cn.gyl.laboratoryweb.dao;

import java.util.List;

import cn.gyl.laboratoryweb.model.Watch;

/**
 * @Decription 观看记录信息数据库访问类接口
 * @authorEmail 1076030424@qq.com
 */
public interface WatchDao extends BaseDao<Watch> {

	/**
	 * @Decription 通过学生获取项目观看记录
	 */
	Watch getWatchByStuAndExper(Long stuAccount, Long experimentalProjectId);

	/**
	 * @Decription 获取学习的人数
	 */
	int getPreStudyNum(Integer orderPKID);

	/**
	 * @Decription 获取没学习的观看记录
	 */
	List<Watch> getUnStudyLog(Integer orderPKID);

	/**
	 * @Decription 获取没有审核的观看记录
	 */
	List<Watch> getUndoWatch();

}
