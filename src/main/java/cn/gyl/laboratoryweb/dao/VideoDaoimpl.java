package cn.gyl.laboratoryweb.dao;

import org.springframework.stereotype.Repository;

import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.Video;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Repository("videoDao")
public class VideoDaoimpl extends BaseDaoimpl<Video> implements VideoDao {

	@Override
	public Pager<Video> getPageVideoByAccount(Long teacherAccount) {
		String hql = "from Video where teacherAccount= ?0";
		return super.getPageList(hql, new Object[] {teacherAccount}, null);
	}

	@Override
	public Video getVideoByExperProId(int id) {
		String hql="select v from Video v left join v.experimentalProject as e where e.experProjectPKID = ?0";
		return super.queryByHql(hql, new Object[]{id}, null);
	}

	@Override
	public Pager<Video> getPageVideo() {
		String hql = "from Video";
		return super.getPageList(hql, null, null);
	}


}
