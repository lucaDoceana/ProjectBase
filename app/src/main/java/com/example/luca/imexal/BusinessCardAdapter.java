package com.example.luca.imexal;

/**
 * Created by Luca on 15/02/2017.
 */
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;


import static com.example.luca.imexal.R.id.sendE;

public class BusinessCardAdapter extends RecyclerView.Adapter<BusinessCardAdapter.BusinessCardVH> {

    public ArrayList<BusinessCard> dataSet=new ArrayList<>();

    public void addBusinessCard(BusinessCard bc){

        dataSet.add(0,bc);
        notifyItemInserted(0);
    }

    public void setDataSet(ArrayList<BusinessCard> dataSet){
       this.dataSet=dataSet;
        notifyDataSetChanged();
    }

    @Override
    public BusinessCardAdapter.BusinessCardVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_businesscard,parent,false);
        return new BusinessCardVH(view);
    }

    @Override
    public void onBindViewHolder(BusinessCardVH holder, int position) {
        BusinessCard businessCard= dataSet.get(position);
        holder.nameTv.setText((businessCard.getName()));
        holder.emailTv.setText(businessCard.getEmail());
        holder.addressTv.setText(businessCard.getAddress());
        holder.phoneNumberTv.setText(businessCard.getPhoneNumber());

    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }




    public class BusinessCardVH extends RecyclerView.ViewHolder implements View.OnClickListener{
       TextView nameTv, phoneNumberTv, emailTv, addressTv;
        Button btnCall, btnMail, btnMaps, btnInfo;

        public BusinessCardVH(View itemView) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.nomeJosef);
            emailTv = (TextView) itemView.findViewById(R.id.emJosef);
            phoneNumberTv = (TextView) itemView.findViewById(R.id.numJosef);
            addressTv = (TextView) itemView.findViewById(R.id.residentJosef);
            btnMail = (Button) itemView.findViewById(R.id.sendE);
            btnCall = (Button) itemView.findViewById(R.id.chiama);
            btnMaps = (Button) itemView.findViewById(R.id.mappa);
            btnInfo = (Button) itemView.findViewById(R.id.info_btn);
            btnMail.setOnClickListener(this);
            btnCall.setOnClickListener(this);
            btnMaps.setOnClickListener(this);
            btnInfo.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            if(v.getId()==R.id.info_btn){
              Intent i=new Intent(itemView.getContext(),NameActivity.class);
              i.putExtra(MainActivity.USER_NAME,nameTv.getText());
              i.putExtra("posizione", getAdapterPosition());
              Activity main=(Activity)itemView.getContext();
              main.startActivityForResult(i,1);

            }
            else if(v.getId()==R.id.sendE){
                Intent i=new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL, emailTv.getText().toString());
                v.getContext().startActivity(i);
            }
            else if (v.getId()==R.id.chiama){
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+phoneNumberTv.getText().toString()));
                v.getContext().startActivity(i);
            }
            else if(v.getId()==R.id.mappa){
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:0.0?q:"+addressTv.getText().toString()));
                v.getContext().startActivity(i);
            }
        }
    }
}
