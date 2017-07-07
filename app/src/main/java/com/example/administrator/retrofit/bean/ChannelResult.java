package com.example.administrator.retrofit.bean;

import java.io.Serializable;

/**
 * Created by liangxingfei on 2016/8/31.
 */
public class ChannelResult implements Serializable{

    /**
     * channelTitleId : 605584
     * channelTitle : 3D试验频道
     * channelPostUrl : null
     */

    private String channelTitleId;
    private String channelTitle;
    private Object channelPostUrl;

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

    public Object getChannelPostUrl() {
        return channelPostUrl;
    }

    public void setChannelPostUrl(Object channelPostUrl) {
        this.channelPostUrl = channelPostUrl;
    }
}
