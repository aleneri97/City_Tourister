package com.example.alejandro_neri.city_tourister;

// TODO: !! Implementar redes sociales
// TODO: ! Validación desde front de los inputs<

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

public class RegisterFirstActivity extends AppCompatActivity {

    EditText email;
    EditText name;
    EditText last_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_first);

        bindUi();


    }

    private void bindUi() {
        email = (EditText)findViewById(R.id.editTextEmail);
        name = (EditText)findViewById(R.id.editTextName);
        last_name = (EditText)findViewById(R.id.editTextLastName);
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
                postParams.put("email", strings[1]);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostString(postParams));
                writer.flush();
                writer.close();
                os.close();

                int responseCode = conn.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    response.append(R.string.valid_signup_mail);
                    Intent intent = new Intent(RegisterFirstActivity.this, RegisterSecondActivity.class);
                    intent.putExtra("Name", name.getText().toString());
                    intent.putExtra("LastName", last_name.getText().toString());
                    intent.putExtra("Email", email.getText().toString());
                    startActivity(intent);
                }else
                    response.append(R.string.mail_exists_toast);

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
        new RegisterFirstActivity.RegisterManager().execute(String.valueOf(R.string.check_email_api), email.getText().toString());
    }
}
