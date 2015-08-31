package com.science.serviceManagerImpl;


import com.science.domain.Admin;
import com.science.serviceManager.AdminManager;
import com.science.dao.AdminDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class AdminManagerImpl extends BaseManagerImpl<Admin> implements AdminManager {

private AdminDao adminDao;

@Autowired
public  void setAdminDao(AdminDao adminDao){
this.adminDao=adminDao;
super.baseDao = adminDao;
this.adminDao=adminDao;


}
public  void addAdmin(Admin admin){
save(admin);
}
public  void addAdmins(List<Admin> admins){
save(admins);
}
public  Admin load(String sqlkey){
return findbyHqlUnique(sqlkey);
}
public  List<Admin> find(String sqlkey){
return findbyHql(sqlkey);
}
}
