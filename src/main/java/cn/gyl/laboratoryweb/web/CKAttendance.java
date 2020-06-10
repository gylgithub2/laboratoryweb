package cn.gyl.laboratoryweb.web;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import cn.gyl.laboratoryweb.service.AttendanceService;
import cn.gyl.laboratoryweb.service.OrderService;
import cn.gyl.laboratoryweb.service.StudentService;
import cn.gyl.laboratoryweb.service.WatchService;

/**
 * @Decription 用于每天检查学生的打卡情况,并更新违纪记录,学生状态信息等
 * @authorEmail 1076030424@qq.com
 */
public class CKAttendance {

	private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;

	public CKAttendance(OrderService orderService, AttendanceService attendanceService, StudentService studentService,
			WatchService watchService) {
		// 设置一个每日固定时间调用CheckTask
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 2);
		calendar.set(Calendar.MINUTE, 30);
		calendar.set(Calendar.SECOND, 0);
		// 第一次执行定时任务的时间,服务器启动或重启时
		Date date = calendar.getTime();
		// 比如:服务器重启后时间是6:00 那么今天就不会再执行check方法,如果省略该步,则会立即执行check方法
		 if (date.before(new Date())) {
		// 初始化启动时间加一天
		 date = this.addDay(date, 1);
		 }
		Timer timer = new Timer();
		CheckTask task = new CheckTask(orderService, attendanceService, studentService, watchService);
		// 开启每日的检查
		timer.schedule(task, date, PERIOD_DAY);
	}

	public Date addDay(Date date, int num) {
		Calendar addCalendar = Calendar.getInstance();
		addCalendar.setTime(date);
		addCalendar.add(Calendar.DAY_OF_MONTH, num);
		return addCalendar.getTime();
	}
}
