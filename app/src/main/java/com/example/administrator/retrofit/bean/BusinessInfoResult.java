package com.example.administrator.retrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wyf on 2016/8/29.
 */
public class BusinessInfoResult implements Serializable{

    /**
     * levelOneId : 29
     * levelOneName : TV推荐
     * busiType : 1
     * oneIndex : 1
     * productPosterPath : null
     */

    @SerializedName("levelOneId")
    private int levelOneId;
    @SerializedName("levelOneName")
    private String levelOneName;
    @SerializedName("busiType")
    private int busiType;
    @SerializedName("oneIndex")
    private int oneIndex;
    @SerializedName("productPosterPath")
    private Object productPosterPath;

    public int getLevelOneId() {
        return levelOneId;
    }

    public void setLevelOneId(int levelOneId) {
        this.levelOneId = levelOneId;
    }

    public String getLevelOneName() {
        return levelOneName;
    }

    public void setLevelOneName(String levelOneName) {
        this.levelOneName = levelOneName;
    }

    public int getBusiType() {
        return busiType;
    }

    public void setBusiType(int busiType) {
        this.busiType = busiType;
    }

    public int getOneIndex() {
        return oneIndex;
    }

    public void setOneIndex(int oneIndex) {
        this.oneIndex = oneIndex;
    }

    public Object getProductPosterPath() {
        return productPosterPath;
    }

    public void setProductPosterPath(Object productPosterPath) {
        this.productPosterPath = productPosterPath;
    }

    @Override
    public String toString() {
        return "BusinessInfoResult{" +
                "levelOneId=" + levelOneId +
                ", levelOneName='" + levelOneName + '\'' +
                ", busiType=" + busiType +
                ", oneIndex=" + oneIndex +
                ", productPosterPath=" + productPosterPath +
                '}';
    }
}
