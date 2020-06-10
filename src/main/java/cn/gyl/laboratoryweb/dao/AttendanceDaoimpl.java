package cn.gyl.laboratoryweb.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gyl.laboratoryweb.model.Attendance;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Repository("attendanceDao")
public class AttendanceDaoimpl extends BaseDaoimpl<Attendance> implements AttendanceDao {


	@Override
	public List<Attendance> getAttendanceByLab(String searcherDateTime, Long laboratoryId) {
		String hql ="select a from Attendance a where a.startDate = ?0 And a.laboratoryId = ?1 ";
		try {
			return super.getList(hql, new Object[] {new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(searcherDateTime),laboratoryId}, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Attendance> getAttendanceByTea(String searcherDateTime, Long teacherAccount) {
		String hql ="select a from Attendance a where a.startDate = ?0 And a.teacherAccount = ?1 ";
		try {
			return super.getList(hql, new Object[] {new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(searcherDateTime),teacherAccount}, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Attendance getAttendanceByStu(String searcherDateTime, Long studentAccount) {
		String hql ="select a from Attendance a where a.startDate = ?0 And a.studentAccount = ?1 ";
		try {
			return super.queryByHql(hql, new Object[] {new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(searcherDateTime),studentAccount}, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Attendance> getCkAttendance() {
		String hql = "select a from Attendance a where a.isCheck = 0 And a.endDate <= now() And a.status !=2 ";
		return super.getList(hql, null, null);
	}

	@Override
	public Attendance getOneAttendanceByStu(Date date, long time, Long studentAccount) {
		String hql ="select a from Attendance a where a.startDate < ?0 And a.endDate > ?1 And a.studentAccount = ?2 And a.punchDate = null";
		try {
			return super.queryByHql(hql, new Object[] {date,new Date(time),studentAccount}, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getLabUseTime(Long laboratoryId) {
		String hql = "select count(*) from Attendance a where a.laboratoryId = ?0  And status = 1 ";
		return super.getCountByHql(hql, new Object[] { laboratoryId });
	}

}
