package com.example.administrator.multibox;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */

public class MyAdapter extends PagerAdapter {

    List<View> viewLists;
    public MyAdapter(List<View> lists){
        viewLists = lists;
    }
    @Override
    public int getCount() {
        return viewLists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    @Override
    public void destroyItem(ViewGroup view, int position, Object object)                       //销毁Item
    {
        view.removeView(viewLists.get(position));
    }
    @Override
    public Object instantiateItem(ViewGroup view, int position)                                //实例化Item
    {

        view.addView(viewLists.get(position));

        return viewLists.get(position);
    }
}
