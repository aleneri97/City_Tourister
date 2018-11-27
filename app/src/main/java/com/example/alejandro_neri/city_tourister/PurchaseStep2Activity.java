package com.example.alejandro_neri.city_tourister;

// TODO: 11/26/18 !! Cambiar los precios de los tickets segun el back
// TODO: 11/26/18 !!Cuando se presione la flecha de atras, con el ícono, también ahi debe de pasar los intents

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PurchaseStep2Activity extends AppCompatActivity {
    private Toolbar toolbar;
    private FloatingActionButton nextButton;
    private Button btnKidPlus;
    private Button btnKidLess;
    private Button btnAdultPlus;
    private Button btnAdultLess;
    private Button btnSeniorPlus;
    private Button btnSeniorLess;
    private TextView tvKid;
    private TextView tvAdult;
    private TextView tvSenior;
    private TextView tvTotal;
    private int numberKids;
    private int numberAdults;
    private int numberSeniors;
    private int total;


    //Aquí tenemos que traer los costos desde el back y asignarlos
    // para traerlos, tenemos que traer del intent pasado el tour que eligió, buscarlo en la base de datos y traer los 3 distintos precios (nino, adulto y mayor)
    private static final int COST_KID_TICKET = 45;
    private static final int COST_ADULT_TICKET = 65;
    private static final int COST_SENIOR_TICKET = 45;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_step2);
        bindUi();

        toolbar.setNavigationIcon(R.drawable.back_shape);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(),PurchaseStep1Activity.class));
            }
        });
        btnKidLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change(1,0);
            }
        });
        btnKidPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change(1,1);
            }
        });
        btnAdultLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change(2,0);
            }
        });
        btnAdultPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change(2,1);
            }
        });
        btnSeniorLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change(3,0);
            }
        });
        btnSeniorPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change(3,1);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNext();
            }
        });

    }

    private void bindUi(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        nextButton = (FloatingActionButton) findViewById(R.id.floatingActionButtonNext);
        btnKidPlus = (Button) findViewById(R.id.buttonPlus1);
        btnKidLess = (Button) findViewById(R.id.buttonLess1);
        btnAdultPlus = (Button) findViewById(R.id.buttonPlus2);
        btnAdultLess = (Button) findViewById(R.id.buttonLess2);
        btnSeniorPlus = (Button) findViewById(R.id.buttonPlus3);
        btnSeniorLess = (Button) findViewById(R.id.buttonLess3);
        tvKid = (TextView) findViewById(R.id.textViewNumberTickets1);
        tvAdult = (TextView) findViewById(R.id.textViewNumberTickets2);
        tvSenior = (TextView) findViewById(R.id.textViewNumberTickets3);
        tvTotal = (TextView) findViewById(R.id.textViewTotal);
    }

    private void goToNext() {
        Intent intentMain = new Intent(this, PurchaseStep3Activity.class);
        if (total != 0 && (numberAdults > 0 || numberSeniors > 0)) {
            intentMain.putExtra("total", total+"");
            intentMain.putExtra("kidsTickets", numberKids+"");
            intentMain.putExtra("adultsTickets", numberAdults+"");
            intentMain.putExtra("seniorsTickets", numberSeniors+"");
            int tickets = numberKids+numberAdults+numberSeniors;
            intentMain.putExtra("totalTickets", tickets+"");

            Bundle bundle = getIntent().getExtras();
            // Si el bundle tiene algo de información, y la llave no está vacía, entonces recuperará su valor
            if (bundle != null && bundle.getString("tour") != null){
                // Se lo asignamos a la variable
                String tour = bundle.getString("tour");
                intentMain.putExtra("tour",tour);
            } else
                Toast.makeText(PurchaseStep2Activity.this,"it is empty",Toast.LENGTH_LONG).show();
            startActivity(intentMain);
        } else if (numberAdults <= 0 || numberSeniors <= 0)
            Toast.makeText(PurchaseStep2Activity.this, "Seleccione al menos un pasajero adulto", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(PurchaseStep2Activity.this, "Seleccione al menos un pasajero", Toast.LENGTH_LONG).show();
        }

    private void change(int age, int change){
        //twngo que hacer casos, si la edad es 1 (kid), y el cambio es 1 (+1)
        //Entonces cambiar int numberKids
        //Con este, cambiar tvKid
        //
        //Cambiar int total
        //Con este, cambiar total
        switch (age){
            case 1: //kid
                if (change == 1) { //si presiona mas
                    numberKids++;
                    total += COST_KID_TICKET;
                } else if (numberKids > 0){
                    numberKids--;
                    total -= COST_KID_TICKET;
                }
                tvKid.setText(numberKids+"");
                break;
            case 2: //adult
                if (change == 1) { //si presiona mas
                    numberAdults++;
                    total += COST_ADULT_TICKET;
                } else if (numberAdults >0){
                    numberAdults--;
                    total -= COST_ADULT_TICKET;
                }
                tvAdult.setText(numberAdults+"");
                break;
            case 3: //senior
                if (change == 1) { //si presiona mas
                    numberSeniors++;
                    total += COST_SENIOR_TICKET;
                } else if (numberSeniors >0){
                    numberSeniors--;
                    total -= COST_SENIOR_TICKET;
                }
                tvSenior.setText(numberSeniors+"");
                break;
            default:
                Toast.makeText(this, "Hubo un error, volver a intentar", Toast.LENGTH_SHORT);
                break;
        }
        tvTotal.setText("Total: $"+total+".00");
    }
}