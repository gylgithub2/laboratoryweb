package cn.gyl.test;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gyl.laboratoryweb.model.Admin;
import cn.gyl.laboratoryweb.service.AdminService;
import cn.gyl.laboratoryweb.service.AdminServiceimpl;

@SuppressWarnings("resource")
public class TestDatabaseConnection {
	/**
	 *
	 * @Decription 测试hibernate 连接情况
	 */
	@Test
	public void testJDBCconnect() {
		ApplicationContext context = new  ClassPathXmlApplicationContext("spring.xml");
		SessionFactory sessionFactory=(SessionFactory)context.getBean("sessionFactory");
		System.out.println(sessionFactory);
		System.out.println(sessionFactory.openSession());
	}
	public static void main(String[] args) {
	
		Date date = new Date();
		System.out.println(date.getTime());
	}
	
	@Test
	public void test1() {

	}
	
}
