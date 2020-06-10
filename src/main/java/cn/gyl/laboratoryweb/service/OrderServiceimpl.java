package cn.gyl.laboratoryweb.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyl.laboratoryweb.dao.OrderDao;
import cn.gyl.laboratoryweb.model.Order;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Service("orderService")
public class OrderServiceimpl extends BaseServiceimpl<Order> implements OrderService {
	@Autowired
	private OrderDao orderDao;

	@Override
	public Pager<Order> getAllPageOrders() {
		return orderDao.getAllPageOrders();
	}

	@Override
	public void confirmOrder(int i) {
		orderDao.confirmOrder(i);

	}

	@Override
	public Pager<Order> getAllPageOldOrders(int id) {
		return orderDao.getAllPageOldOrders(id);
	}

	@Override
	public Pager<Order> getPagerOrderByAccount(Long userAccount) {
		return orderDao.getPagerOrderByAccount(userAccount);
	}

	@Override
	public Pager<Order> getOrderByClassId(Long stuClassId) {
		return orderDao.getOrderByClassId(stuClassId);
	}

	@Override
	public Pager<Order> getPassOrderByAccount(Long userAccount) {
		return orderDao.getPassOrderByAccount(userAccount);
	}

	@Override
	public int queryUserNowOrder(Long userId) {
		return orderDao.queryUserNowOrder(userId);
	}

	@Override
	public boolean getLabIsClasOrdered(Long laboratoryId,Date date) {
		return orderDao.getLabIsClasOrdered(laboratoryId,date);
	}

	@Override
	public int getLabOrderedSits(Long laboratoryId, Date startTime) {
		return orderDao.getLabOrderedSits(laboratoryId,startTime);
	}

	@Override
	public boolean isStuOrdered(Date startTime,Long studentAccount) {
		return orderDao.isStuOrdered(startTime,studentAccount);
	}

	@Override
	public Pager<Order> getStudentOrder(Long studentAccount, Long stuClass) {
		return orderDao.getStudentOrder(studentAccount,stuClass);
	}
	@Override
	public int getStudentNowOrderNum(Long studentAccount, Long stuClass) {
		return orderDao.getStudentNowOrderNum(studentAccount,stuClass);
	}

	@Override
	public int getStudentOrderNum(Long studentAccount, Long stuClass) {
		return orderDao.getStudentOrderNum(studentAccount, stuClass);
	}

	@Override
	public List<Order> getStudentNowOrder(Long studentAccount, Long stuClass) {
		return orderDao.getStudentNowOrder(studentAccount, stuClass);
	}

	@Override
	public int getTeacherOrderNum(Long userAccountNum) {
		return orderDao.getTeacherOrderNum(userAccountNum);
	}

	@Override
	public List<Order> getTeacherNowOrder(Long userAccountNum) {
		return orderDao.getTeacherNowOrder(userAccountNum);
	}

	@Override
	public List<Order> getUnuseORder() {
		// TODO Auto-generated method stub
		return orderDao.getUnuseORder();
	}

	@Override
	public boolean getLabSitIsOrder(Long laboratoryId, Date startTime,int i) {
		// TODO Auto-generated method stub
		return orderDao.getLabSitIsOrder(laboratoryId,startTime,i);
	}


}
