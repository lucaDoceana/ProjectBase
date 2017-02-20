package com.example.luca.imexal;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Luca on 17/02/2017.
 */

public class NameActivity extends AppCompatActivity implements View.OnClickListener {
    TextView nomeTV;
    EditText nomeMod;
    String nome;
    Button okMod;
    Intent intent;
    int posizione;
    String result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardname);
        intent=getIntent();
        nome=(intent.getStringExtra(MainActivity.USER_NAME));
        nomeTV = (TextView) findViewById(R.id.comparsa_nome);
        nomeMod = (EditText) findViewById(R.id.modif_name);
        nomeTV.setText(nome);
        posizione= intent.getExtras().getInt("posizione");

        okMod=(Button) findViewById(R.id.ok_btn);
        okMod.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        result= nomeMod.getText().toString();
        Intent i=new Intent();
        i.putExtra("result",result);
        i.putExtra("posizione",posizione);
        setResult(1,i);
        finish();
    }
}
