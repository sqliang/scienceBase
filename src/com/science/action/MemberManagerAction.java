package com.science.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.science.domain.Memberinfo;
import com.science.serviceManager.MemberinfoManager;
import com.science.serviceManager.SubmenuManager;
import com.science.util.string.StringUtil;

public class MemberManagerAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private MemberinfoManager memberinfoManager;
	@Autowired
	private SubmenuManager submenuManager;
	
	private String yuanshiType;
	private String perPlain;
	private String memType;
	private long foreignType;
	private String memDegree;
	private List<Memberinfo> memberinfos;//返回人员
	private List<Memberinfo> boDaoMems;
	private List<Memberinfo> professions;//去掉博导的教授
	private List<Memberinfo> fuProfessions;
	private List<Memberinfo> jiangShis;
	private List<Memberinfo> othersMem;
	private String bodao ;
	private String profess;
	private String fuProfess;
	private String jiangshi;
	private String others;
	private String qianRenPlain;
	private List<Memberinfo> qianRenPlains;
	private String changJiangPerson;
	private List<Memberinfo> changJiangPersons;
	private String jieChuPerson;
	private List<Memberinfo> jieChuPersons;
	private String subMenuName;
	private long mainMenuId;
	private String foreignMingshi;
	private List<Memberinfo> foreignMingshis;
	private String baiQianWan;
	private List<Memberinfo> baiMemberinfos;
	private String youxiuJiJin;
	private List<Memberinfo> youxiuJiJins;
	private String newShiJi;
	private List<Memberinfo> newShiJis;
	private String baiPerson;
	private List<Memberinfo> baiPersons;
	private String huangShan;
	private List<Memberinfo> huangShans;
	
	public List<Memberinfo> getMemberinfos() {
		return memberinfos;
	}
	public void setMemberinfos(List<Memberinfo> memberinfos) {
		this.memberinfos = memberinfos;
	}
	
	public String getMemType() {
		return memType;
	}
	public void setMemType(String memType) {
		this.memType = memType;
	}
	
	public long getForeignType() {
		return foreignType;
	}
	public void setForeignType(long foreignType) {
		this.foreignType = foreignType;
	}
	public String getMemDegree() {
		return memDegree;
	}
	public void setMemDegree(String memDegree) {
		this.memDegree = memDegree;
	}
	public String getYuanshiType() {
		return yuanshiType;
	}
	public void setYuanshiType(String yuanshiType) {
		this.yuanshiType = yuanshiType;
	}
	public String getPerPlain() {
		return perPlain;
	}
	public void setPerPlain(String perPlain) {
		this.perPlain = perPlain;
	}
	public String getSubMenuName() {
		return subMenuName;
	}
	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}
	public long getMainMenuId() {
		return mainMenuId;
	}
	public void setMainMenuId(long mainMenuId) {
		this.mainMenuId = mainMenuId;
	}
	public List<Memberinfo> getBoDaoMems() {
		return boDaoMems;
	}
	public void setBoDaoMems(List<Memberinfo> boDaoMems) {
		this.boDaoMems = boDaoMems;
	}
	public List<Memberinfo> getProfessions() {
		return professions;
	}
	public void setProfessions(List<Memberinfo> professions) {
		this.professions = professions;
	}
	public List<Memberinfo> getFuProfessions() {
		return fuProfessions;
	}
	public void setFuProfessions(List<Memberinfo> fuProfessions) {
		this.fuProfessions = fuProfessions;
	}
	public List<Memberinfo> getJiangShis() {
		return jiangShis;
	}
	public void setJiangShis(List<Memberinfo> jiangShis) {
		this.jiangShis = jiangShis;
	}
	public String getBodao() {
		return bodao;
	}
	public void setBodao(String bodao) {
		this.bodao = bodao;
	}
	public String getProfess() {
		return profess;
	}
	public void setProfess(String profess) {
		this.profess = profess;
	}
	public String getFuProfess() {
		return fuProfess;
	}
	public void setFuProfess(String fuProfess) {
		this.fuProfess = fuProfess;
	}
	public String getJiangshi() {
		return jiangshi;
	}
	public void setJiangshi(String jiangshi) {
		this.jiangshi = jiangshi;
	}
	public String getQianRenPlain() {
		return qianRenPlain;
	}
	public void setQianRenPlain(String qianRenPlain) {
		this.qianRenPlain = qianRenPlain;
	}
	public List<Memberinfo> getQianRenPlains() {
		return qianRenPlains;
	}
	public void setQianRenPlains(List<Memberinfo> qianRenPlains) {
		this.qianRenPlains = qianRenPlains;
	}
	public String getChangJiangPerson() {
		return changJiangPerson;
	}
	public void setChangJiangPerson(String changJiangPerson) {
		this.changJiangPerson = changJiangPerson;
	}
	public List<Memberinfo> getChangJiangPersons() {
		return changJiangPersons;
	}
	public void setChangJiangPersons(List<Memberinfo> changJiangPersons) {
		this.changJiangPersons = changJiangPersons;
	}
	public String getJieChuPerson() {
		return jieChuPerson;
	}
	public void setJieChuPerson(String jieChuPerson) {
		this.jieChuPerson = jieChuPerson;
	}
	public List<Memberinfo> getJieChuPersons() {
		return jieChuPersons;
	}
	public void setJieChuPersons(List<Memberinfo> jieChuPersons) {
		this.jieChuPersons = jieChuPersons;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public List<Memberinfo> getOthersMem() {
		return othersMem;
	}
	public void setOthersMem(List<Memberinfo> othersMem) {
		this.othersMem = othersMem;
	}
	public String getForeignMingshi() {
		return foreignMingshi;
	}
	public void setForeignMingshi(String foreignMingshi) {
		this.foreignMingshi = foreignMingshi;
	}
	public List<Memberinfo> getForeignMingshis() {
		return foreignMingshis;
	}
	public void setForeignMingshis(List<Memberinfo> foreignMingshis) {
		this.foreignMingshis = foreignMingshis;
	}
	public MemberinfoManager getMemberinfoManager() {
		return memberinfoManager;
	}
	public void setMemberinfoManager(MemberinfoManager memberinfoManager) {
		this.memberinfoManager = memberinfoManager;
	}
	public String getBaiQianWan() {
		return baiQianWan;
	}
	public void setBaiQianWan(String baiQianWan) {
		this.baiQianWan = baiQianWan;
	}
	public List<Memberinfo> getBaiMemberinfos() {
		return baiMemberinfos;
	}
	public void setBaiMemberinfos(List<Memberinfo> baiMemberinfos) {
		this.baiMemberinfos = baiMemberinfos;
	}
	public String getYouxiuJiJin() {
		return youxiuJiJin;
	}
	public void setYouxiuJiJin(String youxiuJiJin) {
		this.youxiuJiJin = youxiuJiJin;
	}
	public List<Memberinfo> getYouxiuJiJins() {
		return youxiuJiJins;
	}
	public void setYouxiuJiJins(List<Memberinfo> youxiuJiJins) {
		this.youxiuJiJins = youxiuJiJins;
	}
	public String getNewShiJi() {
		return newShiJi;
	}
	public void setNewShiJi(String newShiJi) {
		this.newShiJi = newShiJi;
	}
	public List<Memberinfo> getNewShiJis() {
		return newShiJis;
	}
	public void setNewShiJis(List<Memberinfo> newShiJis) {
		this.newShiJis = newShiJis;
	}
	public String getBaiPerson() {
		return baiPerson;
	}
	public void setBaiPerson(String baiPerson) {
		this.baiPerson = baiPerson;
	}
	public List<Memberinfo> getBaiPersons() {
		return baiPersons;
	}
	public void setBaiPersons(List<Memberinfo> baiPersons) {
		this.baiPersons = baiPersons;
	}
	public String getHuangShan() {
		return huangShan;
	}
	public void setHuangShan(String huangShan) {
		this.huangShan = huangShan;
	}
	public List<Memberinfo> getHuangShans() {
		return huangShans;
	}
	public void setHuangShans(List<Memberinfo> huangShans) {
		this.huangShans = huangShans;
	}
	@Action(value = "/queryMemByysType", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_mem.jsp", 
					params = {"memberinfos","${memberinfos}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryMemByysType(){
		try {
			memberinfos = memberinfoManager.queryMemInfosByMemysType(Long.parseLong(yuanshiType));
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@Action(value = "/queryMemGuGan", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_gugan.jsp", 
					params = {"boDaoMems","${boDaoMems}","bodao","${bodao}",
							  "profess","${profess}","professions","${professions}",
							  "fuProfess","${fuProfess}","fuProfessions","${fuProfessions}",
							  "jiangshi","${jiangshi}","jiangShis","${jiangShis}",
							  "subMenuName","${subMenuName}","mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryMemGuGan(){
		try {
			bodao = "博导";
			profess = "教授";
			fuProfess = "副教授";
			jiangshi = "讲师";
			boDaoMems = memberinfoManager.queryMemInfosByTeacherType(bodao);//博导
			professions = memberinfoManager.queryMemInfosByMemJobTitle(profess, bodao);//去掉博导的教授
			fuProfessions =memberinfoManager.queryMemInfosByMemJobTitle(fuProfess);///副教授
			jiangShis = memberinfoManager.queryMemInfosByMemJobTitle(jiangshi);///讲师
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@Action(value = "/queryMemInfosByForeignType", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_mem.jsp", 
					params = {"memberinfos","${memberinfos}","subMenuName","${subMenuName}",
					  		  "mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryMemInfosByForeignType(){
		try {
			memberinfos = memberinfoManager.queryMemInfosByForeignType(foreignType);
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@Action(value = "/queryMemInfosByMemType",
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_team_memType.jsp", 
					params = {"bodao","${bodao}","boDaoMems","${boDaoMems}",
							  "profess","${profess}","professions","${professions}",
							  "fuProfess","${fuProfess}","fuProfessions","${fuProfessions}",
							  "jiangshi","${jiangshi}","jiangShis","${jiangShis}",
							  "others","${others}","othersMem","${othersMem}",
							  "subMenuName","${subMenuName}","mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryMemInfosByMemType(){
		try {
			memType = StringUtil.convertCodeToUtf(memType);
			bodao = "博导";
			profess = "教授";
			fuProfess = "副教授";
			jiangshi = "讲师";
			others =  "其他";
			boDaoMems = memberinfoManager.queryMemInfosByMemTypeOfBoDao(memType, bodao);
			professions = memberinfoManager.queryMemInfosByMemTypeProfess(memType, profess, bodao);//非博导的教授
			fuProfessions = memberinfoManager.queryMemInfosByMemTypeJobTitle(memType, fuProfess);
			jiangShis = memberinfoManager.queryMemInfosByMemTypeJobTitle(memType, jiangshi);
			othersMem = memberinfoManager.queryMemByMemTypeNotIn(memType, profess, fuProfess, jiangshi);
			System.out.println("=====>>>" + othersMem.get(0).getMemname());
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryMemInfosBych", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_memChao.jsp", 
					params = {"qianRenPlain","${qianRenPlain}","qianRenPlains","${qianRenPlains}",
							  "changJiangPerson","${changJiangPerson}","changJiangPersons","${changJiangPersons}",
							  "foreignMingshi","${foreignMingshi}","foreignMingshis","${foreignMingshis}",
							  "jieChuPerson","${jieChuPerson}","jieChuPersons","${jieChuPersons}",
							  "baiQianWan","${baiQianWan}","baiMemberinfos","${baiMemberinfos}",
							  "youxiuJiJin","${youxiuJiJin}","youxiuJiJins","${youxiuJiJins}",
							  "newShiJi","${newShiJi}","newShiJis","${newShiJis}",
							  "baiPerson","${baiPerson}","baiPersons","${baiPersons}",
							  "huangShan","${huangShan}","huangShans","${huangShans}",
							  "subMenuName","${subMenuName}","mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryMemInfosBych(){
		try {
			qianRenPlain = "千人计划";
			changJiangPerson = "长江学者";
			foreignMingshi = "海外名师";
			jieChuPerson = "杰出青年";
			baiQianWan = "百千万";
			youxiuJiJin = "优秀青年基金";
			newShiJi = "教育部新世纪人才计划";
			baiPerson = "百人计划";
			huangShan = "黄山学者";
			qianRenPlains = memberinfoManager.queryMemInfosByChengHao(qianRenPlain);
			changJiangPersons = memberinfoManager.queryMemInfosByChengHao(changJiangPerson);
			foreignMingshis = memberinfoManager.queryMemInfosByChengHao(foreignMingshi);
			jieChuPersons = memberinfoManager.queryMemInfosByChengHao(jieChuPerson);
			baiMemberinfos = memberinfoManager.queryMemInfosByChengHao(baiQianWan);
			youxiuJiJins = memberinfoManager.queryMemInfosByChengHao(youxiuJiJin);
			newShiJis = memberinfoManager.queryMemInfosByChengHao(newShiJi);
			baiPersons = memberinfoManager.queryMemInfosByChengHao(baiPerson);
			huangShans = memberinfoManager.queryMemInfosByChengHao(huangShan);
			
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return ERROR;
		}
	}
	
	@Action(value = "/adminQueryMemInfos", 
			results = {
			@Result(name = "success", type = "dispatcher", location = "/admin/queryMem_admin.jsp", 
					params = {"memberinfos","${memberinfos}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String adminQueryMemInfos(){
		try {
			memberinfos = memberinfoManager.findAll();
			return SUCCESS;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ERROR;
		}
	}
}
