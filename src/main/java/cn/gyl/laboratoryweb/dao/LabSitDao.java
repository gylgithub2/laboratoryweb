package cn.gyl.laboratoryweb.dao;

import java.util.List;

import cn.gyl.laboratoryweb.model.LabSit;

/**
 * @Decription 数据库访问类接口
 * @authorEmail 1076030424@qq.com
 */
public interface LabSitDao extends BaseDao<LabSit>{

	/**
	 * @Decription 获取所有座位
	 */
	List<LabSit> getAll();
}
