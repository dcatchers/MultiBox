package com.example.administrator.retrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by wyf on 2016/7/18.
 */
public class BaseResult implements Serializable{

    /**
     * firstVideoName : 推荐
     * firstVideoId : 20
     */

    @SerializedName("firstVideoName")
    private String firstVideoName;

    @SerializedName("firstVideoId")
    private String firstVideoId;

    public String getFirstVideoName() {
        return firstVideoName;
    }

    public void setFirstVideoName(String firstVideoName) {
        this.firstVideoName = firstVideoName;
    }

    public String getFirstVideoId() {
        return firstVideoId;
    }

    public void setFirstVideoId(String firstVideoId) {
        this.firstVideoId = firstVideoId;
    }


    @Override
    public String toString() {
        return "BaseResult{" +
                "firstVideoName='" + firstVideoName + '\'' +
                ", firstVideoId='" + firstVideoId + '\'' +
                '}';
    }
}
