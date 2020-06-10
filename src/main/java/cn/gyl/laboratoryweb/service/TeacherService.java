package cn.gyl.laboratoryweb.service;

import java.util.List;

import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.Teacher;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface TeacherService extends BaseService<Teacher> {


	public Teacher login(Long userAccountNum, String password);


	public List<Teacher> getAllTeacher();


	/**
	 * @Decription
	 */
	public Pager<Teacher> getAllPageTeachers(Teacher teacher);


	/**
	 * @Decription
	 */
	public Teacher getTeacherByAccount(Long teacherAccount);

}
