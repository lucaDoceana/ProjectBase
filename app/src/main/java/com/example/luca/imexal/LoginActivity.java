package com.example.luca.imexal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Luca on 09/02/2017.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username;
    EditText password;

    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.login_user);
        password = (EditText) findViewById(R.id.login_pass);
        loginBtn = (Button) findViewById(R.id.login_Btn);
        loginBtn.setOnClickListener(this);
/*
        loginBtn.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
                String nome = username.getText().toString();          // si possono fare in ambo i metodi, cosi occupa più risorse ma  a volte è più utile
                String pass = password.getText().toString();
                if(okLogin(nome,pass)){
                Toast.makeText(LoginActivity.this, getString(R.string.Success), Toast.LENGTH_LONG).show();
            }}
        }); */
    }
        private boolean okLogin(String username, String password){
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.login_Btn){
        String nome = username.getText().toString();
        String pass = password.getText().toString();
        if(okLogin(nome,pass)){
            Toast.makeText(LoginActivity.this, getString(R.string.Success), Toast.LENGTH_LONG).show();
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        }
    }
}

