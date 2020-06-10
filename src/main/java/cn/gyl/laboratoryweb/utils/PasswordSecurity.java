package cn.gyl.laboratoryweb.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Decription 用于加密密码,采用MD5的加密算法
 * @authorEmail 1076030424@qq.com
 */
public class PasswordSecurity {
/*
 * 学生账号:10001 密码123456
 * 管理员:10000 密码 123456
 * 教师:20001 密码 1234567
 */
	public static void main(String[] args) {
		System.out.println(MD5("teacher1","123456"));
	}
	public static String MD5(String name,String password) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(password.getBytes());
			md5.update(name.getBytes());
			byte[] rs = md5.digest();
			return new BigInteger(1, rs).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
