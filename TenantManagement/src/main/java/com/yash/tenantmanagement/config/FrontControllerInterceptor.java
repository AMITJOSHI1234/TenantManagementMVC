package com.yash.tenantmanagement.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
* This is a FrontController containing authentication logic
* @author amit joshi
*/

@Component
public class FrontControllerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
	     String username = (String) session.getAttribute("userName");
	     
	     if(username==null) {
	    	 response.sendRedirect("login");
	    	 return false;
	     }
		return true;
	}

	
}
