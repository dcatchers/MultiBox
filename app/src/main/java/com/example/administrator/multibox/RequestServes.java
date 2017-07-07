package com.example.administrator.multibox;

import com.google.gson.JsonElement;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2017/7/5.
 */

public interface RequestServes {
    @GET("PlayVideo/{firstVideoId}")
    Call<JsonElement> getPlayVideo(@Path("firstVideoId") String firstVideoId);
    @GET
    Call<JsonElement> getData(@Url String url);
    @GET("{test}")
    Call<ResponseBody> getString(@Path("test") String test);

    @GET("users/{user}/repos")
    Call<ResponseBody> listRepos(@Path("user") String user);

}
