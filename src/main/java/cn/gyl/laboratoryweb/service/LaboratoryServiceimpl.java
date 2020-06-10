package cn.gyl.laboratoryweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyl.laboratoryweb.dao.LaboratoryDao;
import cn.gyl.laboratoryweb.model.Laboratory;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Service("laboratoryService")
public class LaboratoryServiceimpl extends BaseServiceimpl<Laboratory> implements LaboratoryService {
	
	 
	@Autowired
	private LaboratoryDao laboratoryDao;
	@Override
	public Pager<Laboratory> getAllPageLaboratorys(String laboratoryName) {
		return laboratoryDao.getAllPageLaboratorys(laboratoryName);
	}
	@Override
	public List<Laboratory> getAllLaboratory() {
		return laboratoryDao.getAllLaboratory();
	}
	@Override
	public Laboratory getOneByLabId(Long labId) {
		return laboratoryDao.getOneByLabId(labId);
	}



}
