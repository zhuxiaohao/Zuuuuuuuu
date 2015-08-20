package com.support.android.zzh.activity;

import java.util.Date;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Project Name:com.support.android.designlibdemo.activity.home
 * File Name: cheesesquare
 * Date:15/8/12上午10:2608
 * blog:http://blog.csdn.net/qq718799510?viewmode=contents
 * Copyright (c) 2015, zhuxiaohao All Rights Reserved.
 */
public class BaseFragment extends Fragment {

    public static int page = 1;
    public static int pagesize = 20;
    public static Context mContext;
    public static  Date date = new Date();
    public static long time = date.getTime();
    public static String dateline = time + "";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
        dateline = dateline.substring(0, 10);
    }

}
