package com.support.android.zzh.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Project Name:com.support.android.designlibdemo.activity
 * File Name: cheesesquare
 * Date:15/8/13下午3:2408
 * blog:http://blog.csdn.net/qq718799510?viewmode=contents
 * Copyright (c) 2015, zhuxiaohao All Rights Reserved.
 */
public class BaseActivity extends AppCompatActivity {
    private final String TAG = BaseActivity.class.getCanonicalName();
    public Context mcontext;

    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mcontext = this;
    }

    /**
     * 省去 findviewbyid
     *
     * @param viewId
     * @param <T>
     *
     * @return
     */
    public <T> T $(int viewId) {
        return (T) findViewById(viewId);
    }

    public void initView() {

    }

    public void initListener() {

    }


    public void initDate() {

    }
}
