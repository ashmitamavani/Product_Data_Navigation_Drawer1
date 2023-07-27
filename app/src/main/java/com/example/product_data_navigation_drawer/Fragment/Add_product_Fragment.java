package com.example.product_data_navigation_drawer.Fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.product_data_navigation_drawer.Activity.MainActivity;
import com.example.product_data_navigation_drawer.Instance_class;
import com.example.product_data_navigation_drawer.R;
import com.example.product_data_navigation_drawer.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Add_product_Fragment extends Fragment {
    AppCompatEditText uid, pname, pprice, pdes;
    ImageView pimg;
    Button button;
    String n1, n2, n3, n4;
    Uri image_uri;
    String imagename;
    String imagepath;
    Bitmap bitmap;
    int id;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_add_product_, container, false);
        uid = view.findViewById(R.id.uid);
        pname = view.findViewById(R.id.pname);
        pdes = view.findViewById(R.id.pdes);
        pprice = view.findViewById(R.id.pprice);
        pimg = view.findViewById(R.id.pimg);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id=uid.getText().length();
                n1=pname.getText().toString();
                n2=pprice.getText().toString();
                n3=pdes.getText().toString();

                Instance_class.callAPI().signUpUser(id,""+n1,""+n2,""+n3).enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        Log.d("TTT", "onResponse: "+response.body());
                        if (response.body().getConnection()==1)
                        {
                            if (response.body().getProductadd()==1)
                            {
                                Log.d("TTT", "Registered..");
                                Toast.makeText(Add_product_Fragment.this.getContext(), "User Registered", Toast.LENGTH_LONG).show();
                            }
                            else if (response.body().getProductadd() == 2) {

                                Log.d("TTT", "User already Registered");
                                Toast.makeText(Add_product_Fragment.this.getContext(), "User already Registered", Toast.LENGTH_LONG).show();
                            } else {
                                Log.d("TTT", "Not Registered..");
                                Toast.makeText(Add_product_Fragment.this.getContext(), "User not Registered", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Log.d("TTT", "Something went Wrong..!");
                            Toast.makeText(Add_product_Fragment.this.getContext(), "Something went Wrong..!", Toast.LENGTH_LONG).show();
                        }
                    }




                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.e("TTT", "onFailure: "+t.getLocalizedMessage());

                    }
                });
            }
        });
        return view;
    }

}


