package com.support.android.zzh.activity.home;

import com.support.android.designlibdemo.R;
import com.support.android.zzh.activity.BaseFragment;
import com.support.android.zzh.adapter.JokeAdapter;
import com.support.android.zzh.bean.JokeBean;
import com.support.android.zzh.bean.JokeBean.JokeBeanInfo;
import com.thinkland.sdk.android.DataCallBack;
import com.thinkland.sdk.android.JuheData;
import com.thinkland.sdk.android.Parameters;

import java.util.Date;
import java.util.List;

import android.content.Context;
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
 * Date:15/8/12上午10:2508
 * blog:http://blog.csdn.net/qq718799510?viewmode=contents
 * Copyright (c) 2015, zhuxiaohao All Rights Reserved.
 * 笑话
 */
public class JokeFragment extends BaseFragment {
    private RecyclerView rv;
    private JokeAdapter madapter;
    private Context mContext;
    private List<JokeBeanInfo> list=new java.util.ArrayList<JokeBeanInfo>();
    private int page = 1;
    private int pagesize = 20;
    private String key;

    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

    }

    @android.support.annotation.Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rv = (RecyclerView) inflater.inflate(R.layout.layout_home_joke, container, false);
        update();
        setupRecyclerView(rv);
//       updatePhone();
        return rv;
    }

    //设置适配器
    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        madapter = new JokeAdapter(mContext, list);
        recyclerView.setAdapter(madapter);
    }

    /**
     * 获取请求数据
     */
    private void update() {

        Date date = new Date();
        long time = date.getTime();
        String dateline = time + "";
        dateline = dateline.substring(0, 10);
        /**
         * 请不要添加key参数.
         */
        final Parameters params = new Parameters();
        params.add("sort", "");
        params.add("page", page);
        params.add("pagesize", pagesize);
        params.add("time", 1418816972);
        /**
         * 请求的方法 参数: 第一个参数 当前请求的context;
         * 				  第二个参数 接口id;
         * 				  第三个参数 接口请求的url;
         * 				  第四个参数 接口请求的方式;
         * 				  第五个参数 接口请求的参数,键值对com.thinkland.sdk.android.Parameters类型;
         * 				  第六个参数请求的回调方法,com.thinkland.sdk.android.DataCallBack;
         *
         */
        JuheData.executeWithAPI(mContext, 95, "http://japi.juhe.cn/joke/content/list.from",
                JuheData.GET, params, new DataCallBack() {
                    /**
                     * 请求成功时调用的方法 statusCode为http状态码,responseString为请求返回数据.
                     */
                    @Override
                    public void onSuccess(int statusCode, String responseString) {
                        // TODO Auto-generated method stub
                        try {
                            list = JokeBean.parse(responseString);
                            madapter = new JokeAdapter(mContext, list);
                            rv.setAdapter(madapter);
                        } catch (org.json.JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    /**
                     * 请求完成时调用的方法,无论成功或者失败都会调用.
                     */
                    @Override
                    public void onFinish() {
                        // TODO Auto-generated method stub
                        Toast.makeText(mContext, "finish", Toast.LENGTH_SHORT).show();

                    }

                    /**
                     * 请求失败时调用的方法,statusCode为http状态码,throwable为捕获到的异常
                     * statusCode:30002 没有检测到当前网络.
                     * 			  30003 没有进行初始化.
                     * 			  0 未明异常,具体查看Throwable信息.
                     * 			  其他异常请参照http状态码.
                     */
                    @Override
                    public void onFailure(int statusCode, String responseString, Throwable throwable) {
                        // TODO Auto-generated method stub
//                      tv.append(throwable.getMessage() + "\n");
                    }
                });

    }

    /**
     * 单个对象
     */
    private void updatePhone() {
        final Parameters params = new Parameters();
        params.add("phone", "13477030046");
        params.add("dtype", "json");
        JuheData.executeWithAPI(mContext, 11, "http://apis.juhe.cn/mobile/get",
                JuheData.GET, params, new DataCallBack() {
                    /**
                     * 请求成功时调用的方法 statusCode为http状态码,responseString为请求返回数据.
                     */
                    @Override
                    public void onSuccess(int statusCode, String responseString) {
                        // TODO Auto-generated method stub
                        System.out.print("params==" + params.toString());
                        try {
                            JokeBean.parse(responseString);
                        } catch (org.json.JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    /**
                     * 请求完成时调用的方法,无论成功或者失败都会调用.
                     */
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

}
