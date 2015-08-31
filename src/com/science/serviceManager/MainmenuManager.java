package com.science.serviceManager;


import com.science.domain.Mainmenu;
import java.util.List;

public interface MainmenuManager extends BaseManager<Mainmenu> {


public void addMainmenu(Mainmenu mainmenu);

public void addMainmenus(List<Mainmenu> mainmenus);

public Mainmenu load(String sqlkey);

public List<Mainmenu> find(String sqlkey);

public List<Mainmenu> queryMainmenuContainSub();
}
