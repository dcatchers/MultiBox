package com.example.administrator.retrofit.bean;

import java.io.Serializable;

/**
 * Created by lining on 2016/8/26.
 */
public class ForeshowResult implements Serializable {


    /**
     * playTime : 2016-08-26 16:21:58
     * channelId : 632031
     * channelContent : 全天节目结束
     * isOrder : 0
     */

    private String playTime;
    private String channelId;
    private String channelContent;
    private int isOrder;

    public int getIsOrder() {
        return isOrder;
    }

    public void setIsOrder(int isOrder) {
        this.isOrder = isOrder;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelContent() {
        return channelContent;
    }

    public void setChannelContent(String channelContent) {
        this.channelContent = channelContent;
    }

    @Override
    public String toString() {
        return "LiveResult{" +
                "playTime='" + playTime + '\'' +
                ",channelId='" + channelId + '\'' +
                ",channelContent='" + channelContent + '\'' +
                ",isOrder='" + isOrder + '\'' +
                '}';
    }
}
