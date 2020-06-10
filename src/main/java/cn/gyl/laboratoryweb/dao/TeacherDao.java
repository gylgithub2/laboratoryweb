package cn.gyl.laboratoryweb.dao;

import java.util.List;

import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.Teacher;

/**
 * @Decription 教师信息数据库访问类接口
 * @authorEmail 1076030424@qq.com
 */
public interface TeacherDao extends BaseDao<Teacher> {

	/**
	 * @Decription 根据账号获取教师
	 */
	Teacher getTeacherByAccount(Long teacherAccount);

	/**
	 * @Decription 获取所有老师
	 */
	List<Teacher> getAllTeacher();

	/**
	 * @Decription 获取所有老师的分页信息
	 */
	Pager<Teacher> getAllPageTeachers(Teacher teacher);

}
