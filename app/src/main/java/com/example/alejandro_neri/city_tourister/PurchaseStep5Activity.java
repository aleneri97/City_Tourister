package com.example.alejandro_neri.city_tourister;

// TODO: 11/26/18 ! Añadir pasajeros desde aquí
// TODO: 11/26/18 ! Borrar pasajeros
// TODO: 11/26/18 ! Mostrar tipo de ticket y costo
// TODO: 11/26/18 !! Cuando se presione la flecha de atras, con el ícono, también ahi debe de pasar los intents

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PurchaseStep5Activity extends AppCompatActivity {
    // private TextView tv;
    private Toolbar toolbar;
    private TextView tvTour;
    private TextView tvDate;
    private TextView tvTotal;
    private String tour;
    private String date;
    private String kidsTickets;
    private String adultsTickets;
    private String seniorTickets;
    private String totalTickets;
    private String total;
    private static final int REQUEST_CODE = 1;


    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_step5);

        bindUi();


        toolbar.setNavigationIcon(R.drawable.back_shape);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), PurchaseStep4Activity.class));
            }
        });

        tvTour.setText(tour);
        tvDate.setText(date);
        tvTotal.setText("TOTAL: $"+total+".00");


        //Aqui empezamos a trabajar con la lista expandible, traemos la información.
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        //Lo que pasará cuando presionen a uno de los pasajeros
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //Toast.makeText(getApplicationContext(),expandableListTitle.get(groupPosition) + " -> " + expandableListDetail.get(expandableListTitle.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    private void bindUi() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        tvTour = (TextView) findViewById(R.id.textViewTour);
        tvDate = (TextView) findViewById(R.id.textViewDate);
        tvTotal = (TextView) findViewById(R.id.textViewTotal);
        bindExplicitIntent();
    }

    private void bindExplicitIntent(){
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            if (bundle.getString("tour") != null)
                tour = bundle.getString("tour")+"";
            else
                Toast.makeText(PurchaseStep5Activity.this, "Error 50: Elija tickets nuevamente", Toast.LENGTH_LONG).show(); //no encontro este dato

            if (bundle.getString("kidsTickets") != null)
                kidsTickets = bundle.getString("kidsTickets")+"";
            else
                Toast.makeText(PurchaseStep5Activity.this, "Error 51: Elija tickets nuevamente", Toast.LENGTH_LONG).show(); //no encontro este dato

            if (bundle.getString("adultsTickets") != null)
                adultsTickets = bundle.getString("adultsTickets")+"";
            else
                Toast.makeText(PurchaseStep5Activity.this, "Error 52: Elija tickets nuevamente", Toast.LENGTH_LONG).show(); //no encontro este dato

            if (bundle.getString("seniorsTickets") != null)
                seniorTickets = bundle.getString("seniorsTickets")+"";
            else
                Toast.makeText(PurchaseStep5Activity.this, "Error 53: Elija tickets nuevamente", Toast.LENGTH_LONG).show(); //no encontro este dato

            if (bundle.getString("tour") != null)
                totalTickets = bundle.getString("tour")+"";
            else
                Toast.makeText(PurchaseStep5Activity.this, "Error 54: Elija tickets nuevamente", Toast.LENGTH_LONG).show(); //no encontro este dato

            if (bundle.getString("total") != null)
                total = bundle.getString("total")+"";
            else
                Toast.makeText(PurchaseStep5Activity.this, "Error 55: Elija tickets nuevamente", Toast.LENGTH_LONG).show(); //no encontro este dato

            if (bundle.getString("date") != null)
                date = bundle.getString("date")+"";
            else
                Toast.makeText(PurchaseStep5Activity.this, "Error 56: Elija tickets nuevamente", Toast.LENGTH_LONG).show(); //no encontro este dato

        }
    }

}
