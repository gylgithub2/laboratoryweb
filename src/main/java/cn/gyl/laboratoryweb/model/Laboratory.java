package cn.gyl.laboratoryweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @Decription 实验室的数据库ORM映射
 * @authorEmail 1076030424@qq.com
 */
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Laboratory {
    private Integer laboratoryPKID;
    /**
     * 实验室编号
     */
    private Long laboratoryId;
    
    /**
     * 实验室的名字
     */
    private String laboratoryName;
    
    /**
     * 实验室提供的总实验座位数量
     */
    private Integer laboratorySitNum;

    
    /**
     * 实验室的状态   0不可用/1可用
     */
    private Integer laboratoryStatus;
    


	public Long getLaboratoryId() {
		return laboratoryId;
	}

	public void setLaboratoryId(Long laboratoryId) {
		this.laboratoryId = laboratoryId;
	}

	public String getLaboratoryName() {
		return laboratoryName;
	}

	public void setLaboratoryName(String laboratoryName) {
		this.laboratoryName = laboratoryName;
	}

	public Integer getLaboratorySitNum() {
		return laboratorySitNum;
	}

	public void setLaboratorySitNum(Integer laboratorySitNum) {
		this.laboratorySitNum = laboratorySitNum;
	}

	public Integer getLaboratoryStatus() {
		return laboratoryStatus;
	}

	public void setLaboratoryStatus(Integer laboratoryStatus) {
		this.laboratoryStatus = laboratoryStatus;
	}

	/**
	 * @return the laboratoryPKID
	 */
	public Integer getLaboratoryPKID() {
		return laboratoryPKID;
	}

	/**
	 * @param laboratoryPKID the laboratoryPKID to set
	 */
	public void setLaboratoryPKID(Integer laboratoryPKID) {
		this.laboratoryPKID = laboratoryPKID;
	}



}