package cn.gyl.laboratoryweb.service;

import java.util.List;

import cn.gyl.laboratoryweb.model.Notice;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface NoticeService extends BaseService<Notice>{

	/**
	 * @Decription
	 */
	public List<Notice> getAll();

	/**
	 * @Decription
	 */
	public Pager<Notice> getPagerNotice();

}
