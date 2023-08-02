package com.example.product_data_navigation_drawer.Fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.product_data_navigation_drawer.Instance_class.Instance_class;
import com.example.product_data_navigation_drawer.R;
import com.example.product_data_navigation_drawer.Model.AddProduct_Model;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Add_product_Fragment extends Fragment {
    AppCompatEditText uid, pname, pprice, pdes;
    ImageView pimg;

    Button Addbutton,btn_updtProduct;
    String n1, n2, n3;
    Uri resultUri;


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
        Addbutton = view.findViewById(R.id.Addbutton);

        pimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CropImage.activity()
                        .start(getContext(), Add_product_Fragment.this);
            }
        });

        Addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = uid.getText().length();
                n1 = pname.getText().toString();
                n2 = pdes.getText().toString();
                n3 = pprice.getText().toString();

                Bitmap bitmap=((BitmapDrawable)pimg.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos); // bm is the bitmap object
                byte[] b = baos.toByteArray();


                // Get the Base64 string
                String imgString = Base64.encodeToString(b, Base64.DEFAULT);

                Log.d("UUU", "onClick: imgString="+imgString);

                Instance_class.callAPI().signUpUser(id,n1,n2,n3,imgString).enqueue(new Callback<AddProduct_Model>() {
                    @Override
                    public void onResponse(Call<AddProduct_Model> call, Response<AddProduct_Model> response) {
                        Log.d("TTT", "onResponse: " + response.body());
                        if (response.body().getConnection() == 1&&response.body().getProductaddd() == 1) {


                            Log.d("TTT", "Registered..");
                            Toast.makeText(Add_product_Fragment.this.getContext(), "User Registered", Toast.LENGTH_LONG).show();
                        } else if (response.body().getProductaddd()==0) {

                            Log.d("TTT", "Product not added");
                            Toast.makeText(Add_product_Fragment.this.getContext(), "Product not added", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Log.d("TTT", "Something went wrong.");
                            Toast.makeText(Add_product_Fragment.this.getContext(), "Something went wrong..", Toast.LENGTH_LONG).show();
                        }
                    }


                    @Override
                    public void onFailure(Call<AddProduct_Model> call, Throwable t) {
                        Log.e("TTT", "onFailure: " + t.getLocalizedMessage());

                    }
                });
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                resultUri = result.getUri();
                pimg.setImageURI(resultUri);

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}


