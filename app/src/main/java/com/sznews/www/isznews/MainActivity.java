package com.sznews.www.isznews;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity{

    private LinearLayout news;
    private LinearLayout video;
    private LinearLayout user;

    private ImageView iv_news;
    private ImageView iv_video;
    private ImageView iv_user;

    private TextView tv_news;
    private TextView tv_video;
    private TextView tv_user;

    private Fragment newsFragment;
    private Fragment videoFragment;
    private Fragment userFragment;

    private RadioButton radio_news;
    private RadioButton radio_video;
    private RadioButton radio_user;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化控件
        initView();
        // 初始化底部按钮事件
//        initEvent();
        // 初始化并设置当前Fragment
//        initFragment(0);

        fragmentManager = getSupportFragmentManager();
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        ((RadioButton)radioGroup.findViewById(R.id.radio_news)).setChecked(true);
        //开启事务
        transaction = fragmentManager.beginTransaction();
        Fragment mfragment = new NewsFragment();
        transaction.replace(R.id.Framegment,mfragment);
        //提交事务
        transaction.commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_news:
                        transaction = fragmentManager.beginTransaction();
                        Fragment newsFragment = new NewsFragment();
                        transaction.replace(R.id.Framegment, newsFragment);
                        transaction.commit();
                        break;
                    case R.id.radio_video:
                        transaction = fragmentManager.beginTransaction();
                        Fragment videoFragment = new VideoFragment();
                        transaction.replace(R.id.Framegment, videoFragment);
                        transaction.commit();
                        break;
                    case R.id.radio_user:
                        transaction = fragmentManager.beginTransaction();
                        Fragment userFragment = new UserFragment();
                        transaction.replace(R.id.Framegment, userFragment);
                        transaction.commit();
                        break;
                }

            }
        });

    }

//    private void initFragment(int index) {
//        fragmentManager = getSupportFragmentManager();
//        //开启事务
//        transaction = fragmentManager.beginTransaction();
//        Fragment fragment = new NewsFragment();
//        transaction.replace(R.id.Framegment,fragment);
//        //提交事务
//        transaction.commit();
//
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case R.id.radio_news:
//                        transaction = fragmentManager.beginTransaction();
//                        Fragment homeFragment = new NewsFragment();
//                        transaction.replace(R.id.Framegment, homeFragment);
//                        transaction.commit();
//                        break;
//                    case R.id.radio_video:
//                        transaction = fragmentManager.beginTransaction();
//                        Fragment sortFragment = new VideoFragment();
//                        transaction.replace(R.id.Framegment, sortFragment);
//                        transaction.commit();
//                        break;
//                    case R.id.radio_user:
//                        transaction = fragmentManager.beginTransaction();
//                        Fragment personFragment = new UserFragment();
//                        transaction.replace(R.id.Framegment, personFragment);
//                        transaction.commit();
//                        break;
//                }
//
//            }
//        });
//    }
        //隐藏所有的Fragment
//        hideFragment(transaction);
//        switch (index) {
//            case 0:
//                if (newsFragment == null) {
//                    newsFragment = new NewsFragment();
//                    transaction.add(R.id.Framegment, newsFragment);
//                } else {
//                    transaction.show(newsFragment);
//                }
//                break;
//            case 1:
//                if (videoFragment == null) {
//                    videoFragment = new VideoFragment();
//                    transaction.add(R.id.Framegment, videoFragment);
//                } else {
//                    transaction.show(videoFragment);
//                }
//                break;
//            case 2:
//                if (userFragment == null) {
//                    userFragment = new UserFragment();
//                    transaction.add(R.id.Framegment, userFragment);
//                } else {
//                    transaction.show(userFragment);
//                }
//                break;
//
//            default:
//                break;
//        }
//
//    }

    //隐藏Fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (videoFragment != null) {
            transaction.hide(videoFragment);
        }
        if (userFragment != null) {
            transaction.hide(userFragment);
        }
    }

    private void initView() {
        news = (LinearLayout) findViewById(R.id.tool_bar2_news);
        video = (LinearLayout) findViewById(R.id.tool_bar2_video);
        user = (LinearLayout) findViewById(R.id.tool_bar2_user);

        iv_news = (ImageView) findViewById(R.id.imageView_news);
        iv_video = (ImageView) findViewById(R.id.imageView_video);
        iv_user = (ImageView) findViewById(R.id.imageView_user);

        tv_news = (TextView) findViewById(R.id.text_news);
        tv_video = (TextView) findViewById(R.id.text_video);
        tv_user = (TextView) findViewById(R.id.text_user);

        radio_news = (RadioButton) findViewById(R.id.radio_news);
        radio_video = (RadioButton) findViewById(R.id.radio_video);
        radio_user = (RadioButton) findViewById(R.id.radio_user);

}

//    private void initEvent() {
//        news.setOnClickListener(this);
//        video.setOnClickListener(this);
//        user.setOnClickListener(this);
//    }


//    @Override
//    public void onClick(View v) {
//        //在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为绿色，然后根据点击着色
//        restartBotton();
//        // ImageView和TetxView置为绿色，页面随之跳转
//        switch (v.getId()) {
//            case R.id.tool_bar2_news:
//                iv_news.setImageResource(R.mipmap.ic_news1);
//                tv_news.setTextColor(ContextCompat.getColor(this, R.color.theme));
//                initFragment(0);
//                System.out.println("view1");
//                break;
//            case R.id.tool_bar2_video:
//                iv_video.setImageResource(R.mipmap.ic_movie1);
//                tv_video.setTextColor(ContextCompat.getColor(this, R.color.theme));
//                initFragment(1);
//                break;
//            case R.id.tool_bar2_user:
//                iv_user.setImageResource(R.mipmap.ic_user1);
//                tv_user.setTextColor(ContextCompat.getColor(this, R.color.theme));
//                initFragment(2);
//                break;
//
//            default:
//                break;
//        }
//    }
//
//    private void restartBotton() {
//        iv_news.setImageResource(R.mipmap.ic_news);
//        iv_video.setImageResource(R.mipmap.ic_movie);
//        iv_user.setImageResource(R.mipmap.ic_user);
//
//        tv_news.setTextColor(ContextCompat.getColor(this, R.color.text0));
//        tv_video.setTextColor(ContextCompat.getColor(this, R.color.text0));
//        tv_user.setTextColor(ContextCompat.getColor(this, R.color.text0));
//    }


}
