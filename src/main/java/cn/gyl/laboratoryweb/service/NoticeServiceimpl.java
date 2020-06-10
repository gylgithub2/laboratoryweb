package cn.gyl.laboratoryweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyl.laboratoryweb.dao.NoticeDao;
import cn.gyl.laboratoryweb.model.Notice;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Service("noticeService")
public class NoticeServiceimpl extends BaseServiceimpl<Notice> implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public List<Notice> getAll() {
		// TODO Auto-generated method stub
		return noticeDao.getAll();
	}

	@Override
	public Pager<Notice> getPagerNotice() {
		// TODO Auto-generated method stub
		return noticeDao.getPagerNotice();
	}

}
