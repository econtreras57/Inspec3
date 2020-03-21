package com.example.presentation.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.inspec3.R;


public class Login1Activity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // chk stored userid
        // if valid go to next Activity

        // connect fields
        et_username = findViewById(R.id.username);
        et_password = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        // setup
        et_username.setText(getSharedPreferences("Name"));
        et_password.setText(getSharedPreferences("Password"));
        loginButton.setEnabled(true);

        // auto click
        onClick(findViewById(android.R.id.content)); // finishes this activity if isOK

        et_username.setError(null);
        et_password.setError(null);

        et_username.setText("");
        et_password.setText("");

        et_username.requestFocus();

    }

    public void onClick(View v) {

        // si ok, saluda, graba y termina
        if (validInput()) {
            setSharedPreferences("Name", et_username.getText().toString());
            setSharedPreferences("Password", et_password.getText().toString());

            String welcome = getString(R.string.welcome2) + " user";
            // TODO : initiate successful logged in experience
            Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();

//            finish();   // or next activity
            Intent intent = new Intent(this, Main1ListInspectionsActivity.class);
            startActivity(intent);      // intent

            finish();   // 2020-03-20

        } else {
            // sino, queda, pero anula datos
            setSharedPreferences("Name", "");
            setSharedPreferences("Password", "");

        }

        // para pruebas, vamos a malograr el password
//         setSharedPreferences("Password", "1234");

    }

    protected Boolean validInput() {

        // validar
        Boolean isOK = true;

        // password debe tener 6 char mínimo
        String password = et_password.getText().toString();
        if (password.length() < 6) {
            et_password.setError(getString(R.string.invalid_password));
            et_password.requestFocus();
            isOK = false;
        }

        // username debe ser email
        String username = et_username.getText().toString();
        if (!username.contains("@")) {
            et_username.setError(getString(R.string.invalid_username));
            et_username.requestFocus();
            isOK = false;
        }

        return isOK;
    }

    protected String getSharedPreferences(String key) {

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String value = sharedPref.getString(key, "");

        return value;
    }

    protected void setSharedPreferences(String key, String value) {

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.commit();


    }

}
