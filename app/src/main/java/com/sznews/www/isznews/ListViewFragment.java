package com.sznews.www.isznews;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.sznews.www.isznews.model.News;
import com.sznews.www.isznews.utils.HttpUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sznews on 2016/11/22.
 */

public class ListViewFragment extends Fragment{

    private ListView lvNews;
    private NewsAdapter newsAdapter;
    private Context context;
    private List<News> newsList = new ArrayList<News>();

    public static final String GET_NEWS_URL = "http://172.16.138.247/NewsDemo/getNewsJSON.php";

    private Handler getNewsHander = new Handler(){
        public void handleMessage(android.os.Message msg){
            String jsonData = (String) msg.obj;
            System.out.println(jsonData);
            try {
                JSONArray jsonArray = new JSONArray(jsonData);
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject object = jsonArray.getJSONObject(i);
                    String title = object.getString("title");
                    String desc = object.getString("desc");
                    String time = object.getString("time");
                    String content_url = object.getString("content_url");
                    String pic_url = object.getString("pic_url");
                    newsList.add(new News(title,desc,time,content_url,pic_url));
                }
                newsAdapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View listview = inflater.inflate(R.layout.newslist,null);

        lvNews =(ListView) listview.findViewById(R.id.lvNews);
        newsAdapter = new NewsAdapter(context,newsList);
        lvNews.setAdapter(newsAdapter);

//        HttpUtils.getNewsJSON(GET_NEWS_URL,getNewsHander);

        return listview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);

//        //这里建一个List用来存放News新闻类
//        final List list = new ArrayList<>();
//        //创建了个ListView变量用来获取layout中的ListView
//        ListView listView = (ListView) getView().findViewById(R.id.lvNews);
//        //建一个适配的变量，将上下文和list加载到ListVIew的适配器中，然后放到适配器变量里
////        MyListViewAdapter ma = new MyListViewAdapter(getActivity(),list);
//        //将适配器变量的内容加载到List里(也就是把那一堆新闻都放了进去)
////        listView.setAdapter(ma);
//        //获取Activity里传过来的捆绑数据
//        Bundle bundle = getArguments();

//        lvNews =(ListView) getActivity().findViewById(R.id.lvNews);
//
////        lvNews.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                System.out.println("getListView");
////                Toast.makeText(getActivity(),"getListView",Toast.LENGTH_LONG).show();
////            }
////        });
//
//        newsAdapter = new NewsAdapter(context,newsList);
//        lvNews.setAdapter(newsAdapter);
//
//        HttpUtils.getNewsJSON(GET_NEWS_URL,getNewsHander);
    }
}
