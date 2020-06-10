
package cn.gyl.laboratoryweb.utils;

/**
 * @Decription 工具类,提供一些通用方法
 *
 */
public class CheckUtils {

	/**
	 * 
	 * @Decription 判断密码是不是8-16位、包括数字和密码、不包含特殊字符)，不是则返回false
	 */
	public static boolean checkPasswordStandard(String numString) {
		return numString.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$");
	}
	/**
	 * @Decription 判断字符串是否可为长整型
	 */
	public static boolean isLong(String string) {
		try {
			Long.parseLong(string);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}