package com.example.luca.imexal;

/**
 * Created by Luca on 08/02/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        Button btnHome=(Button)findViewById(R.id.bottone1);
        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent openPage1=new Intent(MainActivity.this,Pagina1.class);
                startActivity(openPage1);
            }
        });
    }
}
