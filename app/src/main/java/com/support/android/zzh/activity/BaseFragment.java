package com.support.android.zzh.activity;

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
    /**
     * 上下文
     */
    private Context mcontext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mcontext = getActivity();
    }

}
