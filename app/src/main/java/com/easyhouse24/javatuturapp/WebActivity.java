package com.easyhouse24.javatuturapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Runnable run = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),"Paste program here and execute to see output",Toast.LENGTH_SHORT).show();

            }
        };

        Handler handler = new Handler();

        handler.postDelayed(run,5000);

        setContentView(R.layout.activity_web);
        webView = (WebView) findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.tutorialspoint.com/compile_java_online.php");
    }
}
