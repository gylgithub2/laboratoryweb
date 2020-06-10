package cn.gyl.laboratoryweb.service;

import java.util.Date;
import java.util.List;

import cn.gyl.laboratoryweb.model.Order;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface OrderService extends BaseService<Order> {
	public Pager<Order> getAllPageOrders();

	public Pager<Order> getAllPageOldOrders(int id);

	/**
	 * @Decription
	 */
	public void confirmOrder(int i);

	/**
	 * @Decription
	 */
	public Pager<Order> getPagerOrderByAccount(Long userAccount);

	/**
	 * @Decription
	 */
	public Pager<Order> getOrderByClassId(Long stuClassId);

	/**
	 * @Decription
	 */
	public Pager<Order> getPassOrderByAccount(Long userAccount);

	/**
	 * @Decription
	 */
	public int queryUserNowOrder(Long userId);

	/**
	 * @param date
	 * @Decription
	 */
	public boolean getLabIsClasOrdered(Long laboratoryId, Date date);

	/**
	 * @Decription
	 */
	public int getLabOrderedSits(Long laboratoryId, Date startTime);

	/**
	 * @Decription
	 */
	public boolean isStuOrdered(Date startTime, Long studentAccount);

	/**
	 * @Decription
	 */
	public Pager<Order> getStudentOrder(Long studentAccount, Long stuClass);

	public int getStudentNowOrderNum(Long studentAccount, Long stuClass);

	int getStudentOrderNum(Long studentAccount, Long stuClass);

	public List<Order> getStudentNowOrder(Long studentAccount, Long stuClass);

	/**
	 * @Decription
	 */
	public int getTeacherOrderNum(Long userAccountNum);

	/**
	 * @Decription
	 */
	public List<Order> getTeacherNowOrder(Long userAccountNum);

	/**
	 * @Decription
	 */
	public List<Order> getUnuseORder();

	/**
	 * @param i 
	 * @Decription
	 */
	public boolean getLabSitIsOrder(Long laboratoryId, Date startTime, int i);
}
