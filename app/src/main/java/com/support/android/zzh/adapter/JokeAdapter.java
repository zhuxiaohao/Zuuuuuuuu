package com.support.android.zzh.adapter;

import com.support.android.designlibdemo.R;
import com.support.android.zzh.CheeseDetailActivity;
import com.support.android.zzh.bean.JokeBean.JokeBeanInfo;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Project Name:com.support.android.designlibdemo.adapter
 * File Name: cheesesquare
 * Date:15/8/12下午2:2508
 * blog:http://blog.csdn.net/qq718799510?viewmode=contents
 * Copyright (c) 2015, zhuxiaohao All Rights Reserved.
 */
public class JokeAdapter extends Adapter<JokeAdapter.ViewHolder> {

    private Context mcontext;
    private List<JokeBeanInfo> mlist;

    public JokeAdapter(Context context, List<JokeBeanInfo> list) {
        this.mcontext = context;
        this.mlist = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_home_joke_list_item, viewGroup, false);
        return new JokeAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, CheeseDetailActivity.class);
                intent.putExtra(CheeseDetailActivity.EXTRA_NAME, "test");
                context.startActivity(intent);
            }
        });
        JokeBeanInfo jokeBean = mlist.get(i);
        if (jokeBean != null) {
            viewHolder.txt_joke_content.setText(jokeBean.getContent());
            viewHolder.txt_joke_time.setText(jokeBean.getUnixtime());
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView txt_joke_content;
        private final TextView txt_joke_time;
        private final View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            txt_joke_content = (TextView) itemView.findViewById(R.id.txt_joke_content);
            txt_joke_time = (TextView) itemView.findViewById(R.id.txt_joke_time);

        }

    }
}
