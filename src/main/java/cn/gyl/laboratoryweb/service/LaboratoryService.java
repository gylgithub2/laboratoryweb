package cn.gyl.laboratoryweb.service;

import java.util.List;

import cn.gyl.laboratoryweb.model.Laboratory;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface LaboratoryService extends BaseService<Laboratory> {

	/**
	 * @Decription
	 */
	Pager<Laboratory> getAllPageLaboratorys(String laboratoryName);

	/**
	 * @Decription
	 */
	List<Laboratory> getAllLaboratory();

	/**
	 * @Decription
	 */
	Laboratory getOneByLabId(Long labId);

	
}
