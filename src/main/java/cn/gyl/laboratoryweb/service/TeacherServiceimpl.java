package cn.gyl.laboratoryweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyl.laboratoryweb.dao.TeacherDao;
import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.Teacher;
import cn.gyl.laboratoryweb.utils.PasswordSecurity;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Service("teacherService")
public class TeacherServiceimpl extends BaseServiceimpl<Teacher> implements TeacherService {
	@Autowired
	private TeacherDao teacherDao;

	@Override
	public Teacher login(Long userAccountNum, String password) {
		Teacher teacher = teacherDao.getTeacherByAccount(userAccountNum);
		if (teacher == null)
			return null;
		String md5Password = PasswordSecurity.MD5(teacher.getTeacherName(), password);
		if (!teacher.getTeacherPassword().equals(md5Password))
			return null;
//		if(admin.getState!=1) throw new RuntimeException("用户被禁用!");
		return teacher;
	}

	@Override
	public List<Teacher> getAllTeacher() {

		return teacherDao.getAllTeacher();
	}

	@Override
	public Pager<Teacher> getAllPageTeachers(Teacher teacher) {

		return teacherDao.getAllPageTeachers(teacher);
	}

	@Override
	public Teacher getTeacherByAccount(Long teacherAccount) {
		return teacherDao.getTeacherByAccount(teacherAccount);
	}

}
