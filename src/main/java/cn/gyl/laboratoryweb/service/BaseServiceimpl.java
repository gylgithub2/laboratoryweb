package cn.gyl.laboratoryweb.service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.gyl.laboratoryweb.dao.BaseDao;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public class BaseServiceimpl<T> implements BaseService<T>{
	
	@Autowired
	protected BaseDao<T> baseDao;

	@Override
	public T insert(T t) {
		return baseDao.insert(t);
	}
	@Override
	public void delete(int id) {
		baseDao.delete(id);	
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}
	@Override
	public T getOne(int id) {
		return baseDao.getOne(id);
	}

}
