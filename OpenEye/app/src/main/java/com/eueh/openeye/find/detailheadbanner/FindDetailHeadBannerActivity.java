package com.eueh.openeye.find.detailheadbanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;
import com.eueh.openeye.find.toolg.ToolG;

import java.io.UnsupportedEncodingException;

//一级页面顶部banner的详情页 webview

public class FindDetailHeadBannerActivity extends BaseActivity {

    private WebView webView;
    private WebSettings webSettings;
    private String output;

    @Override
    public int setLayout() {
        return R.layout.activity_find_detail_head_banner;
    }

    @Override
    public void initView() {

        webView = (WebView) findViewById(R.id.wv_find_g);
        webSettings = webView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
     //   webSettings.setTextSize(WebSettings.TextSize.LARGEST);

        //强制使用JavaScript
        webView.getSettings().setJavaScriptEnabled(true);

    }

    @Override
    public void initData() {

        Intent intent = getIntent();
        String webUrl = intent.getStringExtra("webUrlG");
        try {
            output = java.net.URLDecoder.decode(webUrl, "UTF-8");
            Log.d("FindDetailHeadBannerAct", "++++++++++++++++++++++++++++++"+ output);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Log.d("FindDetailHeadBannerAct", ToolG.subString(output));
        webView.loadUrl(ToolG.subString(output));
    }
}
