package cn.gyl.laboratoryweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyl.laboratoryweb.dao.StudentDao;
import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.Student;
import cn.gyl.laboratoryweb.utils.PasswordSecurity;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Service("studentService")
public class StudentServiceimpl extends BaseServiceimpl<Student> implements StudentService {
	@Autowired
	private StudentDao studentDao;
	@Override
	public Student login(Long userAccountNum, String password) {
		Student student = studentDao.getStudentByAccount(userAccountNum);
		if (student == null)
			return null;
		String md5Password = PasswordSecurity.MD5(student.getStudentName(), password);
		if (!student.getStudentPassword().equals(md5Password))
			return null;
//		if(admin.getState!=1) throw new RuntimeException("用户被禁用!");
		return student;
	}
	@Override
	public Student getStudentByAccount(long parseLong) {

		return studentDao.getStudentByAccount(parseLong);
	}
	@Override
	public List<Student> getStudentByClass(Long stuClass) {
		
		return studentDao.getStudentByClass(stuClass);
	}
	
	@Override
	public int getStuNum(Long stuClassId) {
		return studentDao.getStuNum(stuClassId);
	}
	@Override
	public List<Student> getAllStudent() {
		return studentDao.getAllStudent();
	}
	@Override
	public Pager<Student> getAllPageStudents(Student student,Long classId) {
		return studentDao.getAllPageStudents(student,classId);
	}
	@Override
	public Student getStudentByIcCard(long icCard) {
		// TODO Auto-generated method stub
		return studentDao.getStudentByIcCard(icCard);
	}

}
