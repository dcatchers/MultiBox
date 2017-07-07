package com.example.administrator.retrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 根据搜索关键字查询信息
 * Created by wyf on 2016/3/29.
 */
public class SearchResult implements Serializable {


    /**
     * programId : 94979
     * postUrl : /usr/local/webroot/image/poster/8374.jpg
     * videoTypeName : 纪录片
     * actor :
     * years : 2013
     * levelTwoTag : 文化/社会
     * programName : 悦食中国
     */

    @SerializedName("programId")
    private String programId;
    @SerializedName("postUrl")
    private String postUrl;
    @SerializedName("videoTypeName")
    private String videoTypeName;
    @SerializedName("actor")
    private String actor;
    @SerializedName("years")
    private String years;
    @SerializedName("levelTwoTag")
    private String levelTwoTag;
    @SerializedName("programName")
    private String programName;

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getVideoTypeName() {
        return videoTypeName;
    }

    public void setVideoTypeName(String videoTypeName) {
        this.videoTypeName = videoTypeName;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getLevelTwoTag() {
        return levelTwoTag;
    }

    public void setLevelTwoTag(String levelTwoTag) {
        this.levelTwoTag = levelTwoTag;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "programId='" + programId + '\'' +
                ", postUrl='" + postUrl + '\'' +
                ", videoTypeName='" + videoTypeName + '\'' +
                ", actor='" + actor + '\'' +
                ", years='" + years + '\'' +
                ", levelTwoTag='" + levelTwoTag + '\'' +
                ", programName='" + programName + '\'' +
                '}';
    }
}
