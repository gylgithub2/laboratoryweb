package cn.gyl.laboratoryweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyl.laboratoryweb.dao.VideoDao;
import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.Video;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Service("videoService")
public class VideoServiceimpl extends BaseServiceimpl<Video> implements VideoService {
	@Autowired
	VideoDao videoDao;
	@Override
	public Pager<Video> getPageVideoByAccount(Long teacherAccount) {
		return videoDao.getPageVideoByAccount(teacherAccount);
	}
	@Override
	public Video getVideoByExperProId(int id) {
		return videoDao.getVideoByExperProId(id);
	}
	@Override
	public Pager<Video> getPageVideo() {
		// TODO Auto-generated method stub
		return  videoDao.getPageVideo();
	}



}
