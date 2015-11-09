package com.science.serviceManagerImpl;

import com.science.domain.Admin;
import com.science.serviceManager.AdminManager;
import com.science.util.SessionUtil;
import com.science.dao.AdminDao;
import com.science.exception.MessageException;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component
public class AdminManagerImpl extends BaseManagerImpl<Admin> implements
		AdminManager {

	private AdminDao adminDao;

	@Autowired
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		super.baseDao = adminDao;
		this.adminDao = adminDao;

	}

	public void addAdmin(Admin admin) {
		save(admin);
	}

	public void addAdmins(List<Admin> admins) {
		save(admins);
	}

	public Admin load(String sqlkey) {
		return findbyHqlUnique(sqlkey);
	}

	public List<Admin> find(String sqlkey) {
		return findbyHql(sqlkey);
	}

	@Override
	public void checkAdmin(String username, String userpw) {
		Admin admin = adminDao.findbyHqlUnique("from Admin where userName=? and userPw=?",username,userpw);
		if(admin == null){
			throw new MessageException("用户名或密码错误");
		}else{
			SessionUtil.setSession("userId", admin.getUserid());
			SessionUtil.setSession("userName", admin.getUsername());
		}
	}
}
