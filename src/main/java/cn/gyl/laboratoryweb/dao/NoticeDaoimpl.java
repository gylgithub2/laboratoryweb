package cn.gyl.laboratoryweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gyl.laboratoryweb.model.Notice;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Repository("noticeDao")
public class NoticeDaoimpl extends BaseDaoimpl<Notice> implements NoticeDao{

	@Override
	public List<Notice> getAll() {
		String hql = "select n from Notice n";
		return super.getList(hql, null, null);
	}

	@Override
	public Pager<Notice> getPagerNotice() {
		String hql = "from Notice ";
		return super.getPageList(hql, null, null);
	}

}
