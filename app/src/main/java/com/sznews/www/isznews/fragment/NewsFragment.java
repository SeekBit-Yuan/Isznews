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

    private String[] titles = new String[]{"推荐","福田","南山","龙岗","罗湖","盐田","大鹏","光明"};

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news, null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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
