package com.sznews.www.isznews;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by sznews on 2016/11/21.
 */

public class NewsAdapter extends BaseAdapter{
    private Context context;

    public NewsAdapter(Context context){
        this.context = context;
    }

//    ArrayList<NewsEntity> newsList;
//    Activity activity;
//    LayoutInflater inflater = null;

    //控制该adapter包含列表项的个数
    @Override
    public int getCount() {
        return 0;
    }

    //决定第position处的列表项内容
    @Override
    public Object getItem(int position) {
//        if (newsList != null && newsList.size() != 0) {
//            return newsList.get(position);
//        }
        return null;
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

        return convertView;
    }
}
