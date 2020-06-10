package cn.gyl.laboratoryweb.service;

import java.util.List;

import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.Student;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface StudentService extends BaseService<Student> {

	public Student login(Long userAccountNum, String password);

	public Student getStudentByAccount(long parseLong);

	public List<Student> getStudentByClass(Long stuClass);

	public int getStuNum(Long stuClassId);

	/**
	 * @Decription
	 */
	public List<Student> getAllStudent();
	public Pager<Student> getAllPageStudents(Student student, Long classId);

	/**
	 * @Decription
	 */
	public Student getStudentByIcCard(long parseLong);

}
