package cn.gyl.laboratoryweb.dao;

/**
 * @Decription  所以数据库访问类接口的父接口,声明最基础CRUD方法
 * @authorEmail 1076030424@qq.com
 *
 */
public interface BaseDao<T> {
	
	/**
	 * 
	 * @Decription 增
	 */
	public T insert(T t);
	
	/**
	 * 
	 * @Decription 删
	 */
	public void delete(int id);
	
	/**
	 * 
	 * @Decription 改
	 */
	public void update(T t);
	
	/**
	 * 
	 * @Decription 查
	 */
	public T getOne(int id);
}
