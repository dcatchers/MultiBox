package com.example.administrator.retrofit.config;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import com.example.administrator.control.CallBackCompleteUserInfo;
import com.example.administrator.control.CallBackResponseContent;
import com.example.administrator.retrofit.bean.ReturnInfoResult;
import com.example.administrator.retrofit.center.LoadCenter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import com.example.administrator.widget.CustomProgressDialog;

/**
 * Created by Wyf on 2016/8/25.
 */
public class RetrofitUtils {

    //private CustomProgressDialog dialog = null;

    private volatile static RetrofitUtils instance;

    public RetrofitUtils() {

    }

    public static RetrofitUtils getInstance() {
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (instance == null) {
            //同步块，线程安全的创建实例
            synchronized (RetrofitUtils.class) {
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if (instance == null) {
                    instance = new RetrofitUtils();
                }
            }
        }
        return instance;
    }

    public Call<JsonElement> getData(Context context, String url, final CallBackResponseContent callBack) {
        show(context, "正在加载数据");
        Call<JsonElement> resBodyCall = LoadCenter.getInstance().get(url);
        resBodyCall.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                dismiss();
                Log.d("========get===========", "onResponse: " + response.body());
                Log.d("========get===========", "message: " + response.message());
                Log.d("========get===========", "code: " + response.code());
                if (response.code() != 200) {
                    callBack.getFailContent("失败");
                } else {
                    String result = response.body().toString();
                    if (result == null || TextUtils.isEmpty(result)) {
                        callBack.getFailContent("返回的数据为空");
                    } else {
                        callBack.getResponseContent(result);
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                dismiss();
                if (!call.isCanceled()) {
                    callBack.getFailContent(t.toString());
                }
            }
        });

        return resBodyCall;
    }

    public boolean isNotNull(String s) {
        if (s == null || TextUtils.isEmpty(s)) {
            return false;
        }
        return true;
    }

    //完善修改用户信息
    public Call<JsonElement> updateUserPerfect(Context context, String lastName, String sex, String birthday,
                                               String address, String appUserName, final CallBackCompleteUserInfo callBack) {
        show(context, "正在加载数据");
        Map<String, String> map = new HashMap<>();
        if (isNotNull(lastName)) {
            map.put("lastName", lastName);
        }
        if (isNotNull(sex)) {
            map.put("sex", sex);
        }
        if (isNotNull(birthday) && !birthday.equals("未完善")) {
            map.put("birthday", birthday);
        }
        if (isNotNull(address)) {
            map.put("address", address);
        }
        map.put("appUserName", appUserName);
        Call<JsonElement> call = LoadCenter.getInstance().load(RetrofitConst.getInstance().updateUserPerfect(), map, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                dismiss();
                Log.d("===================", "onResponse: " + response.body());
                Log.d("===================", "message: " + response.message());
                Log.d("===================", "code: " + response.code());
                if (response.code() != 200) {
                    callBack.FailResult("返回数据有问题");
                } else {
                    String result = response.body().toString();
                    if (result == null || TextUtils.isEmpty(result)) {
                        callBack.FailResult("返回的数据为空");
                    } else {
                        ReturnInfoResult infoResult = (ReturnInfoResult) RetrofitConst.parseData(result, new Gson(), new TypeToken<ReturnInfoResult>() {
                        });
                        callBack.SuccessResult(infoResult);
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                dismiss();
                if (!call.isCanceled()) {
                    callBack.FailResult(t.toString());
                }
            }
        });

        return call;
    }

    public Call<JsonElement> postData(Context context, String url, Map<String, String> map, final CallBackResponseContent callBack, boolean isShowDialog) {
        if (isShowDialog) {
            show(context, "正在加载数据");
        }
        Call<JsonElement> call = LoadCenter.getInstance().load(url, map, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                dismiss();
                Log.d("===================", "onResponse: " + response.body());
                Log.d("===================", "message: " + response.message());
                Log.d("===================", "code: " + response.code());
                if (response.code() != 200) {
                    callBack.getFailContent("返回数据有问题");
                } else {
                    String result = response.body().toString();
                    if (result == null || TextUtils.isEmpty(result)) {
                        callBack.getFailContent("返回的数据为空");
                    } else {
                        callBack.getResponseContent(result);
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                dismiss();
                if (!call.isCanceled()) {
                    callBack.getFailContent(t.toString());
                }
            }
        });

        return call;
    }

    public void dismiss() {
        /*if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }*/
    }

    public void show(Context context, String str) {
        /*if (dialog == null) {
            dialog = CustomProgressDialog.createDialog(context);
            dialog.show();
        } else {
            if (!dialog.isShowing()) {
                dialog.show();
            }
        }*/

    }

    /**
     * 通过URI将请求网址中的中文字符进行转码。[只对中文部分进行转码]
     *
     * @param url 原始网址
     * @return 转码后的网址。
     */
    public String encodeUrl(String url) {
        return Uri.encode(url, "-![.:/,%?&=]");
    }

}
