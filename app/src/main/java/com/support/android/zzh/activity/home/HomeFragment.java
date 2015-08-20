package com.support.android.zzh.activity.home;

import com.support.android.designlibdemo.R;
import com.support.android.zzh.activity.BaseFragment;
import com.support.android.zzh.adapter.HomeAdapter;
import com.support.android.zzh.bean.JokeBean;
import com.support.android.zzh.bean.JokeBean.JokeBeanInfo;
import com.thinkland.sdk.android.DataCallBack;
import com.thinkland.sdk.android.JuheData;
import com.thinkland.sdk.android.Parameters;

import org.json.JSONException;

import java.util.List;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Project Name:com.support.android.designlibdemo.activity.home
 * File Name: cheesesquare
 * Date:15/8/12上午10:2308
 * blog:http://blog.csdn.net/qq718799510?viewmode=contents
 * Copyright (c) 2015, zhuxiaohao All Rights Reserved.
 * 首页
 */
public class HomeFragment extends BaseFragment {
    private RecyclerView rv;
    private HomeAdapter madapter;

    private List<JokeBeanInfo> list = new java.util.ArrayList<JokeBeanInfo>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        madapter = new HomeAdapter(mContext);
        recyclerView.setAdapter(madapter);
    }
    /**
     * 获取请求数据
     */
    private void update() {
        final Parameters params = new Parameters();
        params.add("page", page);
        params.add("pagesize", pagesize);
        JuheData.executeWithAPI(mContext, 95, "http://japi.juhe.cn/joke/content/text.from",
                JuheData.GET, params, new DataCallBack() {
                    @Override
                    public void onSuccess(int statusCode, String responseString) {
                        // TODO Auto-generated method stub
                        try {
                            list = JokeBean.parse(responseString);
                            madapter = new HomeAdapter(mContext);
                            rv.setAdapter(madapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onFinish() {
                        // TODO Auto-generated method stub
                        Toast.makeText(mContext, "finish", Toast.LENGTH_SHORT).show();

                    }
                    @Override
                    public void onFailure(int statusCode, String responseString, Throwable throwable) {
                        // TODO Auto-generated method stub
                    }
                });

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        JuheData.cancelRequests(mContext);
    }
}
