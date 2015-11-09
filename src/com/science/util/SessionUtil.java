package com.science.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class SessionUtil {

	/**
	 * 得到session对象
	 * @return
	 * @throws SessionNotExitException 
	 */
	public static Map<String, Object> getSession(){
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		if(session==null){
			throw new SessionNotExitException();
		}
		return session;
	}
	public static void setSession(String key,Object value){
		getSession().put(key, value);
	}
	
	public static void removeSession(String key){
		getSession().remove(key);
	}
	
	public static class SessionNotExitException extends RuntimeException{
		
	}
}
