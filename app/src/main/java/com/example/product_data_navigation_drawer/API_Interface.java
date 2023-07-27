package com.example.product_data_navigation_drawer;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API_Interface {
    @FormUrlEncoded
    @POST("AddProduct.php")
    Call<Model>
    signUpUser(@Field("uid") int uid,
               @Field("pname") String pname,
               @Field("pprice")String pprice,
               @Field("pdes")String pdes);
}
