package com.science.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.science.domain.Admin;
import com.science.exception.MessageException;
import com.science.serviceManager.AdminManager;
import com.science.util.SessionUtil;


public class AdminAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private AdminManager adminManager;
	
	private Admin admin;
	private String msg;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	@Action(value = "loginAction", 
			results = { 
			@Result(name = "success", type = "redirect", location = "homeAdmin", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String loginAction(){
		try {
			String username = admin.getUsername();
			String userpw =  admin.getUserpw();
			adminManager.checkAdmin(username, userpw);
			return SUCCESS;
		} catch (MessageException e) {
			msg = e.getMsg();
			return ERROR;
		}catch (Exception e) {
			msg = "服务器出错";
			return ERROR;
		}
	}
	
	@Action(value = "logoutAction", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/login.jsp", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String logoutAction(){
		try {
			SessionUtil.removeSession("userId");
			SessionUtil.removeSession("userName");
			return SUCCESS;
		} catch (Exception e) {
			msg = "管理员退出失败";
			return ERROR;
		}
	}

}
