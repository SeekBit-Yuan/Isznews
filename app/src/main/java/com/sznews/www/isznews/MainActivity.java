package com.sznews.www.isznews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends FragmentActivity implements View.OnClickListener {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化控件
        initView();
        // 初始化底部按钮事件
        initEvent();
        // 初始化并设置当前Fragment
        initFragment(0);
    }

    private void initFragment(int index) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //隐藏所有的Fragment
        hideFragment(transaction);
        switch (index) {
            case 0:
                if (newsFragment == null) {
                    newsFragment = new NewsFragment();
                    transaction.add(R.id.Framegment, newsFragment);
                } else {
                    transaction.show(newsFragment);
                }
                break;
            case 1:
                if (videoFragment == null) {
                    videoFragment = new VideoFragment();
                    transaction.add(R.id.Framegment, videoFragment);
                } else {
                    transaction.show(videoFragment);
                }
                break;
            case 2:
                if (userFragment == null) {
                    userFragment = new UserFragment();
                    transaction.add(R.id.Framegment, userFragment);
                } else {
                    transaction.show(userFragment);
                }
                break;

            default:
                break;
        }
        //提交事务
        transaction.commit();
    }

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

    }

    private void initEvent() {
        news.setOnClickListener(this);
        video.setOnClickListener(this);
        user.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
        restartBotton();
        // ImageView和TetxView置为绿色，页面随之跳转
        switch (v.getId()) {
            case R.id.tool_bar2_news:
                iv_news.setImageResource(R.mipmap.ic_news1);
                tv_news.setTextColor(ContextCompat.getColor(this, R.color.theme));
                initFragment(0);
                break;
            case R.id.tool_bar2_video:
                iv_video.setImageResource(R.mipmap.ic_movie1);
                tv_video.setTextColor(ContextCompat.getColor(this, R.color.theme));
                initFragment(1);
                break;
            case R.id.tool_bar2_user:
                iv_user.setImageResource(R.mipmap.ic_user1);
                tv_user.setTextColor(ContextCompat.getColor(this, R.color.theme));
                initFragment(2);
                break;

            default:
                break;
        }
    }

    private void restartBotton() {
        iv_news.setImageResource(R.mipmap.ic_news);
        iv_video.setImageResource(R.mipmap.ic_movie);
        iv_user.setImageResource(R.mipmap.ic_user);

        tv_news.setTextColor(ContextCompat.getColor(this, R.color.text0));
        tv_video.setTextColor(ContextCompat.getColor(this, R.color.text0));
        tv_user.setTextColor(ContextCompat.getColor(this, R.color.text0));
    }
}
