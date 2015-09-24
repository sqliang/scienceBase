package com.science.serviceManager;


import com.science.domain.Submenu;
import java.util.List;

public interface SubmenuManager extends BaseManager<Submenu> {


	public void addSubmenu(Submenu submenu);

	public void addSubmenus(List<Submenu> submenus);

	public Submenu load(String sqlkey);

	public List<Submenu> find(String sqlkey);
	
	public Submenu querySubByName(String subMenuName);

}
