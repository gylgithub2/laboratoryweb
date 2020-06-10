package cn.gyl.laboratoryweb.model;

/**
 * 
 * @Decription 管理员表映射类
 * @authorEmail 1076030424@qq.com
 */
public class Admin {
	/**
	 * 数据库主键,对象唯一标识
	 */
    private Integer adminPKID;
    /**
     * 管理员名字
     */
    private String adminName;
    /**
     * 管理员账号,登录账号
     */
    private Long adminAccount;
    /**
     * 管理员密码
     */
	private String adminPassword;

	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public Long getAdminAccount() {
		return adminAccount;
	}
	public void setAdminAccount(Long adminAccount) {
		this.adminAccount = adminAccount;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Integer getAdminPKID() {
		return adminPKID;
	}
	public void setAdminPKID(Integer adminPKID) {
		this.adminPKID = adminPKID;
	}

}