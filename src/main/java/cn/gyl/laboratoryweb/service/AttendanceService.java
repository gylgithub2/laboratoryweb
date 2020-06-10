package cn.gyl.laboratoryweb.service;

import java.util.Date;
import java.util.List;

import cn.gyl.laboratoryweb.model.Attendance;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface AttendanceService extends BaseService<Attendance> {


	/**
	 * @Decription
	 */
	List<Attendance> getAttendanceByLab(String searcherDateTime, Long laboratoryId);

	/**
	 * @Decription
	 */
	List<Attendance> getAttendanceByTea(String searcherDateTime, Long teacherAccount);

	/**
	 * @Decription
	 */
	Attendance getAttendanceByStu(String searcherDateTime, Long studentAccount);

	/**
	 * @Decription
	 */
	List<Attendance> getCkAttendance();

	/**
	 * @Decription
	 */
	Attendance getOneAttendanceByStu(Date date, long time, Long studentAccount);

	/**
	 * @Decription
	 */
	int getLabUseTime(Long laboratoryId);

}
