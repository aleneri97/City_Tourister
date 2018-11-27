package com.example.alejandro_neri.city_tourister;

//TODO: !! Hacer con SharedPreferences que si ya inició sesión, que lo mande al Home, si ya llegaron al menos una vez al login, la próxima vez, si no inició sesión, lo manda directo al Login


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;


public class SplashActivity extends AppCompatActivity {
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            /*
        // Esta es la forma en la que recuperamos las sharedPreferences
        preferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);

        // Crearemos los intents a ambas pantallas
        Intent mainIntent = new Intent(this, HomeActivity.class);
        Intent loginIntent = new Intent(this, WelcomeActivity.class);

        String email = Util.getUserEmail(preferences);
        String password = Util.getUserPassword(preferences);

        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            startActivity(mainIntent);
        } else{
            startActivity(loginIntent);
        }

        */
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }
}

