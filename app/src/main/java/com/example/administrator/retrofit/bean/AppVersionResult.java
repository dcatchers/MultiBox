package com.example.administrator.retrofit.bean;

import com.example.administrator.entity.CommonBaseInfo;
import com.google.gson.annotations.SerializedName;

/**
 * 版本信息
 */
public class AppVersionResult extends CommonBaseInfo {

	/**
	 * appName : 1.5.0
	 * apkURL : csapp.apk
	 * appCode : 7
	 */
	@SerializedName("appName")
	private String appName;
	@SerializedName("apkURL")
	private String apkURL;
	@SerializedName("appCode")
	private String appCode;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getApkURL() {
		return apkURL;
	}

	public void setApkURL(String apkURL) {
		this.apkURL = apkURL;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
}
