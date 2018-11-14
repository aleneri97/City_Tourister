package com.example.alejandro_neri.city_tourister;

import android.content.Intent;
import android.graphics.Color;
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
import com.google.android.gms.maps.model.PolylineOptions;

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

        //Puebla Fascinante
        // Analco - Parada #1
        LatLng analco = new LatLng(19.04, -98.1947);
        mMap.addMarker(new MarkerOptions().position(analco).title("Analco - Salida").icon(BitmapDescriptorFactory.fromResource(R.drawable.paradas)));

        // Parada #2
        LatLng parada_2 = new LatLng(19.0442, -98.1917);
        mMap.addMarker(new MarkerOptions().position(parada_2).title("Parada #2").icon(BitmapDescriptorFactory.fromResource(R.drawable.paradas)));

        // Fuerte de Loreto - Parada #3
        LatLng fuerte_loreto = new LatLng(19.0567648, -98.1875639);
        mMap.addMarker(new MarkerOptions().position(fuerte_loreto).title("Fuerte de Loreto - Parada #3").icon(BitmapDescriptorFactory.fromResource(R.drawable.paradas)));

        // Parada #4
        LatLng parada_4 = new LatLng(19.053486, -98.180159);
        mMap.addMarker(new MarkerOptions().position(parada_4).title("Parada #4").icon(BitmapDescriptorFactory.fromResource(R.drawable.paradas)));

        // Parada #5
        LatLng parada_5 = new LatLng(19.059248, -98.183544);
        mMap.addMarker(new MarkerOptions().position(parada_5).title("Parada #5").icon(BitmapDescriptorFactory.fromResource(R.drawable.paradas)));

        // Teatro principal - Parada #6
        LatLng teatro_principal = new LatLng(19.044758, -98.191756);
        mMap.addMarker(new MarkerOptions().position(teatro_principal).title("Teatro Principal - Parada #6").icon(BitmapDescriptorFactory.fromResource(R.drawable.paradas)));

        //Cholula milenaria
        // Catedral
        LatLng catedral = new LatLng(19.0429, -98.1983);
        mMap.addMarker(new MarkerOptions().position(catedral).title("Catedral de Puebla").icon(BitmapDescriptorFactory.fromResource(R.drawable.paradas)).snippet("La Catedral - Salida"));


        //Zoom de vista al mapa
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(analco,16));

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
                    View row = getLayoutInflater().inflate(R.layout.dialog_routes, null);
                    TextView t1_locality = (TextView)row.findViewById(R.id.locality);

                    t1_locality.setText(marker.getTitle());

                    return row;
                }
            });
        }

        LatLng a = new LatLng(19.0379,-98.1955);
        LatLng b = new LatLng(19.03983,-98.19427);
        LatLng c = new LatLng(19.04007,-98.194717);
        LatLng d = new LatLng(19.040239,-98.194006);
        LatLng e = new LatLng(19.040816,-98.193052);
        LatLng f = new LatLng(19.041361,-98.192691);
        LatLng g = new LatLng(19.041988,-98.192521);
        LatLng h = new LatLng(19.042181,-98.192395);
        LatLng i = new LatLng(19.044827,-98.191539);
        LatLng j = new LatLng(19.045429,-98.19038);
        LatLng k = new LatLng(19.045773,-98.189792);
        LatLng l = new LatLng(19.046304,-98.189568);
        LatLng m = new LatLng(19.047137,-98.189625);
        LatLng n = new LatLng(19.049147,-98.18907);
        LatLng o = new LatLng(19.048097,-98.188342);
        LatLng p = new LatLng(19.050041,-98.1865);
        LatLng q = new LatLng(19.050679,-98.185489);
        LatLng r = new LatLng(19.051977,-98.185676);
        LatLng s = new LatLng(19.053381,-98.185144);
        LatLng t = new LatLng(19.055342,-98.185599);
        LatLng u = new LatLng(19.055833,-98.18598);
        LatLng v = new LatLng(19.056602,-98.187371);
        LatLng w = new LatLng(19.0571,-98.187957);
        LatLng x = new LatLng(19.057688,-98.188132);
        LatLng y = new LatLng(19.058116,-98.18801);
        LatLng z = new LatLng(19.058206,-98.187898);
        LatLng aa = new LatLng(19.058191,-98.187685);
        LatLng bb = new LatLng(19.057758,-98.187861);
        LatLng cc = new LatLng(19.057562,-98.187839);
        LatLng dd = new LatLng(19.057421,-98.187749);
        LatLng ee = new LatLng(19.056875,-98.186617);
        LatLng ff = new LatLng(19.058323,-98.185441);
        LatLng gg = new LatLng(19.058175,-98.185183);
        LatLng hh = new LatLng(19.053228,-98.180938);
        LatLng ii = new LatLng(19.05262,-98.180852);
        LatLng jj = new LatLng(19.052363,-98.180778);
        LatLng kk = new LatLng(19.052162,-98.180645);
        LatLng ll = new LatLng(19.052011,-98.180395);
        LatLng mm = new LatLng(19.052061,-98.179362);
        LatLng nn = new LatLng(19.052475,-98.178937);
        LatLng oo = new LatLng(19.052995,-98.178904);
        LatLng pp = new LatLng(19.053271,-98.179083);
        LatLng qq = new LatLng(19.053378,-98.179554);
        LatLng rr = new LatLng(19.053396,-98.180224);
        LatLng ss = new LatLng(19.053603,-98.180463);
        LatLng tt = new LatLng(19.059449,-98.183753);
        LatLng uu = new LatLng(19.059957,-98.18368);
        LatLng vv = new LatLng(19.061849,-98.182013);
        LatLng xx = new LatLng(19.061994,-98.182139);
        LatLng yy = new LatLng(19.060846,-98.183346);
        LatLng zz = new LatLng(19.060896,-98.1845);
        LatLng aaa = new LatLng(19.060602,-98.185442);
        LatLng bbb = new LatLng(19.059309,-98.187918);
        LatLng ccc = new LatLng(19.054666,-98.190616);
        LatLng ddd = new LatLng(19.053816,-98.191078);
        LatLng eee = new LatLng(19.052829,-98.191877);
        LatLng fff = new LatLng(19.050689,-98.189991);
        LatLng ggg = new LatLng(19.049946,-98.189539);
        LatLng hhh = new LatLng(19.049436,-98.189401);
        LatLng iii = new LatLng(19.048291,-98.189488);
        LatLng jjj = new LatLng(19.047218,-98.189764);
        LatLng kkk = new LatLng(19.046411,-98.189759);
        LatLng lll = new LatLng(19.045902,-98.189941);
        LatLng mmm = new LatLng(19.045006,-98.191688);
        LatLng nnn = new LatLng(19.042201,-98.192566);
        LatLng ooo = new LatLng(19.040313,-98.194784);
        LatLng ppp = new LatLng(19.039126,-98.195931);
        LatLng qqq = new LatLng(19.038299,-98.196449);
        LatLng rrr = new LatLng(19.0379,-98.1955);

        mMap.addPolyline(new PolylineOptions().add(a).add(b).add(c).add(d).add(e).add(f).add(g).add(h).add(i).add(j).add(k).add(l).add(m).add(n).add(o).add(p).add(q).add(r).add(s).add(t).add(u).add(v).add(w).add(x).add(y).add(z).add(aa).add(bb).add(cc).add(dd).add(ee).add(ff).add(gg).add(hh).add(ii).add(jj).add(kk).add(ll).add(mm).add(nn).add(oo).add(pp).add(qq).add(rr).add(ss).add(tt).add(uu).add(vv).add(yy).add(zz).add(aaa).add(bbb).add(ccc).add(ddd).add(eee).add(fff).add(ggg).add(hhh).add(iii).add(jjj).add(kkk).add(lll).add(mmm).add(nnn).add(ooo).add(ppp).add(qqq).add(rrr).width(10f).color(Color.BLUE));

        LatLng ab = new LatLng(19.043612,-98.197284);
        LatLng bc = new LatLng(19.042187,-98.198021);
        LatLng cd = new LatLng(19.04295,-98.199537);
        LatLng de = new LatLng(19.043638,-98.199084);
        LatLng ef = new LatLng(19.048023,-98.207831);
        LatLng fg = new LatLng(19.046659,-98.208567);
        LatLng gh = new LatLng(19.054595,-98.224224);
        LatLng hi = new LatLng(19.056041,-98.224339);
        LatLng ij = new LatLng(19.057866,-98.225172);
        LatLng jk = new LatLng(19.058541,-98.22674);
        LatLng kl = new LatLng(19.058053,-98.23085);
        LatLng lm = new LatLng(19.059698,-98.234425);
        LatLng mn = new LatLng(19.060083,-98.295103);
        LatLng no = new LatLng(19.062685,-98.296698);
        LatLng op = new LatLng(19.059853,-98.302485);
        LatLng pq = new LatLng(19.06192,-98.307022);
        LatLng qr = new LatLng(19.049836,-98.31306);
        LatLng rs = new LatLng(19.048598,-98.312327);
        LatLng st = new LatLng(19.044679,-98.314992);
        LatLng tu = new LatLng(19.035484,-98.316618);
        LatLng uv = new LatLng(19.030297,-98.319994);
        LatLng vw = new LatLng(19.022652,-98.309205);


        mMap.addPolyline(new PolylineOptions().add(ab).add(bc).add(cd).add(de).add(ef).add(fg).add(gh).add(hi).add(ij).add(jk).add(kl).add(lm).add(mn).add(no).add(op).add(pq).add(qr).add(rs).add(st).add(tu).add(uv).add(vw).width(10f).color(Color.RED));

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
