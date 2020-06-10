package cn.gyl.laboratoryweb.model;

/**
 * @Decription 座位表映射类
 * @authorEmail 1076030424@qq.com
 */
public class LabSit {
	//主键
	private Integer labSitPKID;
	//对应的实验室
	private Long labID;
	//座位号
	private Integer sitId;
	//状态 1可用 2不可用
	private Integer status;
	
	public Integer getLabSitPKID() {
		return labSitPKID;
	}
	public void setLabSitPKID(Integer labSitPKID) {
		this.labSitPKID = labSitPKID;
	}
	public Long getLabID() {
		return labID;
	}
	public void setLabID(Long labID) {
		this.labID = labID;
	}
	public Integer getSitId() {
		return sitId;
	}
	public void setSitId(Integer sitId) {
		this.sitId = sitId;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
}
