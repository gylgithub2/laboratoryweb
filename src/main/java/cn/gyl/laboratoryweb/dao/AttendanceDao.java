package cn.gyl.laboratoryweb.dao;

import java.util.Date;
import java.util.List;

import cn.gyl.laboratoryweb.model.Attendance;

/**
 * @Decription 出席信息记录数据库访问类接口
 * @authorEmail 1076030424@qq.com
 */
public interface AttendanceDao extends BaseDao<Attendance> {


	/**
	 * @Decription 根据实验室获取出席信息
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
	 * @param date 
	 * @Decription 查询实验时间已过,但是还未被进行违纪判断的记录;
	 */
	List<Attendance> getCkAttendance();

	/**
	 * @Decription 学生打卡时获取当前时间段的打卡记录
	 */
	Attendance getOneAttendanceByStu(Date date, long time, Long studentAccount);

	/**
	 * @Decription
	 */
	int getLabUseTime(Long laboratoryId);

}
