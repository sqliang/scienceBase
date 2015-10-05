package com.science.serviceManager;


import com.science.domain.Introduceinfo;
import java.util.List;

public interface IntroduceinfoManager extends BaseManager<Introduceinfo> {


	public void addIntroduceinfo(Introduceinfo introduceinfo);

	public void addIntroduceinfos(List<Introduceinfo> introduceinfos);

	public Introduceinfo load(String sqlkey);

	public List<Introduceinfo> find(String sqlkey);

	public Introduceinfo queryLabIntrInfo(long artType);
	
	public Introduceinfo queryIntrInfoById(long artid);
}
