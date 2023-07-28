package com.example.product_data_navigation_drawer.Instance_class;

import com.example.product_data_navigation_drawer.Interface.API_Interface;
import com.example.product_data_navigation_drawer.Interface.API_Interface_1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Instance_class_1 {
    public  static API_Interface_1 ViewAPI(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://ashmitashop.000webhostapp.com/AshmitaShop/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(API_Interface_1.class);
    }
}
