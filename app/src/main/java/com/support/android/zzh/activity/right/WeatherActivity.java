package com.support.android.zzh.activity.right;

import com.support.android.designlibdemo.R;
import com.support.android.designlibdemo.R.id;
import com.support.android.zzh.activity.BaseActivity;

import android.os.Bundle;
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
    }

    @Override
    public void initView() {
        iv_left_return = (ImageView) findViewById(id.iv_left_return);
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
