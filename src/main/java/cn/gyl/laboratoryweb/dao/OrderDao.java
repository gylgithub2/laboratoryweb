package cn.gyl.laboratoryweb.dao;

import java.util.Date;
import java.util.List;

import cn.gyl.laboratoryweb.model.Order;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription 预约信息数据库访问类接口
 * @authorEmail 1076030424@qq.com
 */
public interface OrderDao extends BaseDao<Order> {
	public Pager<Order> getAllPageOrders();

	/**
	 * @Decription 确认预约
	 */
	public void confirmOrder(int i);

	/**
	 * @Decription 获取分页旧预约
	 */
	public Pager<Order> getAllPageOldOrders(int id);

	/**
	 * @Decription 根据用户账号获取预约
	 */
	public Pager<Order> getPagerOrderByAccount(Long userAccount);

	/**
	 * @Decription 根据班级获取预约
	 */
	public Pager<Order> getOrderByClassId(Long stuClassId);

	/**
	 * @Decription 根据用户账号获取分页预约
	 */
	public Pager<Order> getPassOrderByAccount(Long userAccount);

	/**
	 * @Decription 获取用户的预约数
	 */
	public int queryUserNowOrder(Long userId);

	/**
	 * @Decription 获取该时间是否被班级预约
	 */
	public boolean getLabIsClasOrdered(Long laboratoryId,Date date);

	/**
	 * @Decription 获取实验室已使用的座位
	 */
	public int getLabOrderedSits(Long laboratoryId, Date startTime);

	/**
	 * @Decription 判断该学生是否已经预约这个时间段的实验室了
	 */
	public boolean isStuOrdered(Date startTime,Long studentAccount);

	/**
	 * @Decription 获取学生的分页预约信息
	 */
	public Pager<Order> getStudentOrder(Long studentAccount, Long stuClass);
	/**
	 * 
	 * @Decription 获取学生现在的预约数
	 */
	public int getStudentNowOrderNum(Long studentAccount, Long stuClass);

	/**
	 * @Decription 获取学生的历史预约数
	 */
	public int getStudentOrderNum(Long studentAccount, Long stuClass);
	
	/**
	 * 
	 * @Decription 获取学生现在的预约
	 */
	public List<Order> getStudentNowOrder(Long studentAccount, Long stuClass);

	/**
	 * @Decription 获取老师历史预约次数
	 */
	public int getTeacherOrderNum(Long userAccountNum);

	/**
	 * @Decription 获取老师现在的预约记录
	 */
	public List<Order> getTeacherNowOrder(Long userAccountNum);

	/**
	 * @Decription 获取无用的预约信息
	 */
	public List<Order> getUnuseORder();

	/**
	 * @param i 
	 * @Decription 该座位是否被预约
	 */
	public boolean getLabSitIsOrder(Long laboratoryId, Date startTime, int i);
}
