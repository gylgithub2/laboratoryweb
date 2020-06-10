package cn.gyl.laboratoryweb.model;

/**
 * @Decription 一天中的时间段数据库映射类
 * @authorEmail 1076030424@qq.com
 */
public class TimeSection {
	/**
	 * 数据库主键,对象唯一标识
	 */
	private Integer timeSectionPKID;
	/**
	 * 开始时间
	 */
	private String startTime;
	/**
	 * 结束时间
	 */
	private String endTime;
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getTimeSectionPKID() {
		return timeSectionPKID;
	}
	public void setTimeSectionPKID(Integer timeSectionPKID) {
		this.timeSectionPKID = timeSectionPKID;
	}
}
