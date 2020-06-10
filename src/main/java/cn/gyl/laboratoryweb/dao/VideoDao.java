package cn.gyl.laboratoryweb.dao;

import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.Video;

/**
 * @Decription 数字化资源信息数据库访问类接口
 * @authorEmail 1076030424@qq.com
 */
public interface VideoDao extends BaseDao<Video> {

	/**
	 * @Decription 通过教师账号获取分页信息
	 */
	Pager<Video> getPageVideoByAccount(Long teacherAccount);

	/**
	 * @Decription 通过项目账号获取数字化资源信息
	 */
	Video getVideoByExperProId(int id);

	/**
	 * @Decription 获取分页数字化资源信息
	 */
	Pager<Video> getPageVideo();

}
