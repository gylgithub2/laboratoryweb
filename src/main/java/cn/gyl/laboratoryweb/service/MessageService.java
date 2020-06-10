package cn.gyl.laboratoryweb.service;

import java.util.List;

import cn.gyl.laboratoryweb.model.Message;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface MessageService extends BaseService<Message> {

	/**
	 * @Decription
	 */
	Pager<Message>  getStuAppeal();

	/**
	 * @Decription
	 */
	List<Message> getNewMsg();

	/**
	 * @Decription
	 */
	Pager<Message> getPagerNMSG();

	/**
	 * @Decription
	 */
	List<Message> getUserNewMsg(Long userId);
	Pager<Message> getPagerUserNMSG(Long userId);

}
