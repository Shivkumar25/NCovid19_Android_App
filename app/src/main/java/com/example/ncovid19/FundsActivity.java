package com.example.ncovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FundsActivity extends AppCompatActivity {
    private WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funds);

        webView1 = (WebView) findViewById(R.id.webview);
        webView1.setWebViewClient(new WebViewClient());
        webView1.loadUrl("https://www.investindia.gov.in/bip/resources/state-and-national-relief-funds-accepting-donations-covid-19");

        WebSettings webSettings = webView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    @Override
    public void onBackPressed() {
        if (webView1.canGoBack()) {
            webView1.goBack();
        } else {
            super.onBackPressed();
        }
    }

}
