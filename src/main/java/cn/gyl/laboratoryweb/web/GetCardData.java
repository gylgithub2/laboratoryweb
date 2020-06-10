package cn.gyl.laboratoryweb.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.gyl.laboratoryweb.model.Attendance;
import cn.gyl.laboratoryweb.model.Student;
import cn.gyl.laboratoryweb.service.AttendanceService;
import cn.gyl.laboratoryweb.service.StudentService;

/**
 * @Decription 用于读取打卡记录
 * @authorEmail 1076030424@qq.com
 */
public class GetCardData extends Frame {
	/**
	 * 
	 */
	/**
	 * 程序界面宽度
	 */
	public static final int WIDTH = 800;
	
	/**
	 * 程序界面高度
	 */
	public static final int HEIGHT = 620;
	
	/**
	 * 程序界面出现位置（横坐标）
	 */
	public static final int LOC_X = 200;
	
	/**
	 * 程序界面出现位置（纵坐标）
	 */
	public static final int LOC_Y = 70;
	private static final long serialVersionUID = 1232154545L;
	private AttendanceService attendanceService;
	private StudentService studentService;
	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	private String cardNum = "";
	Color color = Color.WHITE; 
	static {
		map.put(48, 0);
		map.put(49, 1);
		map.put(50, 2);
		map.put(51, 3);
		map.put(52, 4);
		map.put(53, 5);
		map.put(54, 6);
		map.put(55, 7);
		map.put(56, 8);
		map.put(57, 9);
	}

	public GetCardData(AttendanceService attendanceService, StudentService studentService) {
		super();
		this.attendanceService = attendanceService;
		this.studentService = studentService;
	}
	@Override
	public void paint(Graphics g) {
		g.setFont(new Font("微软雅黑", Font.BOLD, 40));
		g.setColor(Color.black);
		g.drawString("打卡窗口", 45, 190);
		
		g.setFont(new Font("微软雅黑", Font.ITALIC, 26));
		g.setColor(Color.BLACK);
		g.drawString("监听打卡中...", 280, 260);
		
		g.setFont(new Font("微软雅黑", Font.BOLD, 30));
		g.setColor(color);
		
	}
	
	public void launchFrame() {
		this.setTitle("考勤模块");
		this.setBounds(LOC_X, LOC_Y, WIDTH, HEIGHT);	//设定程序在桌面出现的位置
		this.setBackground(Color.white); // 设置背景色
		this.addWindowListener(new WindowAdapter() {
			// 添加对窗口状态的监听
			public void windowClosing(WindowEvent arg0) {
				// 当窗口关闭时
				System.exit(0); // 退出程序
			}

		});

		this.addKeyListener(new KeyMonitor()); // 添加键盘监听器
		this.setResizable(false); // 窗口大小不可更改
		this.setVisible(true); // 显示窗口

	}

	private class KeyMonitor extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode != 10) {
				cardNum += map.get(keyCode);
				if (cardNum.length() == 10) {
					Student student = studentService.getStudentByIcCard(Long.parseLong(cardNum));
					System.out.println("读取到卡号:"+cardNum);
					if (student != null) {
						Date date = new Date();
						Attendance attendance = attendanceService.getOneAttendanceByStu(
								new Date(date.getTime() + 30 * 60 * 1000), date.getTime(), student.getStudentAccount());
						if (attendance != null) {
							attendance.setPunchDate(date);
							if (date.after(attendance.getStartDate())) {
								attendance.setStatus(1);
							} else {
								attendance.setStatus(2);
							}
							attendanceService.update(attendance);
						}else {
						}
					}
					cardNum = "";
				}
			}
		}
	}
}
