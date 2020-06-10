package cn.gyl.laboratoryweb.model;

import java.util.List;

/**
 * @Decription 分页查询类
 * @authorEmail 1076030424@qq.com
 */
public class Pager<T> {
	/**
	 * 单页条数
	 */
	private int size;
	/**
	 * 起始页
	 */
	private int offset;
	
	/**
	 * 总数据条数,此名字必须和easyui框架的分页名字一致(json)
	 */
	private long total;
	/**
	 * 取出的数据,此名字必须和easyui框架的分页名字一致(json)
	 */
	private List<T> rows;
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "Pager [size=" + size + ", offset=" + offset + ", total=" + total + ", rows=" + rows + "]";
	}
}
