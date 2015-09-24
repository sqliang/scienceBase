package com.science.serviceManagerImpl;


import com.science.domain.Submenu;
import com.science.serviceManager.SubmenuManager;
import com.science.dao.SubmenuDao;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component
public class SubmenuManagerImpl extends BaseManagerImpl<Submenu> implements SubmenuManager {

	private SubmenuDao submenuDao;

	@Autowired
	public  void setSubmenuDao(SubmenuDao submenuDao){
		this.submenuDao=submenuDao;
		super.baseDao = submenuDao;
		this.submenuDao=submenuDao;


	}
	public  void addSubmenu(Submenu submenu){
		save(submenu);
	}
	public  void addSubmenus(List<Submenu> submenus){
		save(submenus);
	}
	public  Submenu load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Submenu> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public Submenu querySubByName(String subMenuName) {
		Submenu submenu = findbyHqlUnique("from Submenu where subMenuName=?", subMenuName);
		return submenu;
	}
	
}
