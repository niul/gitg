package com.niulbird.gitg.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.servlet.ModelAndView;


import com.niulbird.gitg.util.ControllerUtility;


public class LogInterceptor implements org.springframework.web.servlet.HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		boolean proceedFlag = true;
		
		// Add local thread info to logging context
		ThreadContext.put("SESSIONID", request.getSession().getId());
		ThreadContext.put("IPADDRESS", ControllerUtility.remoteAddr(request));
		
		return proceedFlag;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {

	}
}

