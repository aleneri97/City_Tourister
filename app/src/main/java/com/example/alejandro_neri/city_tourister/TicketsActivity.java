package com.example.alejandro_neri.city_tourister;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class TicketsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Boletos");
    }

    //Conexion de screen con botones
    public void ViewHome(View view){
        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
        finish();
        startActivity(intent);
    }
    public void ViewMap(View view){
        Intent intent = new Intent(getApplicationContext(),MapActivity.class);
        finish();
        startActivity(intent);
    }
    public void ViewRoutes(View view){
        Intent intent = new Intent(getApplicationContext(),RoutesActivity.class);
        finish();
        startActivity(intent);
    }
    public void ViewTickets(View view){
        Intent intent = new Intent(getApplicationContext(),TicketsActivity.class);
        finish();
        startActivity(intent);
    }
    public void BuyTickets(View view){
        Intent intent = new Intent(getApplicationContext(),PurchaseStep1Activity.class);
        startActivity(intent);
    }
}
