package com.example.luca.imexal;

/**
 * Created by Luca on 08/02/2017.
 */


import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
   private static final String TAG="MainActivity";

    static RelativeLayout layout;
    Intent intent;
    RecyclerView businessCardsRv;
    LinearLayoutManager layoutManager;
    BusinessCardAdapter adapter;
    private static final String ELIS_ADDRESS = "via Sandro Sandri 71";
    public static final String USER_NAME="Username";


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_people);
        layout=(RelativeLayout) findViewById(R.id.people_layout);
        intent=getIntent();


        businessCardsRv=(RecyclerView) findViewById(R.id.business_card_rv);
        layoutManager=new LinearLayoutManager(this);
        adapter=new BusinessCardAdapter();
        businessCardsRv.setLayoutManager(layoutManager);
        businessCardsRv.setAdapter(adapter);
        adapter.setDataSet(getBusinessCards());

        findViewById(R.id.add_student).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddStudentDialog();
            }
        });

    }







    public void showAddStudentDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_student_add, null);
        dialogBuilder.setView(dialogView);

        final EditText studentName = (EditText) dialogView.findViewById(R.id.dialog_student_name);
        final EditText studentEmail = (EditText) dialogView.findViewById(R.id.dialog_student_email);
        final EditText studentPhone = (EditText) dialogView.findViewById(R.id.dialog_student_phone);

        dialogBuilder.setTitle("student");
        dialogBuilder.setMessage("insert_student_name");
        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();

                BusinessCard businessCard = new BusinessCard(studentName.getText().toString(),
                        studentEmail.getText().toString(),studentPhone.getText().toString(),ELIS_ADDRESS);
                adapter.addBusinessCard(businessCard);
                businessCardsRv.scrollToPosition(0);

            }
        });
        dialogBuilder.setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Log.d(TAG,"onStart");

    }

    private ArrayList<BusinessCard> getBusinessCards() {
        ArrayList<BusinessCard> businessCards = new ArrayList<>();
        BusinessCard francescoBC = new BusinessCard("Francesco Cipolla", "francescocpll@gmail.com", "333281213", ELIS_ADDRESS);
        BusinessCard matteoBC = new BusinessCard("Matteo Manfreda", "manfredamatteo44@gmail.com", "348974379",  ELIS_ADDRESS);
        BusinessCard micheleBC = new BusinessCard("Michele Foderaro", "michele.foderaro@virgilio.it", "3891379123",  ELIS_ADDRESS);
        BusinessCard domenicoBC = new BusinessCard("Domenico Licciardi", "licciardi.domenico98@gmail.com", "333281213", ELIS_ADDRESS);
        BusinessCard gaetanoBC = new BusinessCard("Gaetano Ciccone", "gaetano.ciccone97@gmail.com", "333281213",  ELIS_ADDRESS);

        businessCards.add(francescoBC);
        businessCards.add(matteoBC);
        businessCards.add(micheleBC);
        businessCards.add(domenicoBC);
        businessCards.add(gaetanoBC);

        return businessCards;


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        BusinessCard bc=adapter.dataSet.get(data.getIntExtra("posizione",-1));
        bc.setName(data.getExtras().getString("result"));
        adapter.notifyItemChanged(data.getIntExtra("posizione",-1));
    }
}
