package com.support.android.zzh.adapter;

import com.support.android.designlibdemo.R;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.support.android.designlibdemo.R.id;

/**
 * Project Name:com.support.android.designlibdemo.adapter
 * File Name: cheesesquare
 * Date:15/8/13下午2:4008
 * blog:http://blog.csdn.net/qq718799510?viewmode=contents
 * Copyright (c) 2015, zhuxiaohao All Rights Reserved.
 */
public class NewsAdapter extends Adapter<NewsAdapter.ViewHolder> {

    public NewsAdapter(Context context) {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_home_news_list_item, viewGroup, false);
        return new NewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, com.support.android.zzh.CheeseDetailActivity.class);
                intent.putExtra(com.support.android.zzh.CheeseDetailActivity.EXTRA_NAME, "test");
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 50;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final CircleImageView mimageView;
        private final TextView mtextView;
        private final View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            mimageView = (CircleImageView) itemView.findViewById(id.avatar);
            mtextView = (TextView) itemView.findViewById(id.text1);
        }
    }
}
