package com.example.administrator.multibox;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.control.CallBackResponseContent;
import com.example.administrator.control.CodeConstants;
import com.example.administrator.control.MyApplication;
import com.example.administrator.retrofit.api.LoadInterface;
import com.example.administrator.retrofit.config.RetrofitConst;
import com.example.administrator.retrofit.config.RetrofitUtils;
import com.example.administrator.util.ToastFactory;
import com.google.gson.JsonElement;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {


    Retrofit retrofit;
    private static RequestServes requestServes;
    Call<ResponseBody> call;

    public MyApplication application;

    private ImageView imageView;
    private Button btn_command;
    private Button btn_TV;
    private Button btn_live;
    private Button btn_service;

    public Button btn_test;
    public  View view;

    public ImageButton button1_live;
    public ImageButton button1_series;
    public ImageButton button1_film;
    public ImageButton button1_advertisement;
    public ImageButton button1_service;
    public ImageButton button1_free;

    public ImageButton button2_live;
    public ImageButton button2_revise;
    public ImageButton button2_adv1;
    public ImageButton button2_adv2;

    public ImageButton button3_film;
    public ImageButton button3_series;
    public ImageButton button3_cartoon;
    public ImageButton button3_newsreel;
    public ImageButton button3_adv1;
    public ImageButton button3_adv2;

    public ImageButton button4_adv1;
    public ImageButton button4_adv2;

    private List<View> lists = new ArrayList<View>();
    private MyAdapter myAdapter;
    private ViewPager viewPager;
    private Bitmap cursor;
    private int bmWidth;
    private int offSet;
    private Matrix matrix = new Matrix();
    private int currentItem;
    private Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        application = MyApplication.getMyApplication();
        btn_command = (Button)findViewById(R.id.btn_command);
        btn_TV = (Button)findViewById(R.id.btn_TV);
        btn_live=(Button)findViewById(R.id.btn_live);
        btn_service=(Button)findViewById(R.id.btn_service);

        view = getLayoutInflater().inflate(R.layout.layout1,null);

        lists.add(getLayoutInflater().inflate(R.layout.layout1, null));
        lists.add(getLayoutInflater().inflate(R.layout.layout2, null));
        lists.add(getLayoutInflater().inflate(R.layout.layout3, null));
        lists.add(getLayoutInflater().inflate(R.layout.layout4,null));

        myAdapter = new MyAdapter(lists){
            @Override
            public Object instantiateItem(ViewGroup view, int position){
              view.addView(viewLists.get(position));
                try {
                    LoadAdapter(position);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                InitButton(position);
                return viewLists.get(position);
            };
        };



        viewPager = (ViewPager) findViewById (R.id.viewPager);
        viewPager.setAdapter(myAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position){
                    case 0:
                        Toast.makeText(getApplicationContext(),"first page",Toast.LENGTH_SHORT).show();

                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"second page",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"third page",Toast.LENGTH_SHORT).show();
                        break;
                }
                currentItem = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btn_command.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        btn_TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        btn_live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });
        btn_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
            }
        });
    }
    public void InitButton(int position){
        switch (position){
            case 2:
                button3_film.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,ChoosePlay.class);
                        startActivity(intent);
                    }
                });
                break;
        }
    }


    @Override
    public  void onStart(){
        super.onStart();

         retrofit = new Retrofit.Builder()
                //.baseUrl("https://api.github.com/")
                 .baseUrl("http://192.168.88.2:25806/upnp/service/")
                .build();

         requestServes = retrofit.create(RequestServes.class);


    }

    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {
                case 11:
                    button1_live.setImageBitmap((Bitmap) msg.obj);
                    break;
                case 12:
                    button1_series.setImageBitmap((Bitmap) msg.obj);
                    break;
                case 13:
                    button1_film.setImageBitmap((Bitmap)msg.obj);
                    break;
            }

        };
    };
    public void LoadAdapter(int position) throws IOException {
        switch (position){
            case 0:
                button1_live = (ImageButton) findViewById(R.id.imageButton);
                button1_live.setImageDrawable(getResources().getDrawable(R.drawable.kyogre));
                getImageFromNet("http://120.202.127.36:21580/image/rollPhoto/","9287010.jpg",11);
                button1_live.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getFirstVideo();

                    }
                });

                button1_series = (ImageButton) findViewById(R.id.imageButton2);
                button1_series.setImageResource(R.drawable.comfey);
                getImageFromNet("http://120.202.127.36:21580/image/rollPhoto/","9287023.jpg",12);
                button1_series.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getProgramByFirstVideoId(true);
                    }
                });

                button1_film = (ImageButton) findViewById(R.id.imageButton3);
                button1_film.setImageResource(R.drawable.lugia);
                getImageFromNet("http://120.202.127.36:21580/image/poster/","8524.jpg",13);
                button1_film.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getFirstData();
                    }
                });


                button1_advertisement = (ImageButton) findViewById(R.id.imageButton4);
                button1_advertisement.setImageResource(R.drawable.victini);

                button1_service = (ImageButton)findViewById(R.id.imageButton5);
                button1_service.setImageResource(R.drawable.garchomp);

                button1_free = (ImageButton)findViewById(R.id.imageButton6);
                button1_free.setImageResource(R.drawable.xerneas);
                break;
            case 1:
                button2_live = (ImageButton)findViewById(R.id.imageButton_live);

                DisplayMetrics dm2 = getResources().getDisplayMetrics();
                ViewGroup.LayoutParams params = button2_live.getLayoutParams();
                Log.i("weidth height","weidth: " + params.width + "   height:  " + params.height);
                //params.width = dm2.heightPixels;
                //button2_live.setLayoutParams(params);
                button2_live.setImageResource(R.drawable.keldeoresolution);

                button2_revise = (ImageButton)findViewById(R.id.imageButton_revise);
                button2_revise.setImageResource(R.drawable.garchomp);

                Bitmap bitmap2 = BitmapFactory.decodeFile("http://120.202.127.36:21580/image/rollPhoto/9287010.jpg");
                Uri uri = Uri.fromFile(new File("http://120.202.127.36:21580/image/rollPhoto/9287010.jpg"));
                //Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), Uri.parse("http://120.202.127.36:21580/image/rollPhoto/9287010.jpg"));
                button2_revise.setImageBitmap(bitmap2);
                button2_revise.setImageURI(uri);

                button2_adv1 = (ImageButton)findViewById(R.id.imageButton_adv1);
                button2_adv1.setImageResource(R.drawable.victini);

                button2_adv2 = (ImageButton)findViewById(R.id.imageButton_adv2);
                button2_adv2.setImageResource(R.drawable.garchomp);
                break;
            case 2:
                button3_film = (ImageButton)findViewById(R.id.imageButton3_1);
                button3_film.setImageResource(R.drawable.keldeoresolution);

                button3_series = (ImageButton)findViewById(R.id.imageButton3_2);
                button3_series.setImageResource(R.drawable.hydreigon);

                button3_cartoon = (ImageButton)findViewById(R.id.imageButton3_3);
                button3_cartoon.setImageResource(R.drawable.comfey);

                button3_newsreel = (ImageButton)findViewById(R.id.imageButton3_4);
                button3_newsreel.setImageResource(R.drawable.cobalion);

                button3_adv1 = (ImageButton)findViewById(R.id.imageButton3_5);
                button3_adv1.setImageResource(R.drawable.xerneas);

                button3_adv2 = (ImageButton)findViewById(R.id.imageButton3_6);
                button3_adv2.setImageResource(R.drawable.salamence);
                break;
            case 3:

                button4_adv1 = (ImageButton)findViewById(R.id.imageButton4_1);
                button4_adv1.setImageResource(R.drawable.salamence);

                button4_adv2 = (ImageButton)findViewById(R.id.imageButton4_2);
                button4_adv2.setImageResource(R.drawable.garchomp);
                break;
        }

    }
    private void getProgramByFirstVideoId(boolean isShowDialog) {
        final String id = "20";
        Map<String, String> map = new HashMap<>();
        map.put("firstVideoId", id);//FieldMap类型，主要是可以一次请求多个参数；
        Log.d("Mainactivity", RetrofitConst.getInstance().getProgramByFirstVideoId());

        Log.d("Mainactivity", RetrofitConst.getInstance().getProgramByFirstVideoId());
        RetrofitUtils.getInstance().postData(application, RetrofitConst.getInstance().getProgramByFirstVideoId(), map, new CallBackResponseContent() {
            @Override
            public void getResponseContent(String result) {
                Log.d("Mainactivity", "getResponseContent: " + result);

                if (result == null || TextUtils.isEmpty(result)) {
                    //showError(getResources().getString(R.string.show_get_error));
                } else {
                    MyApplication.getMyApplication().setData(CodeConstants.COMM + id, result);
                    //setData(result);
                }
            }

            @Override
            public void getFailContent(String result) {
                /*Log.d(TAG, "getFailContent: " + result);
                result = MyApplication.getMyApplication().getData(CodeConstants.COMM + id);
                if (isRefresh) {
                    listView.stopRefresh();
                }
                if (result == null || TextUtils.isEmpty(result)) {
                    showError(getResources().getString(R.string.show_get_error));
                } else {
                    ToastFactory.getToast(activity, getResources().getString(R.string.toast_get_error)).show();
                    setData(result);
                }*/
            }
        }, isShowDialog);
    }

    private void getFirstData() {
        String Programid = "13414322";
        Map<String, String> map = new HashMap<>();
        map.put("programId", Programid);
//        map.put("appUserId", MyApplication.getMyApplication().getData(CodeConstants.APPUSERID));
        Call<JsonElement> call = RetrofitUtils.getInstance().postData(application, RetrofitConst.getInstance().getProgramByProgramIdFirst(), map,
                new CallBackResponseContent() {
                    @Override
                    public void getResponseContent(String result) {
                        Log.d("MainActivity", "getResponseContent: " + result);
                        //setData(result);
                    }

                    @Override
                    public void getFailContent(String result) {
                        Log.d("MainActivity", "getFailContent: " + result);
                        ToastFactory.getToast(application, getResources().getString(R.string.show_net_error)).show();
                    }
                }, true);
        //setCall(call);
    }
    private void getFirstVideo() {//获取网络数据
        Log.d("Mainactivity", "=============: " + RetrofitConst.getInstance().getFirstVideo());
        RetrofitUtils.getInstance().getData(getApplicationContext(), RetrofitConst.getInstance().getFirstVideo(), new CallBackResponseContent() {
            @Override
            public void getResponseContent(String result) {
                Log.d("Mainactivity", "getResponseContent: " + result);
                if (result == null || TextUtils.isEmpty(result)) {
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.show_get_error),Toast.LENGTH_SHORT).show();

                } else {
                    MyApplication.getMyApplication().setData(CodeConstants.FIRST_DATAS, result);
                    //Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                    ToastFactory.getToast(getApplicationContext(),result).show();
                    //setData(result);
                }
            }

            @Override
            public void getFailContent(String result) {
                Log.d("Mainactivity", "getFailContent: " + result);
                result = MyApplication.getMyApplication().getData(CodeConstants.FIRST_DATAS);
                if (result == null || TextUtils.isEmpty(result)) {
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.show_get_error),Toast.LENGTH_SHORT).show();
                } else {
                    ToastFactory.getToast(getApplicationContext(), getResources().getString(R.string.toast_get_error)).show();
                    //setData(result);
                }
            }
        });
    }

    private Bitmap getImageFromNet(String string,String picId, final Integer ID){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(string)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //添加Rxjava
                .addConverterFactory(GsonConverterFactory.create()) // <span style="font-family: Arial, Helvetica, sans-serif;">定义转化器 可以将结果返回一个json格式</span>
                .build();

        LoadInterface serviceApi = retrofit.create(LoadInterface.class);

        Call<ResponseBody> call = serviceApi.downloadPicFromNet(picId);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                InputStream is = response.body().byteStream();
                Bitmap bitmap = BitmapFactory.decodeStream(is);

                Message msg = new Message();
                // 把bm存入消息中,发送到主线程
                msg.obj = bitmap;
                msg.what = ID;
                handler.sendMessage(msg);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Log.d("what?","what?");
            }
        });
        return  null;

    }

}
