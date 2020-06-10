package cn.gyl.laboratoryweb.dao;

import java.util.List;

import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.Student;

/**
 * @Decription 学生信息数据库访问类接口
 * @authorEmail 1076030424@qq.com
 */
public interface StudentDao extends BaseDao<Student> {

	/**
	 * @Decription 通过学生账号获取学生
	 */
	Student getStudentByAccount(Long studentAccount);

	/**
	 * @Decription 通过班级获取学生
	 */
	List<Student> getStudentByClass(Long stuClass);

	/**
	 * @Decription 获得该班级的学生人数
	 */
	public int getStuNum(Long stuClassId);

	/**
	 * @Decription 获取所有学生
	 */
	List<Student> getAllStudent();

	/**
	 * @Decription 获取分页学生信息
	 */
	Pager<Student> getAllPageStudents(Student student,Long classId);

	/**
	 * @Decription 通过IC卡号获取学生
	 */
	Student getStudentByIcCard(long icCard);
	

}
