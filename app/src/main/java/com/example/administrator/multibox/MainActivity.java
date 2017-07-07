package com.example.administrator.multibox;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
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
import com.example.administrator.retrofit.config.RetrofitConst;
import com.example.administrator.retrofit.config.RetrofitUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    private static RequestServes requestServes;
    Call<ResponseBody> call;


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
                LoadAdapter(position);
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
    public void LoadAdapter(int position){
        switch (position){
            case 0:
                button1_live = (ImageButton) findViewById(R.id.imageButton);
                button1_live.setImageDrawable(getResources().getDrawable(R.drawable.kyogre));

                button1_live.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("main on click test", "=============: " + RetrofitConst.getInstance().getFirstVideo());
                        RetrofitUtils.getInstance().getData(getApplicationContext(), RetrofitConst.getInstance().getFirstVideo(), new CallBackResponseContent() {
                            @Override
                            public void getResponseContent(String result) {
                                Log.d("test Response", "getResponseContent: " + result);
                                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void getFailContent(String result) {

                            }
                        });

                    }
                });

                button1_series = (ImageButton) findViewById(R.id.imageButton2);
                button1_series.setImageResource(R.drawable.comfey);

                button1_film = (ImageButton) findViewById(R.id.imageButton3);
                button1_film.setImageResource(R.drawable.lugia);

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
}
