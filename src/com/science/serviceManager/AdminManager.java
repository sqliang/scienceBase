package com.science.serviceManager;


import com.science.domain.Admin;
import java.util.List;

public interface AdminManager extends BaseManager<Admin> {


	public void addAdmin(Admin admin);

	public void addAdmins(List<Admin> admins);

	public Admin load(String sqlkey);

	public List<Admin> find(String sqlkey);
	
	public void checkAdmin(String username,String userpw);

}
