package com.example.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MWebViewClient extends WebViewClient {

    private Activity activity = null;

    public MWebViewClient(Activity activity) {
        this.activity = activity;
    }

    WebViewClient webViewClient = new WebViewClient() {
        @SuppressWarnings("deprecation") @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @TargetApi(Build.VERSION_CODES.N) @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    };
    
}

