package com.example.administrator.retrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 实体营业厅地址信息
 */
public class YytAddrInfoResult implements Serializable {


	/**
	 * busiHallId : 98129
	 * busiHallName : 呵呵
	 * busiHallPhone : 嘿嘿
	 * busiHallAddress : 哈哈
	 */

	@SerializedName("busiHallId")
	private int busiHallId;
	@SerializedName("busiHallName")
	private String busiHallName;
	@SerializedName("busiHallPhone")
	private String busiHallPhone;
	@SerializedName("busiHallAddress")
	private String busiHallAddress;

	public int getBusiHallId() {
		return busiHallId;
	}

	public void setBusiHallId(int busiHallId) {
		this.busiHallId = busiHallId;
	}

	public String getBusiHallName() {
		return busiHallName;
	}

	public void setBusiHallName(String busiHallName) {
		this.busiHallName = busiHallName;
	}

	public String getBusiHallPhone() {
		return busiHallPhone;
	}

	public void setBusiHallPhone(String busiHallPhone) {
		this.busiHallPhone = busiHallPhone;
	}

	public String getBusiHallAddress() {
		return busiHallAddress;
	}

	public void setBusiHallAddress(String busiHallAddress) {
		this.busiHallAddress = busiHallAddress;
	}

	@Override
	public String toString() {
		return "YytAddrInfoResult{" +
				"busiHallId=" + busiHallId +
				", busiHallName='" + busiHallName + '\'' +
				", busiHallPhone='" + busiHallPhone + '\'' +
				", busiHallAddress='" + busiHallAddress + '\'' +
				'}';
	}
}
