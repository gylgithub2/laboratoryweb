package cn.gyl.laboratoryweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gyl.laboratoryweb.model.Pager;
import cn.gyl.laboratoryweb.model.StuClass;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */

@Repository(value="stuClassDao")
public class StuClassDaoimpl extends BaseDaoimpl<StuClass> implements StuClassDao {
	 @Override
	  public List<StuClass> getTeacherStuClass(Long teacherAccount){
		  String hql = "select s from StuClass s left join s.teachers as t where t.teacherAccount = ?0";
		    return super.getList(hql, new Object[] {teacherAccount}, null);
	    }

	@Override
	public Pager<StuClass> getAllPageTeacherClasses(Long teacherAccount) {
		  String hql = "select s from StuClass s left join s.teachers as t where t.teacherAccount = ?0";
		    return super.getPageList(hql, new Object[] {teacherAccount}, null);
	}

	@Override
	public StuClass getStuClassByAccount(Long stuClass) {
		  String hql = "select s from StuClass s where stuClassId = ?0";
		return super.queryByHql(hql, new Object[] {stuClass}, null);
	}

	@Override
	public StuClass getClassByName(String classn) {
		  String hql = "select s from StuClass s where stuClassName = ?0";
			return super.queryByHql(hql, new Object[] {classn}, null);
	}

	@Override
	public Pager<StuClass> getAllPageClasses(StuClass stuClass) {
		String hql = "select s from StuClass s where 1=1 ";
		if (stuClass.getDepartment() != null) 
			hql += " AND s.department = " + stuClass.getDepartment();
		if (stuClass.getStuClassName()!= null && !"".equals(stuClass.getStuClassName()))
			hql += " AND s.stuClassName like '%" + stuClass.getStuClassName()+ "%'";
		if (stuClass.getStuClassId()!= null)
			hql += " AND s.stuClassId = " + stuClass.getStuClassId();
		return super.getPageList(hql, null, null);
	}
	  
}
