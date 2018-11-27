package com.example.alejandro_neri.city_tourister;

// TODO: 11/26/18 ! Estilizar calendario
// TODO: 11/26/18 !! Prohibir fechas pasadas
// TODO: 11/26/18 !! Ponerle fecha de hoy desde el inicio al TV
// TODO: 11/26/18 !! Formatear la fecha
// TODO: 11/26/18 !! Cuando se presione la flecha de atras, con el ícono, también ahi debe de pasar los intents

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class PurchaseStep4Activity extends AppCompatActivity {
    private Toolbar toolbar;
    private FloatingActionButton nextButton;
    private TextView tvDate;
    private CalendarView cvDate;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_step4);
        bindUi();

        toolbar.setNavigationIcon(R.drawable.back_shape);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), PurchaseStep3Activity.class));
            }
        });

        cvDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                date = i2+"/"+(i1 +1)+"/"+i;
                tvDate.setText(date);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNext();
            }
        });
    }

    private void bindUi() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        nextButton = (FloatingActionButton) findViewById(R.id.floatingActionButtonNext);
        cvDate = (CalendarView) findViewById(R.id.calendarView);
        tvDate = (TextView) findViewById(R.id.textViewDate);

    }

    private void goToNext() {
        Intent intent = new Intent(this, PurchaseStep5Activity.class);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            if (bundle.getString("tour") != null)
                intent.putExtra("tour", (bundle.getString("tour"))+"");
            else
                Toast.makeText(PurchaseStep4Activity.this, "Error 40: Elija tickets nuevamente", Toast.LENGTH_LONG).show();

            if (bundle.getString("kidsTickets") != null)
                intent.putExtra("kidsTickets", (bundle.getString("kidsTickets"))+"");
            else
                Toast.makeText(PurchaseStep4Activity.this, "Error 41: Elija tickets nuevamente", Toast.LENGTH_LONG).show();

            if (bundle.getString("adultsTickets") != null)
                intent.putExtra("adultsTickets", (bundle.getString("adultsTickets"))+"");
            else
                Toast.makeText(PurchaseStep4Activity.this, "Error 42: Elija tickets nuevamente", Toast.LENGTH_LONG).show();

            if (bundle.getString("seniorsTickets") != null)
                intent.putExtra("seniorsTickets", (bundle.getString("seniorsTickets"))+"");
            else
                Toast.makeText(PurchaseStep4Activity.this, "Error 43: Elija tickets nuevamente", Toast.LENGTH_LONG).show();

            if (bundle.getString("totalTickets") != null)
                intent.putExtra("totalTickets", (bundle.getString("totalTickets"))+"");
            else
                Toast.makeText(PurchaseStep4Activity.this, "Error 44: Elija tickets nuevamente", Toast.LENGTH_LONG).show();

            if (bundle.getString("total") != null)
                intent.putExtra("total", (bundle.getString("total"))+"");
            else
                Toast.makeText(PurchaseStep4Activity.this, "Error 45: Elija tickets nuevamente", Toast.LENGTH_LONG).show();

            intent.putExtra("date", date+"");

            startActivity(intent);
        }

    }
}