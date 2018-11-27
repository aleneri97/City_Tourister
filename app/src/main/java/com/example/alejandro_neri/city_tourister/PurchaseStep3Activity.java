package com.example.alejandro_neri.city_tourister;

// TODO: 11/26/18 ! Obtener los datos de los usuarios (falta edad)
// TODO: 11/26/18 ! Validar la edad de los pasajeros
// TODO: 11/26/18 ! Poner diferentes rows dependiendo de lo que hayan mandado (nino, adulto o 3ª edad)
// TODO: 11/26/18 ! Boton borrar
// TODO: 11/26/18 !! Cuando se presione la flecha de atras, con el ícono, también ahi debe de pasar los intents

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PurchaseStep3Activity extends AppCompatActivity {
    private Toolbar toolbar;
    private FloatingActionButton nextButton;
    private RecyclerView recyclerView;
    private String tickets;

    private CustomAdapter customAdapter;
    public ArrayList<EditModel> editModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_step3);
        bindUi();


        //Traeremos los datos de los intents
        Bundle bundle = getIntent().getExtras();
        // Si el bundle tiene algo de información, y la llave no está vacía, entonces recuperará su valor
        if (bundle != null && bundle.getString("totalTickets") != null){
            // Se lo asignamos a la variable tickets
            tickets = (bundle.getString("totalTickets"));
        } else
            Toast.makeText(PurchaseStep3Activity.this,"it is empty",Toast.LENGTH_LONG).show();



        toolbar.setNavigationIcon(R.drawable.back_shape);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), PurchaseStep2Activity.class));
            }
        });

        editModelArrayList = populateList();
        customAdapter = new CustomAdapter(this,editModelArrayList);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goNext();
            }
        });
    }

    private void bindUi() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        nextButton = (FloatingActionButton) findViewById(R.id.floatingActionButtonNext);
        recyclerView = (RecyclerView) findViewById(R.id.listView);
        nextButton = (FloatingActionButton) findViewById(R.id.floatingActionButtonNext);
    }

    private ArrayList<EditModel> populateList(){
        ArrayList<EditModel> list = new ArrayList<>();
        for(int i = 0; i < Integer.parseInt(tickets); i++){
            EditModel editModel = new EditModel();
            editModel.setEditTextValue("");
            list.add(editModel);
        }
        return list;
    }

    private void goNext(){
        int allNamesValid = allNamesValid();
        if (allNamesValid != -1) {
            allNamesValid += 1;
            Toast.makeText(PurchaseStep3Activity.this, "Complete los datos del pasajero " + allNamesValid, Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(PurchaseStep3Activity.this, PurchaseStep4Activity.class);
            //Hasta este momento tengo: tour, kidsTickets, adultsTickets, seniorTickets, totalTickets, total Y los nombres quedan en editModelArrayList

            Bundle bundle = getIntent().getExtras();
            if (bundle != null && bundle.getString("tour") != null)
                intent.putExtra("tour", (bundle.getString("tour")) + "");
            else
                Toast.makeText(PurchaseStep3Activity.this, "Error 30: Elija tickets nuevamente", Toast.LENGTH_LONG).show();

            if (bundle != null && bundle.getString("kidsTickets") != null)
                intent.putExtra("kidsTickets", (bundle.getString("kidsTickets")) + "");
            else
                Toast.makeText(PurchaseStep3Activity.this, "Error 31: Elija tickets nuevamente", Toast.LENGTH_LONG).show();

            if (bundle != null && bundle.getString("adultsTickets") != null)
                intent.putExtra("adultsTickets", (bundle.getString("adultsTickets")) + "");
            else
                Toast.makeText(PurchaseStep3Activity.this, "Error 32: Elija tickets nuevamente", Toast.LENGTH_LONG).show();

            if (bundle != null && bundle.getString("seniorsTickets") != null)
                intent.putExtra("seniorsTickets", (bundle.getString("seniorsTickets")) + "");
            else
                Toast.makeText(PurchaseStep3Activity.this, "Error 33: Elija tickets nuevamente", Toast.LENGTH_LONG).show();

            if (bundle != null && bundle.getString("totalTickets") != null)
                intent.putExtra("totalTickets", (bundle.getString("totalTickets")) + "");
            else
                Toast.makeText(PurchaseStep3Activity.this, "Error 34: Elija tickets nuevamente", Toast.LENGTH_LONG).show();

            if (bundle != null && bundle.getString("total") != null)
                intent.putExtra("total", (bundle.getString("total")) + "");
            else
                Toast.makeText(PurchaseStep3Activity.this, "Error 35: Elija tickets nuevamente", Toast.LENGTH_LONG).show();

            startActivity(intent);
        }
    }

    private int allNamesValid(){
        int allNamesValid = -1; //-1 significa que está bien
        //Primero validaremos que los nombres estén puestos
        for (int i = 0; i < CustomAdapter.editModelArrayList.size(); i++) {
            String passengerName = CustomAdapter.editModelArrayList.get(i).getEditTextValue();
            if (passengerName == null )
                return i;
            else if (passengerName.length() < 5)
                return i;
        }
        return allNamesValid;
    }

}