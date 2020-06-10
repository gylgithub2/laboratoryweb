package cn.gyl.laboratoryweb.model;
/**
 * 
 * @Decription 实验项目表的映射
 * @authorEmail 1076030424@qq.com
 */
public class ExperimentalProject {
	/**
	 * 数据库主键
	 */
    private Integer experProjectPKID;
    /**
     *  已有视频(资料)的数量
     */
    private Boolean hasVideo = false;
    /**
     * 项目的编号
     */
    private Long experimentalProjectId;
    /**
     * 项目名字
     */
    private String experimentalProjectName;
    /**
     * 项目所属实验室
     */
    private Laboratory laboratory;
    
    public Laboratory getLaboratory() {
		return laboratory;
	}

	public void setLaboratory(Laboratory laboratory) {
		this.laboratory = laboratory;
	}


	public String getExperimentalProjectName() {
		return experimentalProjectName;
	}

	public void setExperimentalProjectName(String experimentalProjectName) {
		this.experimentalProjectName = experimentalProjectName;
	}

	public Long getExperimentalProjectId() {
		return experimentalProjectId;
	}

	public void setExperimentalProjectId(Long experimentalProjectId) {
		this.experimentalProjectId = experimentalProjectId;
	}

	/**
	 * @return the experProjectPKID
	 */
	public Integer getExperProjectPKID() {
		return experProjectPKID;
	}

	/**
	 * @param experProjectPKID the experProjectPKID to set
	 */
	public void setExperProjectPKID(Integer experProjectPKID) {
		this.experProjectPKID = experProjectPKID;
	}

	/**
	 * @return the hasVideo
	 */
	public boolean getHasVideo() {
		return hasVideo;
	}

	/**
	 * @param hasVideo the hasVideo to set
	 */
	public void setHasVideo(boolean hasVideo) {
		this.hasVideo = hasVideo;
	}

}