package cn.gyl.laboratoryweb.dao;

import java.util.List;

import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.StuClass;

/**
 * @Decription 班级信息数据库访问类接口
 * @authorEmail 1076030424@qq.com
 */
public interface StuClassDao extends BaseDao<StuClass> {
	  public List<StuClass> getTeacherStuClass(Long teacherAccount);

	/**
	 * @Decription 获取教师管理班级分页信息
	 */
	public Pager<StuClass> getAllPageTeacherClasses(Long teacherAccount);

	/**
	 * @Decription 以一个班级编号获取一个班级 
	 */
	public StuClass getStuClassByAccount(Long stuClass);

	/**
	 * @Decription 获取班级根据名字
	 */
	public StuClass getClassByName(String classn);

	/**
	 * @param stuClass 
	 * @Decription 获取分页班级
	 */
	public Pager<StuClass> getAllPageClasses(StuClass stuClass);

}
