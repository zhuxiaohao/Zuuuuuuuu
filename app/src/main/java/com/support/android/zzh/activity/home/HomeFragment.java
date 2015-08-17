package com.support.android.zzh.activity.home;

import com.support.android.designlibdemo.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Project Name:com.support.android.designlibdemo.activity.home
 * File Name: cheesesquare
 * Date:15/8/12上午10:2308
 * blog:http://blog.csdn.net/qq718799510?viewmode=contents
 * Copyright (c) 2015, zhuxiaohao All Rights Reserved.
 * 首页
 */
public class HomeFragment extends com.support.android.zzh.activity.BaseFragment {
    private RecyclerView rv;
    private com.support.android.zzh.adapter.HomeAdapter madapter;
    private Context context;

    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @android.support.annotation.Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rv = (RecyclerView) inflater.inflate(R.layout.layout_home_frist, container, false);
        setupRecyclerView(rv);
        return rv;
    }

    //设置适配器
    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        madapter = new com.support.android.zzh.adapter.HomeAdapter(context);
        recyclerView.setAdapter(madapter);
    }
}
