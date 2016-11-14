package com.psy.common.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;import com.psy.common.constants.Session;

public class SignInIntercepter extends HandlerInterceptorAdapter {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute(Session.USER) == null ){
			response.sendRedirect("/PriceCompare/signIn");
			return false;
		}
		
		return true;
	}
	
}
