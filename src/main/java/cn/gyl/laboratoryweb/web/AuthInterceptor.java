package cn.gyl.laboratoryweb.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object user = request.getSession().getAttribute("user");
		if (user != null) {
			return true;
		} else {
			response.sendRedirect(request.getContextPath() + "/homePage");
		}

		return super.preHandle(request, response, handler);
	}
}
