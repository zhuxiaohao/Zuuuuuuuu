package com.support.android.zzh.adapter;

import com.support.android.zzh.CheeseDetailActivity;
import com.support.android.designlibdemo.R;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
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

    public JokeAdapter(Context context) {
        this.mcontext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = android.view.LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_home_joke_list_item,
                viewGroup, false);
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
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mimageView;
        private final TextView mtextView;
        private final View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            mimageView = (ImageView) itemView.findViewById(R.id.avatar);
            mtextView = (TextView) itemView.findViewById(R.id.text1);
        }

    }
}
