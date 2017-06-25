package com.dq.arq.sme.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserCheckInterceptor implements HandlerInterceptor{

	private static final Logger logger = LoggerFactory
			.getLogger(UserCheckInterceptor.class);
	
	
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
	    throws Exception {
		
		logger.debug("\n\n\n************* Entering preHandle method of UserCheckInterceptor *************\n\n\n");
		logger.debug("Requested Path: "+request.getRequestURI().substring(request.getContextPath().toString().length()));
		
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}