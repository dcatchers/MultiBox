package com.example.administrator.retrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wyf on 2016/9/9.
 */
public class CustInfoResult extends ReturnInfoResult implements Serializable {

    /**
     * phoneNo : 17745696325
     * birthday : 2016-09-09
     * lastName : 灯塔
     * cAdderss : 浏阳
     * sex : 男
     * address : 山东 济南 商河
     * headPortraitUrl : /image/headPortrait/100011.jpg
     * appUserName : 哈哈
     * appUserId : 100011
     * cAdderss : 长沙
     * port : 8080
     * ip : 192.168.10.253
     */
    @SerializedName("phoneNo")
    private String phoneNo;
    @SerializedName("birthday")
    private String birthday;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("cAdderss")
    private String cAdderss;
    @SerializedName("sex")
    private String sex;
    @SerializedName("address")
    private String address;
    @SerializedName("headPortraitUrl")
    private String headPortraitUrl;
    @SerializedName("appUserName")
    private String appUserName;
    @SerializedName("appUserId")
    private String appUserId;
    @SerializedName("port")
    private String port;
    @SerializedName("ip")
    private String ip;

    @Override
    public String toString() {
        return "CustInfoResult{" +
                "phoneNo='" + phoneNo + '\'' +
                ", birthday='" + birthday + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cAdderss='" + cAdderss + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", headPortraitUrl='" + headPortraitUrl + '\'' +
                ", appUserName='" + appUserName + '\'' +
                ", appUserId='" + appUserId + '\'' +
                ", port='" + port + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCAdderss() {
        return cAdderss;
    }

    public void setCAdderss(String cAdderss) {
        this.cAdderss = cAdderss;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHeadPortraitUrl() {
        return headPortraitUrl;
    }

    public void setHeadPortraitUrl(String headPortraitUrl) {
        this.headPortraitUrl = headPortraitUrl;
    }

    public String getAppUserName() {
        return appUserName;
    }

    public void setAppUserName(String appUserName) {
        this.appUserName = appUserName;
    }

    public String getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId;
    }
}
