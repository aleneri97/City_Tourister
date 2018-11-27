package com.example.alejandro_neri.city_tourister;

// TODO: ! Validación desde front de los inputs
// TODO: !! Implementar goToMain() de Login, en el sentido de que hay que hacer que no se pued regresar a esta pantalla

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class RegisterSecondActivity extends AppCompatActivity {

    EditText name;
    EditText last_name;
    EditText email;
    EditText password;
    EditText phone_number;
    EditText postal_code;
    EditText brithdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_second);

        name = (EditText) findViewById(R.id.editTextName) ;
        last_name = (EditText) findViewById(R.id.editTextLastName);
        email = (EditText)findViewById(R.id.editTextEmail);
        password = (EditText)findViewById(R.id.editTextPassword);
        phone_number = (EditText)findViewById(R.id.editTextPhoneNumber);
        postal_code = (EditText)findViewById(R.id.editTextPostalCode);
        brithdate = (EditText)findViewById(R.id.editTextBirthdate);

        name.setText(getIntent().getExtras().getString("Name"));
        last_name.setText(getIntent().getExtras().getString("LastName"));
        email.setText(getIntent().getExtras().getString("Email"));
        email.setEnabled(false);
    }

    private class RegisterManager extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuffer response = new StringBuffer();

            try {
                URL url = new URL(strings[0]);

                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setReadTimeout(15000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                HashMap<String, String> postParams = new HashMap<>();
                postParams.put("name", strings[1]);
                postParams.put("last_name", strings[2]);
                postParams.put("email", strings[3]);
                postParams.put("brithdate", strings[4]);
                postParams.put("password", strings[5]);
                postParams.put("postal_code", strings[6]);
                postParams.put("phone_number", strings[7]);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostString(postParams));
                writer.flush();
                writer.close();
                os.close();

                int responseCode = conn.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    response.append(R.string.succesfull_signup_toast);
                    Intent intent = new Intent(RegisterSecondActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else
                    response.append("");

            } catch (Exception e){
                e.printStackTrace();
            }

            return response.toString();

        }

        @Override
        protected void onPostExecute(String result){
            Toast.makeText(getBaseContext(), result, Toast.LENGTH_SHORT).show();
        }

        private String getPostString(HashMap<String, String> params) throws UnsupportedEncodingException {

            StringBuffer sb = new StringBuffer();
            boolean first = true;

            for (Map.Entry<String, String> entry: params.entrySet()) {
                if (first)
                    first = false;
                else
                    sb.append("&");

                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }

            return sb.toString();
        }
    }

    public void doRegister(View v) {
        new RegisterSecondActivity.RegisterManager().execute(String.valueOf(R.string.signup_api), name.getText().toString(), last_name.getText().toString(), email.getText().toString(), brithdate.getText().toString(), password.getText().toString(), postal_code.getText().toString(), phone_number.getText().toString());
    }
}
