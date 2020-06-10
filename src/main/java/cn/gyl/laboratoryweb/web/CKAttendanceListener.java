package cn.gyl.laboratoryweb.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gyl.laboratoryweb.service.AttendanceService;
import cn.gyl.laboratoryweb.service.OrderService;
import cn.gyl.laboratoryweb.service.StudentService;
import cn.gyl.laboratoryweb.service.WatchService;

/**
 * @Decription servlet监听器,服务器启动时启动
 * @authorEmail 1076030424@qq.com
 */
public class CKAttendanceListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		@SuppressWarnings("resource")
		ConfigurableApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"spring.xml");
		AttendanceService attendanceService = (AttendanceService) classPathXmlApplicationContext
				.getBean("attendanceService");
		StudentService studentService = (StudentService) classPathXmlApplicationContext.getBean("studentService");
		OrderService orderService = (OrderService) classPathXmlApplicationContext.getBean("orderService");
		WatchService watchService = (WatchService) classPathXmlApplicationContext.getBean("watchService");
		new CKAttendance(orderService,attendanceService, studentService, watchService);
		new GetCardData(attendanceService,studentService).launchFrame();
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}
}
