package com.science.action;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.science.exception.MessageException;
import com.science.util.string.StringUtil;

@ParentPackage("json-default")
@Result(type = "json", params = {"ignoreHierarchy", "true"})
public class GetAndSaveAvtion extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	private boolean success;
	private String msg;
	protected int start;
	protected String type;
	protected int limit;
	protected String zjm;
	
	protected long totalProperty;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getZjm() {
		return zjm;
	}
	public void setZjm(String zjm) {
		this.zjm = zjm;
	}
	public long getTotalProperty() {
		return totalProperty;
	}
	public void setTotalProperty(long totalProperty) {
		this.totalProperty = totalProperty;
	}
	
	public void generateFailureMsg(Exception e){
		if( e instanceof MessageException){
			this.msg = ((MessageException)e).getMsg();
		}
		success = false;
		e.printStackTrace();
	}
	/**
	 * 生成失败的消息，优先使用MessageException中的消息，否则使用默认消息
	 * @param defaultMsg
	 */
	public void generateFailureMag(String defaultMsg){
		if(!StringUtil.isEmpty(defaultMsg)){
			this.msg = defaultMsg;
		}
		success = false;
	}
	/**
	 * 生成失败的消息，优先使用MessageException中的消息，否则使用默认消息
	 * @param e
	 * @param defaultMsg
	 */
	public void generateFailureMag(Exception e, String defaultMsg){
		if(e instanceof MessageException){
			this.msg = ((MessageException)e).getMsg();
		}else if(!StringUtil.isEmpty(defaultMsg)){
			this.msg = defaultMsg;
		}
		success = false;
		e.printStackTrace();
	}
	/**
	 * 生成成功的消息
	 * @param defaultMsg
	 */
	public void generateSuccessMsg(String defaultMsg){
		if(!StringUtil.isEmpty(defaultMsg)){
			this.msg  = defaultMsg;
		}
		success = true;
	}
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
}
