package cn.gyl.laboratoryweb.dao;

import java.util.List;

import cn.gyl.laboratoryweb.model.Laboratory;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription 实验室信息数据库访问接口
 * @authorEmail 1076030424@qq.com
 */
public interface LaboratoryDao extends BaseDao<Laboratory> {

	/**
	 * @Decription 获取分页实验室信息
	 */
	Pager<Laboratory> getAllPageLaboratorys(String laboratoryName);

	/**
	 * @Decription 获取所有实验室信息
	 */
	List<Laboratory> getAllLaboratory();

	/**
	 * @Decription 通过实验室账号获取实验室
	 */
	Laboratory getOneByLabId(Long labId);


}
