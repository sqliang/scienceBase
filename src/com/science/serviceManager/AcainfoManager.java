package com.science.serviceManager;


import com.science.domain.Acainfo;
import java.util.List;

public interface AcainfoManager extends BaseManager<Acainfo> {


	public void addAcainfo(Acainfo acainfo);

	public void addAcainfos(List<Acainfo> acainfos);

	public Acainfo load(String sqlkey);

	public List<Acainfo> find(String sqlkey);

	public  List<Acainfo> queryAcainfosByTwoType(long acaType,long position);
}
