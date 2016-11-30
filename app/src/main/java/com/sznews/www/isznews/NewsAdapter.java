package com.sznews.www.isznews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sznews.www.isznews.model.News;
import com.sznews.www.isznews.utils.HttpUtils;

import java.util.List;

/**
 * Created by sznews on 2016/11/21.
 */

public class NewsAdapter extends BaseAdapter {
    private Context context;
    private List<News> newsList;


    public NewsAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }


    //控制该adapter包含列表项的个数
    @Override
    public int getCount() {
        return newsList.size();
    }

    //决定第position处的列表项内容
    @Override
    public Object getItem(int position) {
        return newsList.get(position);
    }

    //决定第position处的列表项ID
    @Override
    public long getItemId(int position) {
        return position;
    }

    //决定第position处的列表项组件
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
//        if(convertView == null){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.news_item, null);

        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                News news = newsList.get(position);
                Intent intent = new Intent(context,NewsActivity.class);
                intent.putExtra("content_url",news.getContent_url());
                context.startActivity(intent);
            }
        });

        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        TextView tvDesc = (TextView) view.findViewById(R.id.tvDesc);
        TextView tvTime = (TextView) view.findViewById(R.id.tvTime);
        ImageView ivPic = (ImageView) view.findViewById(R.id.ivPic);

        News news = newsList.get(position);
        tvTitle.setText(news.getTitle());
        tvDesc.setText(news.getDesc());
        tvTime.setText(news.getTime());

        String pic_url = news.getPic_url();
        HttpUtils.setPicBitmap(ivPic,pic_url);
        return view;
    }
}
