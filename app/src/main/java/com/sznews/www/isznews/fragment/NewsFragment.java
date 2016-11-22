package com.sznews.www.isznews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sznews.www.isznews.ListViewFragment;
import com.sznews.www.isznews.R;
import com.sznews.www.isznews.adapter.MyFragmentAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Yuan on 2016/10/25.
 */
public class NewsFragment extends Fragment {

    private String[] titles = new String[]{"推荐","南山","福田","龙岗","罗湖","盐田","大鹏","宝安"};

//    private ListView lvNews;
//    private NewsAdapter newsAdapter;
//    private Context context;
//    private List<News> newsList;
//
//    public static final String GET_NEWS_URL = "http://172.16.138.247/NewsDemo/getNewsJSON.php";
//    private Handler getNewsHander = new Handler(){
//        public void handleMessage(android.os.Message msg){
//            String jsonData = (String) msg.obj;
//            System.out.println(jsonData);
//            try {
//                JSONArray jsonArray = new JSONArray(jsonData);
//                for(int i=0;i<jsonArray.length();i++){
//                    JSONObject object = jsonArray.getJSONObject(i);
//                    String title = object.getString("title");
//                    String desc = object.getString("desc");
//                    String time = object.getString("time");
//                    String content_url = object.getString("content_url");
//                    String pic_url = object.getString("pic_url");
//                    newsList.add(new News(title,desc,time,content_url,pic_url));
//                }
//                newsAdapter.notifyDataSetChanged();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        };
//    };

//
//    @Override
//    public void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news, null);

//        View listview = inflater.inflate(R.layout.newslist,null);
//        lvNews =(ListView) listview.findViewById(R.id.lvNews);
//        newsList = new ArrayList<News>();
//
//        newsAdapter = new NewsAdapter(context,newsList);
//        lvNews.setAdapter(newsAdapter);
//
//        HttpUtils.getNewsJSON(GET_NEWS_URL,getNewsHander);

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
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        for(int i=0;i<titles.length;i++){
            Fragment fragment = new ListViewFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("arg",i);
            fragment.setArguments(bundle);
            fragmentList.add(fragment);
//            fragmentList.add(CategoryTabStrip.newInstance(titles[i]));
        }

        FragmentPagerAdapter adapter = new MyFragmentAdapter(fragmentList,titles,getChildFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
