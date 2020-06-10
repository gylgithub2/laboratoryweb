package cn.gyl.laboratoryweb.service;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface BaseService<T> {
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
