package com.example.product_data_navigation_drawer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.product_data_navigation_drawer.Fragment.ViewProduct_Fragment;
import com.example.product_data_navigation_drawer.Model.Productdata_Model;

import java.util.ArrayList;

public class Recyclerview_Adapter extends RecyclerView.Adapter<Recyclerview_Adapter.Holder> {
    ViewProduct_Fragment viewProduct_fragment;
    ArrayList<Productdata_Model> productdata;
    public Recyclerview_Adapter(ViewProduct_Fragment viewProduct_fragment, ArrayList<Productdata_Model> productdata) {
        this.viewProduct_fragment=viewProduct_fragment;
        this.productdata=productdata;
    }

    @NonNull
    @Override
    public Recyclerview_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(viewProduct_fragment.getContext()).inflate(R.layout.recyclerview_item_layout,parent,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerview_Adapter.Holder holder, int position) {
        holder.t1.setText(""+productdata.get(position).getID());
        holder.t2.setText(""+productdata.get(position).getUID());
        holder.t3.setText(""+productdata.get(position).getPNAME());
        holder.t4.setText(""+productdata.get(position).getPDES());
        holder.t5.setText(""+productdata.get(position).getPPRICE());
    }

    @Override
    public int getItemCount() {
        return productdata.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3,t4,t5;
        ImageView image;
        public Holder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.ID);
            t2=itemView.findViewById(R.id.UID);
            t3=itemView.findViewById(R.id.NAME);
            t4=itemView.findViewById(R.id.DES);
            t5=itemView.findViewById(R.id.PRICE);
            image=itemView.findViewById(R.id.img);
        }
        }
    }
