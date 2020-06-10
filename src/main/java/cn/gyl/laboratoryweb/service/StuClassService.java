package cn.gyl.laboratoryweb.service;

import java.util.List;

import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.StuClass;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface StuClassService extends BaseService<StuClass> {

	public List<StuClass> getTeacherStuClass(Long teacherAccount);

	public Pager<StuClass> getAllPageTeacherClasses(Long teacherAccount);

	public StuClass getStuClassByAccount(Long stuClass);

	/**
	 * @Decription
	 */
	public StuClass getClassByName(String classn);

	/**
	 * @param stuClass 
	 * @Decription
	 */
	public Pager<StuClass> getAllPageClasses(StuClass stuClass);

}
