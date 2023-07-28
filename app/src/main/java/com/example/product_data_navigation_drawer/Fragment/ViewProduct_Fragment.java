package com.example.product_data_navigation_drawer.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.product_data_navigation_drawer.Instance_class.Instance_class;
import com.example.product_data_navigation_drawer.Instance_class.Instance_class_1;
import com.example.product_data_navigation_drawer.Model.Productdata_Model;
import com.example.product_data_navigation_drawer.Model.Viewuser_Model;
import com.example.product_data_navigation_drawer.R;
import com.example.product_data_navigation_drawer.Recyclerview_Adapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewProduct_Fragment extends Fragment {
        AppCompatEditText editText_uid;
        Button button;
        RecyclerView recyclerView;
        int id;
        JSONArray jsonArray;
    ArrayList<Productdata_Model> productdata=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

               View view=inflater.inflate(R.layout.fragment_view_product_, container, false);
               editText_uid=view.findViewById(R.id.edittext_uid);
               button=view.findViewById(R.id.button);
               recyclerView=view.findViewById(R.id.recyclerview);
               recyclerView.setLayoutManager(new LinearLayoutManager(ViewProduct_Fragment.this.getContext()));
               button.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       id=editText_uid.getText().length();

                       Instance_class_1.ViewAPI().ViewUser(id).enqueue(new Callback<Viewuser_Model>() {
                           @Override
                           public void onResponse(Call<Viewuser_Model> call, Response<Viewuser_Model> response) {
                               Log.d("TTT", "onResponse: "+response.body());
                               if (response.body().getConnection()==1&&response.body().getResult()==1) {

                                   for (int i = 0; i < productdata.size(); i++) {

                                       JSONObject productobj= null;
                                       try {
                                           productobj = jsonArray.getJSONObject(i);
                                           String ID=productobj.getString("ID");
                                           String UID=productobj.getString("UID");
                                           String PNAME=productobj.getString("PNAME");
                                           String PDES=productobj.getString("PDES");
                                           String PPRICE=productobj.getString("PPRICE");
                                           String PIMG=productobj.getString("PIMG");
                                           Productdata_Model productData = new Productdata_Model(ID,UID,PNAME,PDES,PPRICE,PIMG);
                                           productdata.add(productData);
                                           Log.d("TTT", "onResponse: data"+productdata);
                                       } catch (JSONException e) {
                                           throw new RuntimeException(e);
                                       }
                                   }
                                   Recyclerview_Adapter adapter=new Recyclerview_Adapter(ViewProduct_Fragment.this,productdata);
                                   recyclerView.setAdapter(adapter);
                                   Toast.makeText(ViewProduct_Fragment.this.getContext(), "Data Found...", Toast.LENGTH_LONG).show();
                               }
                                   else
                                   {
                                       Log.d("TTT", "onResponse: No Data Found...");
                                       Toast.makeText(ViewProduct_Fragment.this.getContext(), "No Data Found...", Toast.LENGTH_LONG).show();
                                   }
                               }


                           @Override
                           public void onFailure(Call<Viewuser_Model> call, Throwable t) {
                               Log.e("TTT", "onFailure: "+t.getLocalizedMessage());
                           }
                       });

                   }
               });

               return view;
    }
}