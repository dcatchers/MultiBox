package com.example.administrator.retrofit.bean;

import java.io.Serializable;

/**
 * Created by lining on 2016/8/26.
 */
public class LiveResult implements Serializable {


    /**
     * channelTitleId : 548225
     * channelTitle : 3D试验频道
     * channelPostUrl : 还没有哦
     */

    private String channelTitleId;
    private String channelTitle;
    private String channelPostUrl;

    public String getChannelTitleId() {
        return channelTitleId;
    }

    public void setChannelTitleId(String channelTitleId) {
        this.channelTitleId = channelTitleId;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getChannelPostUrl() {
        return channelPostUrl;
    }

    public void setChannelPostUrl(String channelPostUrl) {
        this.channelPostUrl = channelPostUrl;
    }

    @Override
    public String toString() {
        return "LiveResult{" +
                "channelTitleId='" + channelTitleId + '\'' +
                ",channelTitle='" + channelTitle + '\'' +
                ",channelPostUrl='" + channelPostUrl + '\'' +
                '}';
    }
}
