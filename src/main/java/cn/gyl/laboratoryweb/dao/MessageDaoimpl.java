package cn.gyl.laboratoryweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gyl.laboratoryweb.model.Message;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Repository(value = "messageDao")
public class MessageDaoimpl extends BaseDaoimpl<Message> implements MessageDao {

	@Override
	public Pager<Message> getStuAppeal() {
		String hql = "select m from Message m where status = 1 And msgType = 1 ";
		return super.getPageList(hql, null, null);
	}

	@Override
	public List<Message> getNewMsg() {
		String hql = "select m from Message m where msgType = 0 And status = 1 ";
		return super.getList(hql, null, null);
	}

	@Override
	public Pager<Message> getPagerNMSG() {
		String hql = "select m from Message m where m.msgType = 0 ORDER bY m.status ASC,m.msgDate DESC";
		return super.getPageList(hql, null, null);
	}

	@Override
	public Pager<Message> getPagerUserNMSG(Long userId) {
		String hql = "select m from Message m where userId = ?0 And status = 3 ORDER bY m.status ASC,m.msgDate DESC";
		String hql2 = "select m from Message m where msgType = ?0 ";
		List<Message> list = super.getList(hql, new Object[] { userId }, null);
		List<Message> list2 = new ArrayList<Message>();
		if (list != null) {
			for (Message msg : list) {
				Message queryByHql = super.queryByHql(hql2, new Object[] { msg.getMessagePKID()+1 }, null);
				if (queryByHql != null) {
					list2.add(queryByHql);
				}
			}
		}
		Pager<Message> pager = new Pager<Message>();
		pager.setRows(list2);
		return pager;
	}

	@Override
	public List<Message> getUserNewMsg(Long userId) {
		String hql = "select m from Message m where userId = ?0 And status = 3";
		String hql2 = "select m from Message m where msgType = ?0 And status = 1";
		List<Message> list = super.getList(hql, new Object[] { userId }, null);
		List<Message> list2 = new ArrayList<Message>();
		if (list != null) {
			for (Message msg : list) {
				Message queryByHql = super.queryByHql(hql2, new Object[] { msg.getMessagePKID()+1 }, null);
				if (queryByHql != null) {
					list2.add(queryByHql);
				}
			}
		}
		return list2;
	}

}
