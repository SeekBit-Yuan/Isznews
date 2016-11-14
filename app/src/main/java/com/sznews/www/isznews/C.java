package com.sznews.www.isznews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuan on 2016/10/25.
 */
public class C extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

//    private String[] titles = new String[]{"推荐","南山","福田","龙岗","罗湖","盐田","大鹏","宝安"};

    public static NewsFragment newInstance(String param1) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1,param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment,null);
        TextView content = (TextView) view.findViewById(R.id.fg_tv);
        content.setText(mParam1);

//        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
//        List<Fragment> fragments = new ArrayList<Fragment>();
//        for (int i = 0; i < titles.length; i++) {
//            fragments.add(NewsFragment.newInstance(titles[i]));
//        }
//        FragmentPagerAdapter adapter = new MyFragmentAdapter(fragments, titles, getChildFragmentManager());
//        viewPager.setAdapter(adapter);
//        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
//        tabLayout.setupWithViewPager(viewPager);


        return inflater.inflate(R.layout.news, container, false);
    }
}
