package com.support.android.zzh.adapter;

import com.support.android.designlibdemo.R;
import com.support.android.designlibdemo.R.layout;
import com.support.android.zzh.CheeseDetailActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Project Name:com.support.android.designlibdemo.adapter
 * File Name: cheesesquare
 * Date:15/8/12上午10:5108
 * blog:http://blog.csdn.net/qq718799510?viewmode=contents
 * Copyright (c) 2015, zhuxiaohao All Rights Reserved.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {


    public HomeAdapter(Context context) {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layout.layout_home_frist_list_item, viewGroup, false);
        return new HomeAdapter.ViewHolder(view);
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
    }

    @Override
    public int getItemCount() {
        return 50;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mimageView;
        private final TextView mtextView;
        private final View view;

        /**
         * item view
         *
         * @param itemView
         */
        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            mimageView = (ImageView) itemView.findViewById(R.id.avatar);
            mtextView = (TextView) itemView.findViewById(R.id.text1);
        }
    }
}
