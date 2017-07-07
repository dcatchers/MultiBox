package com.example.administrator.retrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wyf on 2016/9/9.
 */
public class ReturnInfoResult implements Serializable{

    /**
     * returnCode : 0
     * returnMsg : 未被占用
     */

    @SerializedName("returnCode")
    private int returnCode;
    @SerializedName("returnMsg")
    private String returnMsg;

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    @Override
    public String toString() {
        return "ReturnInfoResult{" +
                "returnCode=" + returnCode +
                ", returnMsg='" + returnMsg + '\'' +
                '}';
    }
}
