package com.example.alejandro_neri.city_tourister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TermsAndConditionsActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        //Vistas de la pagina web
        webView = (WebView)findViewById(R.id.webviewtermsandcondition);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.tourister.com.mx/terminos-condiciones");
    }
}
