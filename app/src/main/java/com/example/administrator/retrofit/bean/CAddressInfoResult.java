package com.example.administrator.retrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wyf on 2016/10/10.
 */

public class CAddressInfoResult implements Serializable{

    /**
     * cAdderss : 长沙
     * port : 8080
     * ip : 192.168.10.253
     */

    @SerializedName("cAdderss")
    private String cAdderss;
    @SerializedName("port")
    private String port;
    @SerializedName("ip")
    private String ip;

    public String getCAdderss() {
        return cAdderss;
    }

    public void setCAdderss(String cAdderss) {
        this.cAdderss = cAdderss;
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

    @Override
    public String toString() {
        return "CAddressInfoResult{" +
                "cAdderss='" + cAdderss + '\'' +
                ", port='" + port + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
