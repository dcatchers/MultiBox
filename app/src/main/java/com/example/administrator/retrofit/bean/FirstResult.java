package com.example.administrator.retrofit.bean;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wyf on 2016/7/25.
 */
public class FirstResult implements Serializable{

    /**
     * rollInfoNumber : 5
     * rollInfoTime : 3000
     */

    @SerializedName("rollPhotoConfig")
    private RollPhotoConfigBean rollPhotoConfig;
    /**
     * data : [{"programId":"95908","postUrl":"/8901.jpg","programName":"优雅的谎言"},{"programId":"95905","postUrl":"/8900.jpg","programName":"扑通扑通我的人生"},{"programId":"95902","postUrl":"/8899.jpg","programName":"北京爱情故事"}]
     * secondVideoTypeName : 全部电影
     * secondVideoId : 53292
     */

    @SerializedName("Info")
    private List<InfoBean> Info;
    /**
     * programId : null
     * postUrl : /image/rollPhoto/98169.png
     * programName : tv1
     */

    @SerializedName("RollPhoto")
    private List<RollPhotoBean> RollPhoto;

    public RollPhotoConfigBean getRollPhotoConfig() {
        return rollPhotoConfig;
    }

    public void setRollPhotoConfig(RollPhotoConfigBean rollPhotoConfig) {
        this.rollPhotoConfig = rollPhotoConfig;
    }

    public List<InfoBean> getInfo() {
        return Info;
    }

    public void setInfo(List<InfoBean> Info) {
        this.Info = Info;
    }

    public List<RollPhotoBean> getRollPhoto() {
        return RollPhoto;
    }

    public void setRollPhoto(List<RollPhotoBean> RollPhoto) {
        this.RollPhoto = RollPhoto;
    }

    public static class RollPhotoConfigBean {
        @SerializedName("rollInfoNumber")
        private int rollInfoNumber;
        @SerializedName("rollInfoTime")
        private int rollInfoTime;

        public int getRollInfoNumber() {
            return rollInfoNumber;
        }

        public void setRollInfoNumber(int rollInfoNumber) {
            this.rollInfoNumber = rollInfoNumber;
        }

        public int getRollInfoTime() {
            return rollInfoTime;
        }

        public void setRollInfoTime(int rollInfoTime) {
            this.rollInfoTime = rollInfoTime;
        }

        @Override
        public String toString() {
            return "RollPhotoConfigBean{" +
                    "rollInfoNumber=" + rollInfoNumber +
                    ", rollInfoTime=" + rollInfoTime +
                    '}';
        }
    }

    public static class InfoBean {
        @SerializedName("secondVideoTypeName")
        private String secondVideoTypeName;
        @SerializedName("secondVideoId")
        private String secondVideoId;

        @Override
        public String toString() {
            return "InfoBean{" +
                    "secondVideoTypeName='" + secondVideoTypeName + '\'' +
                    ", secondVideoId='" + secondVideoId + '\'' +
                    ", data=" + data +
                    '}';
        }

        /**
         * programId : 95908
         * postUrl : /8901.jpg
         * programName : 优雅的谎言
         */

        @SerializedName("data")
        private List<DataBean> data;

        public String getSecondVideoTypeName() {
            return secondVideoTypeName;
        }

        public void setSecondVideoTypeName(String secondVideoTypeName) {
            this.secondVideoTypeName = secondVideoTypeName;
        }

        public String getSecondVideoId() {
            return secondVideoId;
        }

        public void setSecondVideoId(String secondVideoId) {
            this.secondVideoId = secondVideoId;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            @SerializedName("programId")
            private String programId;
            @SerializedName("postUrl")
            private String postUrl;
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

            public String getProgramName() {
                return programName;
            }

            public void setProgramName(String programName) {
                this.programName = programName;
            }

            @Override
            public String toString() {
                return "DataBean{" +
                        "programId='" + programId + '\'' +
                        ", postUrl='" + postUrl + '\'' +
                        ", programName='" + programName + '\'' +
                        '}';
            }
        }
    }

    public static class RollPhotoBean {
        @SerializedName("programId")
        private Object programId;
        @SerializedName("postUrl")
        private String postUrl;
        @SerializedName("programName")
        private String programName;
        @SerializedName("busiType")
        private String busiType;//1：数字电视业务，2：宽带业务，3：OTT业务，4：web页面，5：微信公众号
        @SerializedName("urlType")
        private String urlType;//0代表内部url，1代表外部url
        @SerializedName("webUrl")
        private String webUrl;

        public Object getProgramId() {
            return programId;
        }

        public void setProgramId(Object programId) {
            this.programId = programId;
        }

        public String getPostUrl() {
            return postUrl;
        }

        public void setPostUrl(String postUrl) {
            this.postUrl = postUrl;
        }

        public String getProgramName() {
            return programName;
        }

        public void setProgramName(String programName) {
            this.programName = programName;
        }

        public String getBusiType() {
            return busiType;
        }

        public void setBusiType(String busiType) {
            this.busiType = busiType;
        }

        public String getUrlType() {
            return urlType;
        }

        public void setUrlType(String urlType) {
            this.urlType = urlType;
        }

        public String getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(String webUrl) {
            this.webUrl = webUrl;
        }

        @Override
        public String toString() {
            return "RollPhotoBean{" +
                    "programId=" + programId +
                    ", postUrl='" + postUrl + '\'' +
                    ", programName='" + programName + '\'' +
                    ", busiType='" + busiType + '\'' +
                    ", urlType='" + urlType + '\'' +
                    ", webUrl='" + webUrl + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "FirstResult{" +
                "rollPhotoConfig=" + rollPhotoConfig +
                ", Info=" + Info +
                ", RollPhoto=" + RollPhoto +
                '}';
    }
}
