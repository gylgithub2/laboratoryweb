package cn.gyl.laboratoryweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyl.laboratoryweb.dao.MessageDao;
import cn.gyl.laboratoryweb.model.Message;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Service("messageService")
public class MessageServiceimpl extends BaseServiceimpl<Message> implements MessageService	 {
	@Autowired
	private MessageDao messageDao;
	@Override
	public Pager<Message>  getStuAppeal() {
		// TODO Auto-generated method stub
		return messageDao.getStuAppeal();
	}
	@Override
	public List<Message> getNewMsg() {
		// TODO Auto-generated method stub
		return messageDao.getNewMsg();
	}
	@Override
	public Pager<Message> getPagerNMSG() {
		// TODO Auto-generated method stub
		return messageDao.getPagerNMSG();
	}
	@Override
	public List<Message> getUserNewMsg(Long userId) {
		// TODO Auto-generated method stub
		return messageDao.getUserNewMsg(userId);
	}
	@Override
	public Pager<Message> getPagerUserNMSG(Long userId) {
		// TODO Auto-generated method stub
		return messageDao.getPagerUserNMSG(userId);
	}

}
