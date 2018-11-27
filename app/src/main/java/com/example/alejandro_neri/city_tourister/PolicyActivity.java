package com.example.alejandro_neri.city_tourister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PolicyActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);

        //Vistas de la pagina web
        webView = (WebView)findViewById(R.id.webviewpolicy);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.tourister.com.mx/aviso-privacidad");
    }
}
