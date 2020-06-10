package cn.gyl.laboratoryweb.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyl.laboratoryweb.dao.AttendanceDao;
import cn.gyl.laboratoryweb.model.Attendance;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Service("attendanceService")
public class AttendanceServiceimpl extends BaseServiceimpl<Attendance> implements AttendanceService {
	
	@Autowired
	private AttendanceDao attendanceDao;
	@Override
	public List<Attendance> getAttendanceByLab(String searcherDateTime, Long laboratoryId) {

		return attendanceDao.getAttendanceByLab(searcherDateTime,laboratoryId);
	}
	@Override
	public List<Attendance> getAttendanceByTea(String searcherDateTime, Long teacherAccount) {
		return attendanceDao.getAttendanceByTea(searcherDateTime,teacherAccount);
	}
	@Override
	public Attendance getAttendanceByStu(String searcherDateTime, Long studentAccount) {
		return attendanceDao.getAttendanceByStu(searcherDateTime,studentAccount);
	}
	@Override
	public List<Attendance> getCkAttendance() {
		// TODO Auto-generated method stub
		return attendanceDao.getCkAttendance();
	}
	@Override
	public Attendance getOneAttendanceByStu(Date date, long time, Long studentAccount) {
		// TODO Auto-generated method stub
		return attendanceDao.getOneAttendanceByStu(date,time,studentAccount);
	}
	@Override
	public int getLabUseTime(Long laboratoryId) {
		// TODO Auto-generated method stub
		return attendanceDao.getLabUseTime(laboratoryId);
	}

}
