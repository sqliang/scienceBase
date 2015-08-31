package com.science.util.bean;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class BeanUtil {

	public static Object load(String name){
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
		return ctx.getBean(name);
	}
	
}
