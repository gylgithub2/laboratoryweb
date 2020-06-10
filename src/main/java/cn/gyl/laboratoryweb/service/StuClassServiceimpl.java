package cn.gyl.laboratoryweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyl.laboratoryweb.dao.StuClassDao;
import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.StuClass;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */

@Service(value="stuClassService")
public class StuClassServiceimpl extends BaseServiceimpl<StuClass> implements StuClassService {

	@Autowired 
	private StuClassDao stuClassDao;
	@Override
	public List<StuClass> getTeacherStuClass(Long teacherAccount) {
		return stuClassDao.getTeacherStuClass(teacherAccount);
	}
	@Override
	public Pager<StuClass> getAllPageTeacherClasses(Long teacherAccount) {
		return stuClassDao.getAllPageTeacherClasses(teacherAccount);
	}
	@Override
	public StuClass getStuClassByAccount(Long stuClass) {
		return stuClassDao.getStuClassByAccount(stuClass);
	}
	@Override
	public StuClass getClassByName(String classn) {
		return stuClassDao.getClassByName(classn);
	}
	@Override
	public Pager<StuClass> getAllPageClasses(StuClass stuClass) {
		return stuClassDao.getAllPageClasses(stuClass);
	}


}
