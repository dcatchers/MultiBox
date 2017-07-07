package com.example.administrator.retrofit.bean;

import java.io.Serializable;

/**
 * Created by liangxingfei on 2016/8/29.
 */
public class OrderResult implements Serializable {

    /**
     * returnCode : 999
     * returnMsg : 未捕获的异常
     */

    private int returnCode;
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
}
