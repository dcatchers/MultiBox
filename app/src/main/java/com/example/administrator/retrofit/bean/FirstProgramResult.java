package com.example.administrator.retrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Wyf on 2016/9/8.
 */
public class FirstProgramResult extends ProgramInfoResult implements Serializable{

    /**
     * contentInfo : 主演:高修/李瑶媛/孙贤周/尹胜雅/朴根亨/张申英
     导演:赵南国
     内容介绍:《黄金帝国》以韩国经济飞速发展的上世纪90年代为时代背景，讲述了发生在韩国某财阀家族的权力和金钱斗争。高修在剧中将饰演为从最底层爬到最高层而无所不用其极，最终达成目标的男主人公。
     * episodesNumberList : ["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","18","19","21","22","23","24"]
     */

    @SerializedName("contentInfo")
    private String contentInfo;
    @SerializedName("episodesNumberList")
    private List<String> episodesNumberList;

    public String getContentInfo() {
        return contentInfo;
    }

    public void setContentInfo(String contentInfo) {
        this.contentInfo = contentInfo;
    }

    public List<String> getEpisodesNumberList() {
        return episodesNumberList;
    }

    public void setEpisodesNumberList(List<String> episodesNumberList) {
        this.episodesNumberList = episodesNumberList;
    }

    @Override
    public String toString() {
        return "FirstProgramResult{" +
                "contentInfo='" + contentInfo + '\'' +
                ", episodesNumberList=" + episodesNumberList +
                '}';
    }
}
