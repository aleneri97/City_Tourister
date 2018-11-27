package com.example.alejandro_neri.city_tourister;

// TODO: !!! Hacer login con redes sociales
// TODO: !! Implementar  goToMain(), la parte de que no puede regresar a este activity

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
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

public class LoginActivity extends AppCompatActivity {

    // 1. Declaramos las variables que necesitaremos
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnLogin;
    private SharedPreferences preferences;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);

        bindUI();
        setCredentialsIfExist();


        // Esta es la manera en la que le damos vida a un botón., En este ejemplo, lo hacemos con el boton de login y su respectivo efecto de validación
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (login(email,password)){
                    doLogin(btnLogin);
                    saveOnPreferences(email, password);
                }
            }
        });
    }

    // 2. Este método traerá los elementos de nuestra interfaz (XML), para que los podamos usar en el código
    private void bindUI(){
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        btnLogin = (Button) findViewById(R.id.buttonLogin);
        btnSignup = (Button) findViewById(R.id.buttonSignup);
    }

    // 6. el método servirá para recordar la sesión si esta fue iniciada.
    private void setCredentialsIfExist(){
        String email = Util.getUserEmail(preferences);
        String password = Util.getUserPassword(preferences);

        // si no están vacíos ninguno de los 2
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            editTextEmail.setText(email);
            editTextPassword.setText(password);
        }
    }

    // este método verifica que el correo y la contraeña sean válidas, solo en ese caso regresa true, de otro modo manda un toast y false
    private boolean login(String email, String password){
        if (!isValidEmail(email)){
            Toast.makeText(this, R.string.not_valid_email_toast, Toast.LENGTH_LONG).show();
            return false;
        } else if (!isValidPassword(password)){
            Toast.makeText(this, R.string.not_valid_password_toast, Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }

    // Este método verificará que el correo sea válida
    private boolean isValidEmail(String email){
        // verifica que no este vacío, Y que tenga los campos que le corresponden a un corre @ .
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // Este método verificará que la contraseña sea válida
    private boolean isValidPassword(String password){
        // Solamente verificará si esta es mayor a 4 caracteres
        return password.length() > 4;
    }

    // Este método es el que se encargará de cambiar al HomeActivity
    private void goToMain(){
        Intent intentMain = new Intent(this, HomeActivity.class);
        //en esta linea ordena que se le agreguen las banderas para que una vez que entró, no pueda regresar a esta
        intentMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intentMain);
    }

    // 5. Este método usa Shared Preferences para guardar la información del usuario.
    private void saveOnPreferences(String email, String password){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("email", email);
            editor.putString("password", password);
            // este se usaría si necesitaramos que no haga nada hasta que guardara todas las llaves y valores
            //editor.commit();
            editor.apply();

    }


    private class LoginManager extends AsyncTask<String, Void, String> {

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
                postParams.put("password", strings[2]);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostString(postParams));
                writer.flush();
                writer.close();
                os.close();

                int responseCode = conn.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    response.append(R.string.valid_login_toast );
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }else
                    response.append(R.string.not_valid_login_toast);

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

    public void doLogin(View v) {
        new LoginManager().execute(String.valueOf(R.string.login_api), editTextEmail.getText().toString(), editTextPassword.getText().toString());
    }

    public void goRegister(View v){
        Intent intent = new Intent(this, RegisterFirstActivity.class);
        startActivity(intent);
    }

}
