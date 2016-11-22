package com.sznews.www.isznews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sznews.www.isznews.model.News;

import java.util.List;

/**
 * Created by sznews on 2016/11/21.
 */

public class NewsAdapter extends BaseAdapter{
    private Context context;
    private List<News> newsList;


    public NewsAdapter(Context context, List<News> newsList){
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
           convertView = LayoutInflater.from(context).inflate(R.layout.news_item,null);
        }
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvDesc = (TextView) convertView.findViewById(R.id.tvDesc);
        TextView tvTime = (TextView) convertView.findViewById(R.id.tvTime);
        ImageView ivPic = (ImageView) convertView.findViewById(R.id.ivPic);

        News news = newsList.get(position);
        tvTitle.setText(news.getTitle());
        tvDesc.setText(news.getDesc());
        tvTime.setText(news.getTime());

        return convertView;
    }
}
