package com.sznews.www.isznews;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sznews.www.isznews.utils.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Yuan on 2016/10/25.
 */
public class NewsFragment extends Fragment {

    private String[] titles = new String[]{"推荐","南山","福田","龙岗","罗湖","盐田","大鹏","宝安"};

    private ListView lvNews;
    private NewsAdapter newsAdapter;
    private Context context;

    public static final String GET_NEWS_URL = "http://172.30.66.203/NewsDemo/getNewsJSON.php";
    private Handler getNewsHander = new Handler(){
        public void handleMessage(Message msg){
            String jsonData = (String) msg.obj;
            System.out.println(jsonData);
        };
    };

//
//    @Override
//    public void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news, null);

        View listview = inflater.inflate(R.layout.newslist,null);
        lvNews =(ListView) listview.findViewById(R.id.lvNews);
        newsAdapter = new NewsAdapter(context);
        lvNews.setAdapter(newsAdapter);

        HttpUtils.getNewsJSON(GET_NEWS_URL,getNewsHander);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Button button=(Button) getActivity().findViewById(R.id.test);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("NewsFragment");
//                Toast.makeText(getActivity(),"getNews",Toast.LENGTH_SHORT).show();
//            }
//        });
        ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.viewPager);
        List<Fragment> fragments = new ArrayList<Fragment>();
        for(int i=0;i<titles.length;i++){
            fragments.add(CategoryTabStrip.newInstance(titles[i]));
        }
        FragmentPagerAdapter adapter = new MyFragmentAdapter(fragments,titles,getChildFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
