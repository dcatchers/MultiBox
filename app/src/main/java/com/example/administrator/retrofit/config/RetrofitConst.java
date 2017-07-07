package com.example.administrator.retrofit.config;

import android.text.TextUtils;
import android.util.Log;

import com.example.administrator.control.CodeConstants;
import com.example.administrator.control.MyApplication;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * 网络请求的接口
 */
public class RetrofitConst {

    public static final String TAG = "RetrofitConst";
    //    public static final String HOST_URL = "http://36.110.109.123:21580/";//演示平台
//    public static final String HOST_URL = "http://111.13.30.152:1840/";//测试平台
//    public static final String HOST_URL = "http://10.254.15.45:21580/";
    public static final String HOST_URL = "http://111.13.30.85:8080/";//正式平台
//    public static final String HOST_URL = "http://cen.phone.citicguoanbn.com:8080/";
//    public static final String HOST_URL = "http://182.18.26.5:21580/";

    public static final String CSAPP = "csapp";

    public static final String center_url = HOST_URL + "center";

    private static RetrofitConst ourInstance = new RetrofitConst();

    public static RetrofitConst getInstance() {
        return ourInstance;
    }


    public String PIC_URL;
    public String IP;
    public String PORT;
    public String url;

    private RetrofitConst() {
    }

    public String getPIC_URL() {
        if (isNull(PIC_URL)) {
            this.PIC_URL = MyApplication.getMyApplication().getData(CodeConstants.PICURL);
        }
        return PIC_URL;
    }

    public void Reseturl(String Ip, String PORT) {
        this.IP = "http://" + Ip;
        this.PORT = ":" + PORT + "/";
        MyApplication.getMyApplication().setData(CodeConstants.IP, this.IP);
        MyApplication.getMyApplication().setData(CodeConstants.PORT, this.PORT);
        Log.d(TAG, "IP: " + MyApplication.getMyApplication().getData(CodeConstants.IP));
        Log.d(TAG, "PORT: " + MyApplication.getMyApplication().getData(CodeConstants.PORT));
        this.url = this.IP + this.PORT;
        this.PIC_URL = this.IP + ":" + PORT;
        MyApplication.getMyApplication().setData(CodeConstants.PICURL, this.PIC_URL);
        this.PlayVideo = url + CSAPP + "/PlayVideo/";
        this.Business = url + CSAPP + "/Business/";
        this.Version = url + CSAPP + "/Version/";
        this.User = url + CSAPP + "/User/";
        this.Channel = url + CSAPP + "/Channel/";
        Log.d(TAG, "url: " + url);
    }

    private String getUrl() {
        return "http://120.202.127.36:21580/";
       /* if (isNull(url)) {
            this.url = MyApplication.getMyApplication().getData(CodeConstants.IP) +
                    MyApplication.getMyApplication().getData(CodeConstants.PORT);
        }
        return url;*/
    }

    /**
     * 点播模块接口
     */
    private String PlayVideo;

    private String getPlayVideo() {
        if (isNull(PlayVideo)) {
            this.PlayVideo = getUrl() +
                    CSAPP + "/PlayVideo/";
        }
        return PlayVideo;
    }

    public boolean isNull(String s) {
        if (s == null || TextUtils.isEmpty(s)) {
            return true;
        }
        return false;
    }

    /**
     * 保存用户播放记录
     *
     * @return
     */
    public String savePlayHistory() {
        return getPlayVideo() + "savePlayHistory ";
    }

    /**
     * 一级分类查询接口
     */
    public String getFirstVideo() {
        return getPlayVideo() + "getFirstVideo";
    }

    /**
     * 根据一级分类获取节目信息
     */
    public String getProgramByFirstVideoId() {
        return getPlayVideo() + "getProgramByFirstVideoId";
    }

    /**
     * 视频点播(第一次请求)
     */
    public String getProgramByProgramIdFirst() {
        return getPlayVideo() + "getProgramByProgramIdFirst";
    }

    /**
     * 视频点播(再次请求)
     */
    public String getProgramByProgramIdAndEpisodesNumber() {
        return getPlayVideo() + "getProgramByProgramIdAndEpisodesNumber";
    }

    /**
     * 根据关键字查询信息（节目信息）
     */
    public String getProgramInfoAndYearsAndLeadByKey() {
        return getPlayVideo() + "getProgramInfoAndYearsAndLeadByKey";
    }

    /**
     * 根据二级分类id去分页查询节目信息
     */
    public String getProgramInfoBySecondVideoId() {
        return getPlayVideo() + "getProgramInfoBySecondVideoId";
    }

    /**
     * 业务相关
     */
    private String Business;

    private String getBusiness() {
        if (isNull(Business)) {
            this.Business = getUrl() +
                    CSAPP + "/Business/";
        }
        return Business;
    }

    /**
     * 获取营业厅信息
     */
    public String getBusinessHallInfo() {
        return getBusiness() + "getBusinessHallInfo";
    }

    /**
     * 获取业务一级分类信息
     */
    public String getBusinessInfo() {
        return getBusiness() + "getBusinessInfo";
    }

    /**
     * 获取产品的信息
     */
    public String getProductInfo() {
        return getBusiness() + "getProductInfo";
    }

    /**
     * 获取产品更加详细的信息
     */
    public String getProductInfoMore() {
        return getBusiness() + "getProductInfoMore";
    }

    /**
     * 其他相关接口
     */
    private String Version;

    private String getVersion() {
        if (isNull(Version)) {
            this.Version = getUrl() +
                    CSAPP + "/Version/";
        }
        return Version;
    }

    /**
     * 返回版本信息
     */
    public String getAndroidVersionInfo() {
        return getVersion() + "getAndroidVersionInfo";
    }

    /**
     * 免责声明
     */
    public String getDisclaimer() {
        return getVersion() + "getDisclaimer";
    }


    /**
     * 直播模块接口
     */
    private String Channel;

    private String getChannel() {
        if (isNull(Channel)) {
            this.Channel = getUrl() +
                    CSAPP + "/Channel/";
        }
        return Channel;
    }

    /**
     * 模糊查询频道信息
     */
    public String getChannelNameByAlias() {
        return getChannel() + "getChannelNameByAlias";
    }

    /**
     * 分页查询频道信息
     */
    public String getChannelTitleByPage() {
        return getChannel() + "getChannelTitleByPage";
    }

    /**
     * 节目预告信息
     */
    public final String getChannelInfoByChannelTitleId() {
        return getChannel() + "getChannelInfoByChannelTitleId";
    }

    /**
     * 预定节目推送
     */
    public String reserveChannel() {
        return getChannel() + "reserveChannel";
    }

    /**
     * 取消预订节目推送
     */
    public String cancelReserveChannel() {
        return getChannel() + "cancelReserveChannel";
    }

    /**
     * 查询用户常用频道
     */
    public String getCommonChannelTitle() {
        return getChannel() + "getCommonChannelTitle ";
    }

    /**
     * 查询全部频道信息
     */
    public String getAllChannelTitle() {
        return getChannel() + "getAllChannelTitle ";
    }

    /**
     * 添加用户常用频道
     */
    public String addCommonChannelTitle() {
        return getChannel() + "addCommonChannelTitle  ";
    }

    /**
     * 删除用户常用频道
     */
    public String deleteCommonChannelTitle() {
        return getChannel() + "deleteCommonChannelTitle  ";
    }

    /**
     * 用户相关接口
     */
    private String User;

    private String getUser() {
        if (isNull(User)) {
            this.User = getUrl() +
                    CSAPP + "/User/";
        }
        return User;
    }

    /**
     * 获取全部区域和全部区域服务器ip(中心)
     */
    public String getCAddressInfo() {
        return center_url + "/User/getCAddressInfo";
    }

    /**
     * 验证手机号是否被占用
     */
    public String testPhoneNo() {
        return getUser() + "testPhoneNo";
    }

    /**
     * 验证用户名是否被占用
     */
    public String testUserName() {
        return getUser() + "testUserName";
    }

    /**
     * 测试手机号和用户名是否一致
     * 描述:用于忘记密码时的校验
     *
     * @return
     */
    public String testPhoneNoAndUserName() {
        return getUser() + "testPhoneNoAndUserName";
    }

    /**
     * 获取短信验证码
     */
    public String getValidate() {
        return getUser() + "getValidate";
    }

    /**
     * 注册
     */
    public String OnlineRegister() {
        return getUser() + "OnlineRegister";
    }

    /**
     * 完善用户资料
     */
    public String updateUserPerfect() {
        return getUser() + "updateUserPerfect";
    }

    /**
     * 头像上传
     */
    public String updatePicture() {
        return getUser() + "updatePicture";
    }

    /**
     * 登录(中心)
     */
    public String getCustLoginInfo() {
        return center_url + "/User/getCustLoginInfo";
    }

    /**
     * 修改密码
     */
    public String modifyPasswd() {
        return getUser() + "modifyPasswd";
    }

    /**
     * 重置密码
     */
    public String resetPasswd() {
        return getUser() + "resetPasswd";
    }

    /**
     * 修改手机号
     */
    public String modifyPhoneNo() {
        return getUser() + "modifyPhoneNo";
    }

    /* 连接超时时长 */
    public static final int CONNECT_TIMEOUT = 10 * 1000;

    /* 读取超时时长 */
    public static final int READ_TIMEOUT = 20 * 1000;

    public static Object parseData(String data, Gson gson, TypeToken typeToken) {
        return gson.fromJson(data, typeToken.getType());
    }
}
