package cn.gyl.laboratoryweb.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.SystemContext;

/**
 * @Decription 接口实现类父类,主要提供基础方法的实现
 * @authorEmail 1076030424@qq.com
 */
@SuppressWarnings(value = { "rawtypes", "unchecked" })
public class BaseDaoimpl<T> implements BaseDao<T> {
	@Autowired
	private SessionFactory sessionFactory;

	private Class<?> clazz;

	/**
	 * @Decription 子类继承后通过反射获取父类泛型的泛型参数,也就是调用类的运行时对象
	 */
	private Class<?> getClazz() {
		if (clazz == null) {
			clazz = ((Class<?>) ((((ParameterizedType) (this.getClass().getGenericSuperclass()))
					.getActualTypeArguments())[0]));
		}
		return clazz;
	}
	/**
	 * 
	 * @Decription 获取连接
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 增加数据
	 */
	@Override
	public T insert(T t) {
		getSession().save(t);
		return t;
	}

	/**
	 * 删除数据
	 */
	@Override
	public void delete(int id) {
		getSession().delete(getOne(id));
	}

	/**
	 * 更新数据
	 */
	@Override
	public void update(T t) {
		getSession().update(t);
	}

	/**
	 * 查询单条
	 */
	@Override
	public T getOne(int id) {
		return (T) getSession().load(getClazz(), id);
	}

	/**
	 * 
	 * @Decription 根据hql查询多条
	 * @param hql     查询语句
	 * @param objects "?"占位符
	 * @param map     别名占位符
	 */
	public List<T> getList(String hql, Object[] objects, Map<String, Object> alias) {
		// 排序规则
		hql = initSort(hql);
		Query<T> query = getSession().createQuery(hql);
		addParameter(query, objects);
		addAliasParameter(query, alias);
		return query.list();

	}

	/**
	 * @Decription 加入别名占位符
	 */
	private void addAliasParameter(Query<T> query, Map<String, Object> alias) {

		if (alias != null && alias.size() > 0) {
			Set<String> keys = alias.keySet();
			for (String key : keys) {
				Object value = alias.get(key);
				if (value instanceof Collection) {
					query.setParameterList(key, (Collection) value);
				} else {
					query.setParameter(key, value);
				}
			}
		}
	}
	/**
	 * @Decription 加入?占位符
	 */
	private void addParameter(Query<T> query, Object[] objects) {
		if (objects != null && objects.length > 0) {
			int index = 0;
			for (Object object : objects) {
				query.setParameter(index++, object);
			}
		}
	}

	/**
	 * 
	 * @Decription 重构hql为排序
	 */
	private String initSort(String hql) {
		String sort = SystemContext.getSort();
		String order = SystemContext.getOrder();
		if (sort != null && !"".equals(sort.trim())) {
			hql += "order by " + sort;
			if (!"desc".equals(order)) {
				hql += " asc";
			} else {
				hql += " desc";
			}
		}
		return hql;
	}

	/**
	 * 
	 * @Decription 支持分页的查询
	 */
	public Pager<T> getPageList(String hql, Object[] objects, Map<String, Object> alias) {
		Pager<T> pager = new Pager<T>();
		Query<T> query = getSession().createQuery(hql);
		hql = initSort(hql);
		addParameter(query, objects);
		addAliasParameter(query, alias);
		setPager(pager,query);
		List<T> list = query.list();
		pager.setRows(list);
		//总条数获取
		Query queryCount = getSession().createQuery(getCount(hql));
		addParameter(queryCount, objects);
		addAliasParameter(queryCount, alias);
		pager.setTotal((Long)queryCount.uniqueResult());
		return pager;
	}
	/**
	 * @Decription 获取总条数的方法
	 */
	private String getCount(String hql) {
		return ("select Count(*) "+hql.substring(hql.indexOf("from"))).replace("fetch", "");
	}
	/**
	 * @Decription 单独执行获取总条数的hql的方法
	 */
	public int getCountByHql(String hql,Object[] objects) {
		Query<T> query = getSession().createQuery(hql);
		addParameter(query, objects);
		return (new Integer(query.uniqueResult().toString())).intValue();
	}
	/**
	 * 
	 * @Decription pager的数据封装,以及修改(query)hql
	 */
	public void setPager(Pager<T> pager, Query<T> query) {
		Integer pageSize = SystemContext.getPageSize();
		Integer pageOffset = SystemContext.getPageOffset();
		if (pageOffset == null || pageOffset < 0) {
			pageOffset = 0;
		}
		if (pageSize == null || pageSize < 0) {
			pageSize = 10;
		}
		pager.setOffset(pageOffset);
		pager.setSize(pageSize);
		//分页查询
	     query.setFirstResult(pageOffset).setMaxResults(pageSize);
	}
	
	/**
	 * 
	 * @Decription 执行hql的方法,适用于特殊的查询
	 */
	public T queryByHql(String hql, Object[] objects, Map<String, Object> alias) {
		// 排序规则
		Query query = getSession().createQuery(hql);
		addParameter(query, objects);
		addAliasParameter(query, alias);
		Object result = query.uniqueResult();
		return (T)result;
	}
	
	/**
	 * 
	 * @Decription 执行hql的方法,适用于特殊的更新
	 */
	public void updateByHql(String hql, Object[] objects, Map<String, Object> alias) {
		// 排序规则

		Query query = getSession().createQuery(hql);
		addParameter(query, objects);
		addAliasParameter(query, alias);
		query.executeUpdate();
	}
}
