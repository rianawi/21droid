package com.smallsteplabs.twentyonedroid;

import java.util.Map;
import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.KeyEvent;

public class TwentyOneDroid extends Activity
{
    WebView webview;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webview.loadUrl("http://m.21cineplex.com/");
        webview.setWebViewClient(new TwentyOneDroidWebViewClient());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
            webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class TwentyOneDroidWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Map extraHeaders = new HashMap();
            extraHeaders.put("Referer", "http://m.21cineplex.com/");
            view.loadUrl(url, extraHeaders);
            return true;
        }
    }
}

