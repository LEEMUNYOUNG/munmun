package com.example.sproute.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String query = request.getQueryString();
		String url = request.getServletPath();
		if (WebUtils.getSessionAttribute(request, "userId") == null) {
			if (query != null)
				WebUtils.setSessionAttribute(request, "query", query);

			WebUtils.setSessionAttribute(request, "path", url);
			response.sendRedirect(request.getContextPath() + "/shop/loginForm" );
			return false;
		}
	
		return true;
			
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
