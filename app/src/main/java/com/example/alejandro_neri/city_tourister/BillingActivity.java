package com.example.alejandro_neri.city_tourister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BillingActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);

        //Vistas de la pagina web
        webView = (WebView)findViewById(R.id.webviewbilling);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://facturas.estrellaroja.com.mx/");
    }
}
