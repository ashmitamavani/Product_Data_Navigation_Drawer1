package com.example.product_data_navigation_drawer.Interface;

import com.example.product_data_navigation_drawer.Model.Model;
import com.example.product_data_navigation_drawer.Model.Viewuser_Model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API_Interface_1 {
    @FormUrlEncoded
    @POST("ViewProduct.php")
    Call<Viewuser_Model>
    ViewUser(@Field("uid") int uid);
}
