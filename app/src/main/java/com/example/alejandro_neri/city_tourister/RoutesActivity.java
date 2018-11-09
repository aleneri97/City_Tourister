package com.example.alejandro_neri.city_tourister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RoutesActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.routes);
        mapFragment.getMapAsync(this);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Rutas");
    }

    //Mapa
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Marcador en catedral
        LatLng catedral = new LatLng(19.042589, -98.197765);
        mMap.addMarker(new MarkerOptions().position(catedral).title("Catedral").icon(BitmapDescriptorFactory.fromResource(R.drawable.paradas)));
        // Marcador en el los fuertes
        LatLng los_fuertes = new LatLng(19.056955, -98.184076);
        mMap.addMarker(new MarkerOptions().position(los_fuertes).title("Los fuertes").icon(BitmapDescriptorFactory.fromResource(R.drawable.paradas)));

        // Marcador en el zocalo
        LatLng zocalo = new LatLng(19.044138, -98.198246);
        mMap.addMarker(new MarkerOptions().position(zocalo).title("Zócalo").icon(BitmapDescriptorFactory.fromResource(R.drawable.paradas)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(zocalo,16));
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }

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
}
