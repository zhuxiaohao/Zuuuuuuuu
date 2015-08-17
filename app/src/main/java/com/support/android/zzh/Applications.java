package com.support.android.zzh;

import com.thinkland.sdk.android.JuheSDKInitializer;

import android.app.Application;

/**
 * Project Name:com.support.android.designlibdemo
 * File Name: Zuuuuuuuu
 * Date:15/8/13下午5:2208
 * blog:http://blog.csdn.net/qq718799510?viewmode=contents
 * Copyright (c) 2015, zhuxiaohao All Rights Reserved.
 */
public class Applications extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化 聚合数据SDK.用SDK 的话这样能省去好多东西
        JuheSDKInitializer.initialize(getApplicationContext());
    }
}
