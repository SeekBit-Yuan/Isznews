package com.sznews.www.isznews;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;


/**
 * Created by sznews on 2016/11/24.
 */

public class NewsActivity extends Activity{

    private ImageView news_back;
    private WebView webView;
    private ImageView news_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsactivity);
        ShareSDK.initSDK(getApplicationContext());

        news_back = (ImageView) findViewById(R.id.news_back);
        news_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        news_share = (ImageView) findViewById(R.id.news_share);
        news_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });

        webView = (WebView) findViewById(R.id.newsavtivity_webview);

        String pic_url = getIntent().getStringExtra("content_url");

        webView.loadUrl(pic_url);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.getSettings().setSupportZoom(true);//是否支持缩放
        webView.getSettings().setUseWideViewPort(true);//webview网页自适应手机屏幕大小,设置webview推荐使用的窗口

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl(url); // 在当前的webview中跳转到新的url
                return true;
            }
        });

    }

    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(webView.getTitle());
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl(webView.getUrl());
        // text是分享文本，所有平台都需要这个字段
        oks.setText(webView.getTitle());
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImagePath("/sdcard/ic.png");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(webView.getUrl());
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("爱深圳");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(webView.getUrl());

        // 启动分享GUI
        oks.show(this);
    }

}
