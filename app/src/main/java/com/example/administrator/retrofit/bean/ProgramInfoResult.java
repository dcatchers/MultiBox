package com.example.administrator.retrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wyf on 2016/9/8.
 */
public class ProgramInfoResult implements Serializable{

    /**
     * destPath : http://10.254.12.22/otv/guangshi/6/D9/95/00000000467/index.m3u8
     * programName : 黄金帝国　02
     */

    @SerializedName("destPath")
    private String destPath;
    @SerializedName("programName")
    private String programName;

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @Override
    public String toString() {
        return "ProgramInfoResult{" +
                "destPath='" + destPath + '\'' +
                ", programName='" + programName + '\'' +
                '}';
    }
}
