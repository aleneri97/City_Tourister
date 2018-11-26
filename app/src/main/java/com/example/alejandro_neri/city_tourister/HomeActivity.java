package com.example.alejandro_neri.city_tourister;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    CarouselView carouselView;
    //Imagenes mostradas en el carrusel
    int[] sampleImages = {R.drawable.puebla_fascinante,R.drawable.cholula_milenaria,R.drawable.casa_enanos};

    private Button btn_seemore;
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Inicio");

        //Carrusel
        carouselView = (CarouselView)findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        //Barra lateral
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //Barra lateral
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Manejo de navegacion de los items con tap
        int id = item.getItemId();

        if (id == R.id.nav_terminosycondiciones) { }
        else if (id == R.id.nav_avisodeprivacidad) { }
        else if (id == R.id.nav_contactanos) { }
        else if (id == R.id.nav_actualizaciones) { }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Carrusel
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    //Conexion de screen con botones
    public void ViewHome(View view){
        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(intent);
    }
    public void ViewMap(View view){
        Intent intent = new Intent(getApplicationContext(),MapActivity.class);
        startActivity(intent);
    }
    public void ViewRoutes(View view){
        Intent intent = new Intent(getApplicationContext(),RoutesActivity.class);
        startActivity(intent);
    }
    public void ViewTickets(View view){
        Intent intent = new Intent(getApplicationContext(),TicketsActivity.class);
        startActivity(intent);
    }
    public void ViewInfo(View view){
        Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
        startActivity(intent);
    }
}
