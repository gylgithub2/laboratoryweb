package cn.gyl.laboratoryweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.Teacher;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Repository("teacherDao")
public class TeacherDaoimpl extends BaseDaoimpl<Teacher> implements TeacherDao {

	@Override
	public Teacher getTeacherByAccount(Long teacherAccount) {
		String hql = "select t from Teacher t where t.teacherAccount = ?0";
		return (Teacher)super.queryByHql(hql, new Object[] {teacherAccount}, null);
	}

	@Override
	public List<Teacher> getAllTeacher() {
		String hql = "select t from Teacher t ";
		return super.getList(hql, null, null);
	}

	@Override
	public Pager<Teacher> getAllPageTeachers(Teacher teacher) {
		String hql = "select t from Teacher t ";
		if (teacher.getDepartment() != null) {
			hql += "left join t.department as d where d.departmentPKID = " + teacher.getDepartment().getDepartmentPKID();
		}else {
			hql += " where 1=1 ";
		}
		if (teacher.getTeacherAccount() != null && teacher.getTeacherAccount() > 0)
			hql += " AND t.teacherAccount= " + teacher.getTeacherAccount();
		if (teacher.getTeacherName()!= null && !"".equals(teacher.getTeacherName()))
			hql += "AND t.teacherName like '%" + teacher.getTeacherName() + "%'";
		
		return super.getPageList(hql, null, null);
	}

}
