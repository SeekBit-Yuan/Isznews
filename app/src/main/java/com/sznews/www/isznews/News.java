package com.sznews.www.isznews;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 一丝不狗 on 2016/11/14.
 */

public class News extends Activity{
    private Button button1;

    private String[] titles = new String[]{"聊天", "好友", "发现", "我的","聊天", "好友", "发现", "我的","聊天", "好友", "发现", "我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        System.out.println("aaa");
        button1=(Button)this.findViewById(R.id.test);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("news");
                Toast.makeText(News.this,"news",Toast.LENGTH_SHORT).show();
            }
        });
        Toast.makeText(News.this,"测试2",Toast.LENGTH_SHORT).show();
        /*ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        List<Fragment> fragments = new ArrayList<Fragment>();
        for (int i = 0; i < titles.length; i++) {
            fragments.add(NewsFragment.newInstance(titles[i]));
        }
            FragmentPagerAdapter adapter = new MyFragmentAdapter(fragments, titles, getSupportFragmentManager(),this);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);*/
    }

}
