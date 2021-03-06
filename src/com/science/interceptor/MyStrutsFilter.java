package com.science.interceptor;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class MyStrutsFilter extends StrutsPrepareAndExecuteFilter {
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		//不过滤的url
		String url = request.getRequestURI();
		if (url.contains("/scienceBase/ueditor/jsp/controller.jsp")) {
			try{
				chain.doFilter(req, res);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			try{
				super.doFilter(req, res, chain);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}