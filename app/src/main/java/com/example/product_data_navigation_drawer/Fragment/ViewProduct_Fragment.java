package com.example.product_data_navigation_drawer.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.product_data_navigation_drawer.R;

public class ViewProduct_Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

               View view=inflater.inflate(R.layout.fragment_view_product_, container, false);
               return view;
    }
}