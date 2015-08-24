package com.support.android.zzh.activity.right;

import com.support.android.designlibdemo.R;
import com.support.android.designlibdemo.R.id;
import com.support.android.zzh.activity.BaseActivity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

/**
 * Project Name:com.support.android.zzh.activity.rightbar
 * File Name: Zuuuuuuuu
 * Date:15/8/14上午10:1608
 * blog:http://blog.csdn.net/qq718799510?viewmode=contents
 * Copyright (c) 2015, zhuxiaohao All Rights Reserved.
 */
public class WeatherActivity extends BaseActivity implements OnClickListener {


    private ImageView iv_left_return;
    SwipeRefreshLayout swiperrefreshlayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home_right_tab_weather);
        initView();
        initListener();
        initDate();


    }

    @Override
    public void initDate() {
    }

    @Override
    public void initListener() {
        iv_left_return.setOnClickListener(this);
        swiperrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                // TODO Auto-generated method stub
                new android.os.Handler().postDelayed(new Runnable() {
                    public void run() {
                        swiperrefreshlayout.setRefreshing(false);

                    }
                }, 5000);
            }
        });

    }

    @Override
    public void initView() {
        iv_left_return = (ImageView) findViewById(id.iv_left_return);
        swiperrefreshlayout=(SwipeRefreshLayout)findViewById(R.id.swiperrefreshlayout);
        swiperrefreshlayout.setColorScheme(android.R.color.holo_red_light, android.R.color.holo_green_light,
                android.R.color.holo_blue_bright, android.R.color.holo_orange_light);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case id.iv_left_return:
                finish();
                break;
        }
    }
}
