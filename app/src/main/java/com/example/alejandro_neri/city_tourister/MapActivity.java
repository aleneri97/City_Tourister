package com.example.alejandro_neri.city_tourister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Obtiene el SupportMapFragment y notifica cuando el mapa esta listo para ser usado
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Mapa");
    }

    //Mapa
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Puebla fascinante
        // Catedral
        LatLng catedral = new LatLng(19.0429, -98.1983);
        mMap.addMarker(new MarkerOptions().position(catedral).title("Catedral de Puebla").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet("La Catedral Basílica de Puebla, es uno de las más importantes inmuebles del centro histórico declarado patrimonio de la humanidad."));

        // Fuerte de loreto
        LatLng fuerte_loreto = new LatLng(19.0579, -98.187);
        mMap.addMarker(new MarkerOptions().position(fuerte_loreto).title("Fuerte de Loreto").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet("El fuerte de Loreto es una antigua edificacion militar que se encuentra en la ciudad de Puebla. Originalmente se trataba de una capilla construida en lo alto del cerro Acueyametepec, que fue reconstituida a principios del siglo XIX como fortificacion con finalidad militar."));

        // Museo Amparo
        LatLng museo_amparo = new LatLng(19.0408, -98.1987);
        mMap.addMarker(new MarkerOptions().position(museo_amparo).title("Museo Amparo").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet("El Museo Amparo, es un espacio cultural contemporáneo creado en memoria de Amparo Rugarcía de Espinoza esposa del banquero y filántropo mexicano Manuel Espinosa Yglesias."));

        // Santa Clara
        LatLng santa_clara = new LatLng(19.0451, -98.192);
        mMap.addMarker(new MarkerOptions().position(santa_clara).title("Santa Clara").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet(""));

        // Barrio del Artista
        LatLng barrio_artista = new LatLng(19.0441, -98.1922);
        mMap.addMarker(new MarkerOptions().position(barrio_artista).title("Barrio del Artista").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet("El Barrio del Artista es un espacio artístico en la ciudad de Puebla de Zaragoza en el estado de Puebla. Ubicado en lo que se conoce como Plazuela del Torno o del Factor, los artistas trabajan y exponen su obra a la vista de los turistas y ciudadanos que visitan este corredor."));

        // Paseo de San Francisco
        LatLng paseo_snfrancisco = new LatLng(19.0428, -98.1911);
        mMap.addMarker(new MarkerOptions().position(paseo_snfrancisco).title("Paseo San Francisco").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet(""));

        // San Francisco
        LatLng san_francisco = new LatLng(19.045, -98.1893);
        mMap.addMarker(new MarkerOptions().position(san_francisco).title("San Francisco").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet("El Ex-convento de San Francisco es el primer convento de la Ciudad de Puebla. Fray Toribio de Benavente, uno de los doce primeros religiosos en arribar a la Nueva España, colocó la primera piedra en 1535. Se ubica en el barrio del Alto, la zona más antigua de la ciudad de Puebla, el barrio indígena."));

        // Gruta de Lourdes
        LatLng gruta_lourdes = new LatLng(19.0535, -98.1851);
        mMap.addMarker(new MarkerOptions().position(gruta_lourdes).title("Gruta de Lourdes").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet("Este templo religioso está dedicado a la Virgen de Lourdes, la cual es venerada en Francia. Según las visiones de Bernadette Soubirous, la Virgen se apareció en la Gruta de Massabiell, que se ubica a las orillas del río Gave de Pau, a las afueras de la población de Lourdes en 1858."));

        // Museo de Antropologia e Historia
        LatLng museo_antropologico = new LatLng(19.0562, -98.1827);
        mMap.addMarker(new MarkerOptions().position(museo_antropologico).title("Museo de Antropologia e Historia").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet("El Museo Regional de Puebla alberga una colección de extraordinario valor cultural y atractivo estético, integrado por el Museo de la No Intervención Fuerte de Loreto, el Monumento Histórico Fuerte de Guadalupe, el Museo Interactivo Imagina, el Planetario, el Auditorio de la Reforma y el Centro Expositor de Puebla."));

        // Teleférico
        LatLng teleferico = new LatLng(19.0574, -98.181);
        mMap.addMarker(new MarkerOptions().position(teleferico).title("Teleférico").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet("Está ubicado en la zona de los Fuertes, comunicando el Centro Expositor, cuya estación mide 58 metros de altura, con el monumento a Zaragoza, donde la estación se encuentra a 48 metros sobre el suelo."));

        // Museo de la Evolución
        LatLng museo_evolucion = new LatLng(19.0578, -98.1816);
        mMap.addMarker(new MarkerOptions().position(museo_evolucion).title("Museo de la Evolución").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet("El Museo de la Evolución Puebla abarca desde la historia del cosmos hasta las eras geológicas de la Tierra, pasando por el Big Bang y la creación del ser humano. Es un recinto que se especializa en nuestra evolución y todo lo que nos rodea."));

        // Planetario
        LatLng planetario = new LatLng(19.057, -98.1816);
        mMap.addMarker(new MarkerOptions().position(planetario).title("Planetario").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet("El Planetario simula una estación de servicio planetario en el espacio exterior, el cual ofrece un gran entretenimiento y aprendizaje, a través de talleres permanentes, juegos interactivos, un proyector de estrellas y el Domo OMNIMAX."));

        // Centro Expositor
        LatLng centro_expositor = new LatLng(19.0586, -98.1811);
        mMap.addMarker(new MarkerOptions().position(centro_expositor).title("Centro Expositor").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet("El Centro Expositor y de Convenciones de Puebla es un centro de convenciones, exposiciones y también utilizado como arena multiusos. Está ubicado en la Unidad Cívica 5 de Mayo en la zona de Los Fuertes en la Ciudad de Puebla de Zaragoza capital del Estado de Puebla en México."));

        // Galeria tesoros de la catedral
        LatLng galeria_catedral = new LatLng(19.0423, -98.1988);
        mMap.addMarker(new MarkerOptions().position(galeria_catedral).title("Galería de tesoros de la catedral").icon(BitmapDescriptorFactory.fromResource(R.drawable.puntos_de_interes)).snippet("La Galería Tesoros de la Catedral de Puebla es un espacio dedicado a la difusión del rico acervo patrimonial que resguarda el obispado; en una participación conjunta del Gobierno del Estado y la Arquidiócesis."));

        // Fuerte Guadalupe
        LatLng fuerte_guadalupe = new LatLng(19.0525, -98.18);
        mMap.addMarker(new MarkerOptions().position(fuerte_guadalupe).title("Fuerte Guadalupe").icon(BitmapDescriptorFactory.fromResource(R.drawable.puntos_de_interes)).snippet("El fuerte de Guadalupe es una antigua edificacion militar que se encuentra en la ciudad de Puebla. Originalmente se trataba de una capilla construida en lo alto del cerro Acueyametepec, que fue reconstituida a principios del siglo XIX como fortificacion con finalidad militar."));

        // Monumento a Zaragoza
        LatLng monumento_zaragoza = new LatLng(19.0605, -98.1846);
        mMap.addMarker(new MarkerOptions().position(monumento_zaragoza).title("Monumento a Zaragoza").icon(BitmapDescriptorFactory.fromResource(R.drawable.puntos_de_interes)).snippet("Es un mausoleo donde de descansan los restos de uno de los generales más importantes que ha tenido México, ubicado cerca de los Fuertes de Loreto y Guadalupe, donde defendió al país."));

        //Cholula
        //Catedral
        //Paseo Bravo
        LatLng paseo_bravo = new LatLng(19.046335, -98.208031);
        mMap.addMarker(new MarkerOptions().position(paseo_bravo).title("Paseo Bravo").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet("El Paseo Bravo es un parque urbano ubicado en la ciudad de Puebla, en Puebla, México. Fue inaugurado en 1840 bajo el nombre de Paseo Nuevo y es considerado uno de los sitios emblemáticos de la capital poblana."));

        //Avenida Juarez
        LatLng av_juarez = new LatLng(19.051371, -98.217838);
        mMap.addMarker(new MarkerOptions().position(av_juarez).title("Avenida Juarez").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)));

        //Fuente de los angeles
        LatLng fuente_angeles = new LatLng(19.05376, -98.222686);
        mMap.addMarker(new MarkerOptions().position(fuente_angeles).title("Fuente de los angeles").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet("La fuente de San Miguel Arcángel fue construida por el arquitecto Juan Antonio de Santa María de Inchaúrregui. El artista contó con la colaboración de los maestro de talla de piedra Anselmo Martínez y José Francisco Rabanillo. Fue bendecida e inaugurada el 23 de junio de 1777."));

        //Cerro de la Paz
        LatLng cerro_paz = new LatLng(19.055793, -98.227637);
        mMap.addMarker(new MarkerOptions().position(cerro_paz).title("Cerro de la Paz").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)));

        //Centro Cholula
        LatLng centro_cholula = new LatLng(19.061585, -98.306089);
        mMap.addMarker(new MarkerOptions().position(centro_cholula).title("Centro Cholula").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet("Cholula es considerado un pueblo mágico por ser una de las localidades de México con mayores atributos simbólicos, historia, leyendas, tradición y arte; es una localidad que cuenta con innumerables manifestaciones socio culturales además de muchísima belleza."));

        //Santa Maria Tonanzintla
        LatLng sn_maria = new LatLng(19.030197, -98.319843);
        mMap.addMarker(new MarkerOptions().position(sn_maria).title("Santa Maria Tonanzintla").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet("Es un mausoleo donde de descansan los restos de uno de los generales más importantes que ha tenido México, ubicado cerca de los Fuertes de Loreto y Guadalupe, donde defendió al país."));

        //San Francisco Acatepec
        LatLng acatepec = new LatLng(19.022831, -98.309259);
        mMap.addMarker(new MarkerOptions().position(acatepec).title("San Francisco Acatepec").icon(BitmapDescriptorFactory.fromResource(R.drawable.recomendados)).snippet("Es un mausoleo donde de descansan los restos de uno de los generales más importantes que ha tenido México, ubicado cerca de los Fuertes de Loreto y Guadalupe, donde defendió al país."));
        //Zoom de vista al mapa
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(catedral,16));

        //Botones + y - en el mapa
        mMap.getUiSettings().setZoomControlsEnabled(true);

        if(mMap!=null){
            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                    View row = getLayoutInflater().inflate(R.layout.dialog_map, null);
                    TextView t1_locality = (TextView)row.findViewById(R.id.locality);
                    TextView t2_snippet = (TextView)row.findViewById(R.id.snippet);

                    t1_locality.setText(marker.getTitle());
                    t2_snippet.setText(marker.getSnippet());

                    return row;
                }
            });
        }

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
