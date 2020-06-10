package cn.gyl.laboratoryweb.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gyl.laboratoryweb.model.Order;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Repository("orderDao")
public class OrderDaoimpl extends BaseDaoimpl<Order> implements OrderDao {

	@Override
	public Pager<Order> getAllPageOrders() {
		String hql = "from Order where status = 0 And startTime > now()";
		return super.getPageList(hql, null, null);
	}

	@Override
	public Pager<Order> getAllPageOldOrders(int id) {
		String hql = "from Order where status = 1";
		if (id != 0) {
			hql += "And userId= " + id + " OR roomId =" + id;
		}
		return super.getPageList(hql, null, null);
	}

	@Override
	public void confirmOrder(int i) {
		Order order = super.getOne(i);
		order.setStatus(1);
		super.update(order);
	}

	@Override
	public Pager<Order> getPagerOrderByAccount(Long userAccount) {
		String hql = "from Order where userId = ?0";
		return super.getPageList(hql, new Object[] { userAccount }, null);
	}

	@Override
	public Pager<Order> getOrderByClassId(Long stuClassId) {
		String hql = "from Order where stuClass = ?0 ANd status =1";
		return super.getPageList(hql, new Object[] { stuClassId }, null);
	}

	@Override
	public Pager<Order> getPassOrderByAccount(Long userAccount) {
		String hql = "from Order where userId = ?0 And status = 1";
		return super.getPageList(hql, new Object[] { userAccount }, null);
	}

	@Override
	public int queryUserNowOrder(Long userId) {
		String hql = "select count(*) from Order where userId = ?0 And endTime > now() And status in(0,1) ";
		return super.getCountByHql(hql, new Object[] { userId });
	}

	@Override
	public boolean getLabIsClasOrdered(Long laboratoryId, Date startDate) {
		String hql = "from Order where roomId = ?0 And startTime = ?1 And endTime > now() And stuClass IS NOT NULL And status in(0,1)";
		Order order = super.queryByHql(hql, new Object[] { laboratoryId, startDate }, null);
		return order != null ? true : false;
	}

	@Override
	public int getLabOrderedSits(Long laboratoryId, Date startTime) {
		String hql = "select count(*) from Order  where roomId = ?0 And startTime = ?1 And endTime > now() And stuClass IS  NULL And status in(0,1)";
		return super.getCountByHql(hql, new Object[] { laboratoryId, startTime });
	}

	@Override
	public boolean isStuOrdered(Date startTime, Long studentAccount) {
		String hql = "from Order where userId = ?0 And startTime = ?1 And endTime > now() And stuClass IS NULL And status in(0,1)";
		Order order = super.queryByHql(hql, new Object[] { studentAccount, startTime }, null);
		return order != null ? true : false;
	}

	@Override
	public Pager<Order> getStudentOrder(Long studentAccount, Long stuClass) {
		String hql = "from Order where userId = ?0 OR stuClass= ?1";
		return super.getPageList(hql, new Object[] { studentAccount, stuClass }, null);
	}

	@Override
	public int getStudentNowOrderNum(Long studentAccount, Long stuClass) {
		String hql = "select count(*)  from Order where (userId = ?0 OR stuClass= ?1) And endTime > now() And status = 1";
		return super.getCountByHql(hql, new Object[] { studentAccount, stuClass });
	}

	@Override
	public List<Order> getStudentNowOrder(Long studentAccount, Long stuClass) {
		String hql = "from Order where (userId = ?0 OR stuClass= ?1 ) And startTime > now() And status = 1  order by startTime";
		return super.getList(hql, new Object[] { studentAccount, stuClass }, null);
	}

	@Override
	public int getStudentOrderNum(Long studentAccount, Long stuClass) {
		String hql = "select count(*)  from Order where (userId = ?0 OR stuClass= ?1) And status = 1";
		return super.getCountByHql(hql, new Object[] { studentAccount, stuClass });
	}

	@Override
	public int getTeacherOrderNum(Long userAccountNum) {
		String hql = "select count(*)  from Order where userId = ?0  And status = 1";
		return super.getCountByHql(hql, new Object[] { userAccountNum });
	}

	@Override
	public List<Order> getTeacherNowOrder(Long userAccountNum) {
		String hql = "from Order where userId = ?0 And startTime > now() And status = 1  order by startTime";
		return super.getList(hql, new Object[] { userAccountNum }, null);
	}

	@Override
	public List<Order> getUnuseORder() {
		String hql = "from Order where status = 0 And startTime < now()";
		return super.getList(hql, null, null);
	}

	@Override
	public boolean getLabSitIsOrder(Long laboratoryId, Date startTime, int i) {
		String hql = "select o from Order o where roomId = ?0 And startTime = ?1 And endTime > now() And roomSitId = ?2 And stuClass IS  NULL And status in(0,1)";

		return super.queryByHql(hql, new Object[] { laboratoryId, startTime, i }, null) != null;
	}
}
