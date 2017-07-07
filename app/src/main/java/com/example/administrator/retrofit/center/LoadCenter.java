package com.example.administrator.retrofit.center;


import android.util.Log;

import com.example.administrator.retrofit.api.LoadInterface;
import com.example.administrator.retrofit.config.RetrofitModule;
import com.google.gson.JsonElement;

import java.util.Map;

import retrofit2.Call;

/**
 * Created by wyf on 2016/7/18.
 */
public class LoadCenter {
    private static final String TAG = "LoadCenter";

    private volatile static LoadCenter instance;
    private static LoadInterface loadInterface;

    private LoadCenter() {
        loadInterface = RetrofitModule.getInstance().create(LoadInterface.class);
    }

    public static LoadCenter getInstance() {
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (instance == null) {
            //同步块，线程安全的创建实例
            synchronized (LoadCenter.class) {
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if (instance == null) {
                    instance = new LoadCenter();
                }
            }
        }
        return instance;
    }

    public Call<JsonElement> load(String path, Map<String, String> map, retrofit2.Callback callback) {
        Call<JsonElement> call;
        call = loadInterface.loadData(path, map);
        Log.d(TAG, "load: " + call.toString());
        call.enqueue(callback);
        return call;
    }

    public Call<JsonElement> get(String path) {
        Call<JsonElement> call;
        call = loadInterface.getData(path);
        return call;
    }



}
