package com.example.administrator.control;

import com.example.administrator.retrofit.bean.ReturnInfoResult;

/**
 * 完善信息回调请求返回的数据
 */
public interface CallBackCompleteUserInfo {
    /**
     * 请求成功
     */
    void SuccessResult(ReturnInfoResult infoResult);


    /**
     * 请求失败
     */
    void FailResult(String result);
}
