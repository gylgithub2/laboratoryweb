
package cn.gyl.laboratoryweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.Student;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Repository("studentDao")
public class StudentDaoimpl extends BaseDaoimpl<Student> implements StudentDao {
	

	@Override
	public Student getStudentByAccount(Long userAccountNum) {
		String hql = "select s from Student s where s.studentAccount = ?0";
		return super.queryByHql(hql, new Object[] {userAccountNum}, null);
	
	}

	@Override
	public List<Student> getStudentByClass(Long stuClass) {
		String hql = "select s from Student s where s.stuClass= ?0";
		return super.getList(hql, new Object[] {stuClass}, null);
	}

	@Override
	public int getStuNum(Long stuClassId) {
		String hql = "select count(*) from Student s where s.stuClass= ?0 ";
		return super.getCountByHql(hql, new Object[] {stuClassId});
	}

	@Override
	public List<Student> getAllStudent() {
		String hql = "select s from Student s";
		return super.getList(hql, null, null);
	}

	@Override
	public Pager<Student> getAllPageStudents(Student student,Long classId) {
		String hql = "from Student s where 1=1 ";
		if (student.getStudentAccount() != null && student.getStudentAccount() > 0)
			hql += " AND s.studentAccount= " + student.getStudentAccount();
		if (student.getStudentName() != null && !"".equals(student.getStudentName()))
			hql += "AND s.studentName like '%" + student.getStudentName() + "%'";
		if(classId!=null)
			hql += "AND s.stuClass = "+classId;
		return super.getPageList(hql, null, null);
	}

	@Override
	public Student getStudentByIcCard(long icCard) {
		String hql = "select s from Student s where s.icCard = ?0";
		return super.queryByHql(hql, new Object[] {icCard}, null);
	
	}


}
