package cn.gyl.laboratoryweb.dao;

import java.util.List;

import cn.gyl.laboratoryweb.model.Message;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface MessageDao extends BaseDao<Message> {

	/**
	 * @Decription 获取学生未批阅的解封请求
	 */
	Pager<Message>  getStuAppeal();

	/**
	 * @Decription 获取所有消息
	 */
	List<Message> getNewMsg();

	/**
	 * @Decription 获取分页消息
	 */
	Pager<Message> getPagerNMSG();

	/**
	 * @Decription 获取用户的新消息
	 */
	List<Message> getUserNewMsg(Long userId);

	/**
	 * @Decription 获取分页的用户新消息
	 */
	Pager<Message> getPagerUserNMSG(Long userId);

}
