package cn.gyl.laboratoryweb.service;

import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.Video;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface VideoService extends BaseService<Video> {

	/**
	 * @Decription
	 */
	Pager<Video> getPageVideoByAccount(Long attribute);

	/**
	 * @Decription
	 */
	Video getVideoByExperProId(int id);

	/**
	 * @Decription
	 */
	Pager<Video> getPageVideo();

}
