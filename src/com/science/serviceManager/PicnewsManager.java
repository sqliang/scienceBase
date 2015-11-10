package com.science.serviceManager;


import com.science.domain.Picnews;
import java.util.List;

public interface PicnewsManager extends BaseManager<Picnews> {


public void addPicnews(Picnews picnews);

public void addPicnewss(List<Picnews> picnewss);

public Picnews load(String sqlkey);

public List<Picnews> find(String sqlkey);

public List<Picnews> queryPicNews();

public void delPicNewsByNewsId(long newsId);

}
