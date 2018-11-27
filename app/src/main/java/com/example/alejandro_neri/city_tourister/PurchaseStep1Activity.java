package com.example.alejandro_neri.city_tourister;

// TODO: 11/26/18 ! Hacer que los tours sean RecyclerViews traídos desde el back
// TODO: 11/26/18 ! Hacer que sirvan los botones en las imagenes de las rutas

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PurchaseStep1Activity extends AppCompatActivity {
    private Toolbar toolbar;
    private FloatingActionButton nextButton;
    private RadioGroup radioGroup;
    private RadioButton rbSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_step1);

        bindUi();

        toolbar.setNavigationIcon(R.drawable.cross_shape);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                rbSelected = (RadioButton) findViewById(selectedId);

                if (rbSelected != null) {
                    int selectedTourID = rbSelected.getId();
                    String selectedTour;
                    switch (selectedTourID) {
                        case 2131361796:
                            selectedTour = "Puebla Fascinante";
                            break;
                        case 2131361797:
                            selectedTour = "Cholula Milenaria";
                            break;
                        case 2131361798:
                            selectedTour = "Puebla Iluminada";
                            break;
                        default:
                            selectedTour = "Lo sentimos, hubo un error, vuelva a seleccionar.";
                            break;
                    }
                    Intent intentMain = new Intent(PurchaseStep1Activity.this, PurchaseStep2Activity.class);
                    intentMain.putExtra("tour", selectedTour);
                    startActivity(intentMain);
                } else
                    Toast.makeText(PurchaseStep1Activity.this,"Tiene que seleccionar un tour", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void bindUi(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        nextButton = (FloatingActionButton) findViewById(R.id.floatingActionButtonNext);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }
}
