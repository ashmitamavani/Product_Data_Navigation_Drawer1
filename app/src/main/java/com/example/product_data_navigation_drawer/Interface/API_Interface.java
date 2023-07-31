package com.example.product_data_navigation_drawer.Interface;

import com.example.product_data_navigation_drawer.Model.AddProduct_Model;
import com.example.product_data_navigation_drawer.Model.Viewuser_Model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API_Interface {
    @FormUrlEncoded
    @POST("AddProduct.php")
    Call<AddProduct_Model>
    signUpUser(@Field("uid") int uid,
               @Field("pname") String pname,
               @Field("pdes")String pprice,
               @Field("pprice")String pdes);


    @FormUrlEncoded
    @POST("viewProduct.php")
    Call<Viewuser_Model>
    viewProduct(@Field("userid") int uid);
}
