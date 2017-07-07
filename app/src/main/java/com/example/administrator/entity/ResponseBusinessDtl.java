package com.example.administrator.entity;

import java.io.Serializable;

/**
 * 电视业务的详情
 */
@SuppressWarnings("serial")
public class ResponseBusinessDtl implements Serializable{
	
	private String tbTitle;
	private String tbContent;
	private String tbPicUrl;
	private String tbMvUrl;
	private String tbLevel;
	private String fee;
	private String returnCode;
	private String returnMsg;
	

	public String getTbTitle() {
		return tbTitle;
	}

	public void setTbTitle(String tbTitle) {
		this.tbTitle = tbTitle;
	}
	

	public String getTbContent() {
		return tbContent;
	}

	public void setTbContent(String tbContent) {
		this.tbContent = tbContent;
	}
	
	public String getTbPicUrl() {
		return tbPicUrl;
	}

	public void setTbPicUrl(String tbPicUrl) {
		this.tbPicUrl = tbPicUrl;
	}
	
	public String getTbMvUrl() {
		return tbMvUrl;
	}

	public void setTbMvUrl(String tbMvUrl) {
		this.tbMvUrl = tbMvUrl;
	}
	
	public String getTbLevel() {
		return tbLevel;
	}

	public void setTbLevel(String tbLevel) {
		this.tbLevel = tbLevel;
	}
	
	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}
	
	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	
	
	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

}
