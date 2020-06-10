package cn.gyl.laboratoryweb.web;

import java.util.List;
import java.util.TimerTask;

import cn.gyl.laboratoryweb.model.Attendance;
import cn.gyl.laboratoryweb.model.Order;
import cn.gyl.laboratoryweb.model.Student;
import cn.gyl.laboratoryweb.model.Watch;
import cn.gyl.laboratoryweb.service.AttendanceService;
import cn.gyl.laboratoryweb.service.OrderService;
import cn.gyl.laboratoryweb.service.StudentService;
import cn.gyl.laboratoryweb.service.WatchService;

/**
 * @Decription 主要执行监察打卡情况的任务
 * @authorEmail 1076030424@qq.com
 */
public class CheckTask extends TimerTask {
	private AttendanceService attendanceService;

	private StudentService studentService;

	private WatchService watchService;

	private OrderService orderService;

	public CheckTask(OrderService orderService, AttendanceService attendanceService, StudentService studentService,
			WatchService watchService) {
		this.attendanceService = attendanceService;
		this.studentService = studentService;
		this.watchService = watchService;
		this.orderService = orderService;
	}

	@Override
	public void run() {
		// 1.打卡部分违纪记录获取
		System.out.println("违纪监察:");
		List<Attendance> violateList1 = attendanceService.getCkAttendance();
		if (violateList1 != null) {
			for (Attendance attendance : violateList1) {
				Long studentAccount = attendance.getStudentAccount();
				Student violateStudent = studentService.getStudentByAccount(studentAccount);
				Integer absenceTime = violateStudent.getAbsenceTime();
				Integer violateScore = violateStudent.getViolateScore();
				Integer lateTime = violateStudent.getLateTime();
				if (attendance.getStatus() == 0) {
					absenceTime += 1;
					violateScore += 3;
				} else if (attendance.getStatus() == 1) {
					lateTime += 1;
					violateScore += 1;
				}
				if (violateScore > 6) {
					violateStudent.setStatus(2);
					violateStudent.setViolateScore(0);
				} else {
					violateStudent.setViolateScore(violateScore);
				}
				violateStudent.setLateTime(lateTime);
				violateStudent.setAbsenceTime(absenceTime);
				attendance.setIsCheck(true);
				attendanceService.update(attendance);
				studentService.update(violateStudent);
			}
		}
		// 2.实验预习部分违纪记录获取
		List<Watch> violateList2 = watchService.getUndoWatch();
		if (violateList2 != null) {

			for (Watch watch : violateList2) {
				Student student = studentService.getStudentByAccount(watch.getStudentAccount());
				Integer violateScore = student.getViolateScore();
				student.setViolateScore(violateScore + 1);
				if (violateScore > 6) {
					student.setStatus(2);
					student.setViolateScore(0);
				} else {
					student.setViolateScore(violateScore);
				}
				watch.setIsCheck(1);
				watchService.update(watch);
				studentService.update(student);
			}
		}
		//3.未及时本审核的预约,默认拒绝处理
		List<Order> orders = orderService.getUnuseORder();
		if (orders != null) {
			for (Order order : orders) {
				order.setStatus(2);
				orderService.update(order);
			}
		}
	}
}
