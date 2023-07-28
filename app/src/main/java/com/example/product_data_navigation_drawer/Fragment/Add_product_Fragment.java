package com.example.product_data_navigation_drawer.Fragment;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.product_data_navigation_drawer.Instance_class.Instance_class;
import com.example.product_data_navigation_drawer.R;
import com.example.product_data_navigation_drawer.Model.Model;

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
                id = uid.getText().length();
                n1 = pname.getText().toString();
                n2 = pdes.getText().toString();
                n3 = pprice.getText().toString();

                Instance_class.callAPI().signUpUser(id, "" + n1, "" + n2, "" + n3).enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        Log.d("TTT", "onResponse: " + response.body());
                        if (response.body().getConnection() == 1) {

                            if (response.body().getProductaddd() == 1) {

                                Log.d("TTT", "Registered..");
                                Toast.makeText(Add_product_Fragment.this.getContext(), "User Registered", Toast.LENGTH_LONG).show();
                            } else if (response.body().getProductaddd() == 2) {

                                Log.d("TTT", "User already Registered");
                                Toast.makeText(Add_product_Fragment.this.getContext(), "User already Registered", Toast.LENGTH_LONG).show();
                            } else
                            {
                                Log.d("TTT", "Not Registered..");
                                Toast.makeText(Add_product_Fragment.this.getContext(), "User not Registered", Toast.LENGTH_LONG).show();
                            }
                        } else
                        {
                            Log.d("TTT", "Something went Wrong..!");
                            Toast.makeText(Add_product_Fragment.this.getContext(), "Something went Wrong..!", Toast.LENGTH_LONG).show();
                        }
                    }


                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.e("TTT", "onFailure: " + t.getLocalizedMessage());

                    }
                });
            }
        });
        return view;
    }

}


