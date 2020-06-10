package cn.gyl.laboratoryweb.model;

/**
 * @Decription  保存分页信息,各个用户线程通信,排序信息等
 * @authorEmail 1076030424@qq.com
 */
public class SystemContext {
	//分页大小
	private static ThreadLocal<Integer> pageSize =new ThreadLocal<Integer>();
	//每页起始索引
	private static ThreadLocal<Integer> pageOffset =new ThreadLocal<Integer>();
	
	//排序的规则
	private static ThreadLocal<String> sort =new ThreadLocal<String>();
	//排序方式
	private static ThreadLocal<String> order =new ThreadLocal<String>();
	
	/**
	 * 
	 * @Decription get和set被普通Javabean不同
	 */
	public static Integer getPageSize() {
		return pageSize.get();
	}
	public static void setPageSize(Integer pageSize) {
		SystemContext.pageSize.set(pageSize);
	}
	public static Integer getPageOffset() {
		return pageOffset.get();
	}
	public static void setPageOffset(Integer pageOffset) {
		SystemContext.pageOffset.set(pageOffset);
	}
	public static String getSort() {
		return sort.get();
	}
	public static void setSort(String sort) {
		SystemContext.sort.set(sort);
	}
	public static String getOrder() {
		return order.get();
	}
	public static void setOrder(String order) {
		SystemContext.order.set(order);
	}
	
	/**
	 * 
	 * @Decription 移除
	 */
	public static void removePageSize() {
		pageSize.remove();
	}
	public static void removePageOffset() {
		pageOffset.remove();
	}
	public static void removeSort() {
		sort.remove();
	}
	public static void removeOrder() {
		order.remove();
	}

}
