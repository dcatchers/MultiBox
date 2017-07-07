package com.example.administrator.control;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.WindowManager;


public class MyApplication extends Application {

    private static MyApplication application;

    // sharepreference的存储
    private static final String WIDTH = "w";

    private static final String HIGHT = "h";

    private static final String INDEX = "index";

    private static final String ISLOGIN = "isLogin";

    /**
     * 创建全局变量
     * <p/>
     * 全局变量一般都比较倾向于创建一个单独的数据类文件，并使用static静态变量
     * <p/>
     * <p/>
     * <p/>
     * 这里使用了在Application中添加数据的方法实现全局变量
     * <p/>
     * 注意在AndroidManifest.xml中的Application节点添加android:name=".MyApplication"属性
     */

    private WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();

    public WindowManager.LayoutParams getMywmParams() {

        return wmParams;

    }

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
    }

    public int getScreenWidth() {
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        return width;
    }

    public static MyApplication getMyApplication() {
        return application;
    }


    public void setData(String id, String firstData) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.this);
        Editor editor = preferences.edit();
        editor.putString(id, firstData).commit();
    }

    public String getData(String id) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.this);
        return preferences.getString(id, "");
    }

    public void setIsLogin(boolean islogin) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.this);
        Editor editor = preferences.edit();
        editor.putBoolean(ISLOGIN, islogin).commit();
    }

    public boolean getIsLogin() {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.this);
        return preferences.getBoolean(ISLOGIN, false);
    }

    public void setIsDownApk(boolean isload) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.this);
        Editor editor = preferences.edit();
        editor.putBoolean(CodeConstants.ISLOAD, isload).commit();
    }

    public boolean getIsDownApk() {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.this);
        return preferences.getBoolean(CodeConstants.ISLOAD, false);
    }

    /**
     * 获取保存的页面id
     *
     * @return
     */
    public int getIndex() {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.this);
        return preferences.getInt(INDEX, 0);
    }

    /**
     * 保存页面的id
     *
     * @param index
     */
    public void setIndex(int index) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.this);
        Editor editor = preferences.edit();
        editor.putInt(INDEX, index).commit();
    }

    /**
     * 获取悬浮框的横坐标
     *
     * @return
     */
    public float getWidth() {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.this);
        return preferences.getFloat(WIDTH, -1);
    }

    /**
     * 记录悬浮框的横坐标
     *
     * @param width
     */
    public void setWidth(float width) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.this);
        Editor editor = preferences.edit();
        editor.putFloat(WIDTH, width).commit();
    }

    /**
     * 获取悬浮框的纵坐标
     *
     * @return
     */
    public float getHight() {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.this);
        return preferences.getFloat(HIGHT, -1);
    }

    /**
     * 记录悬浮框的纵坐标
     *
     * @param width
     */
    public void setHight(float width) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.this);
        Editor editor = preferences.edit();
        editor.putFloat(HIGHT, width).commit();
    }

    /**
     * 退出登录
     */
    public void reSet() {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.this);
        Editor edit = preferences.edit();
        edit.clear();
        edit.commit();
    }

}
