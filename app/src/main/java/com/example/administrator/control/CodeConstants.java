package com.example.administrator.control;

public class CodeConstants {
	public static final String NAMESPACE_IN_GENERATED_REQUEST = "http://online.ws.uboss.bupt.com";
	public static final String SOAP_ACTION = "";
	public static final boolean WEBSERVICE_CALL_PRINT = true;

	public static final String MAIN_URL ="http://www.evmtv.com:6081/EMSP_AMS/servlet";
	public static final String HTTPURL = "http://10.236.20.7:8080/trunk/Broad";

	/**
	 * 模式设置的action
	 * 
	 */
	public static final String BROCAST_ACTION= "com.bupt.chshtv.control.ThemeBroadCast";
	public static final String THEME = "theme";
	public static final String SIZE = "size";

	public static final String DEVICE ="DEVICES";
	public static final String FIRST_DATAS ="FIRST_DATAS";
	public static final String COMM ="COMM_";
	public static final String SEAR_RECORD ="SEAR_RECORD";
	public static final String YYT_DATAS ="YYT_DATAS";//营业厅

	public static final String RETURN_SUCCESS = "0";

	public static final int SELECT_PIC_BY_TACK_PHOTO = 100;

	public static final int SELECT_PIC_BY_PICK_PHOTO = 200;
	public static final int CROP_PHOTO = 300;

	public static final int COMPLETE_USER_USERNAME = 3;
	public static final int COMPLETE_USER_SEX = 4;
	public static final int COMPLETE_USER_BIRTHDAY = 5;
	public static final int COMPLETE_USER_ADDRESS = 6;
	public static final int COMPLETE_USER_PHONE = 7;

	public static final int REQUEST_CAMER = 0;
	public static final int REQUEST_READ_STORAGE = 1;
	public static final int REQUEST_WRITE_STORAGE = 2;
	public static final int RECORD_AUDIO = 3;//录音权限

	public static final int NICHENGMAXLENGTH = 18;//昵称的最大长度

	public static final String LOGINPHONE = "LOGINPHONE";//登录手机号
	public static final String APPUSERNAME = "APPUSERNAME";//登录的用户名
	public static final String NICKNAME ="NICKNAME";//昵称
	public static final String ADDRESS ="ADDRESS";//地址
	public static final String BIRTHDAY ="BIRTHDAY";//生日
	public static final String SEX ="SEX";//性别
	public static final String CADDRESS = "CADDRESS";//区域,不可变的
	public static final String APPUSERID = "APPUSERID";//用户ID
	public static final String HEADPORTRAITURL = "HEADPORTRAITURL";//头像地址
	public static final String IP = "IP";//地方的ip地址
	public static final String PORT = "PORT";//地方的端口号
	public static final String PICURL = "PICURL";//图片地址
	public static final String ISBACK = "ISBACK";//应用是否在后台的标识
	public static final String ISLOAD = "ISLOAD";//标记是否正在下载apk
}
