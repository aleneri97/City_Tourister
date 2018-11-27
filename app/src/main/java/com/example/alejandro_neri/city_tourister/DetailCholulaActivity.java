package com.example.alejandro_neri.city_tourister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DetailCholulaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cholula);
    }

    public void ViewInfo(View view){
        Intent intent = new Intent(getApplicationContext(),Info_Puebla.class);
        startActivity(intent);
    }
    public void ViewRoutes(View view){
        Intent intent = new Intent(getApplicationContext(),RoutesActivity.class);
        startActivity(intent);
    }
}
