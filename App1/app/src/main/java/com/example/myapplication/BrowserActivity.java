package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

public class BrowserActivity extends AppCompatActivity {

    private WebView mWebView;
    public static final String WEB_KEY = "SEARCH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        mWebView = findViewById(R.id.webView);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        MWebViewClient webViewClient = new MWebViewClient(BrowserActivity.this);
        mWebView.setWebViewClient(webViewClient);

        Bundle bundle = getIntent().getExtras();
        String str = bundle.getString(WEB_KEY);
        //mWebView.loadData("<html><body>Hello, world!</body></html>", "text/html", "UTF-8");

        setTitle("WEB");

        mWebView.loadUrl("https://google.com/search?q="+str);
    }
}