package cn.gyl.laboratoryweb.dao;

import java.util.List;

import cn.gyl.laboratoryweb.model.Notice;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription 公告信息数据库访问类接口
 * @authorEmail 1076030424@qq.com
 */
public interface NoticeDao extends BaseDao<Notice> {

	/**
	 * @Decription 获取全部公告信息
	 */
	List<Notice> getAll();

	/**
	 * @Decription 获取分页公告信息
	 */
	Pager<Notice> getPagerNotice();

}
