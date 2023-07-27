package com.example.product_data_navigation_drawer.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.product_data_navigation_drawer.Fragment.Add_product_Fragment;
import com.example.product_data_navigation_drawer.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
      DrawerLayout drawer_Layout;
      Toolbar toolbar;
     NavigationView navigation_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer_Layout=findViewById(R.id.drawer_layout);
        toolbar=findViewById(R.id.toolbar);
        navigation_View=findViewById(R.id.navigation_view);


        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawer_Layout,toolbar,R.string.Open_Drawer,R.string.Close_Drawer);
        drawer_Layout.addDrawerListener(toggle);
        toggle.syncState();
        navigation_View.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if (id==R.id.addproduct)
                {
                    addFragment(new Add_product_Fragment());
                }
                if (id==R.id.viewproduct)
                {

                }
                if (id==R.id.deleteproduct)
                {

                }
                if (id==R.id.updateproduct)
                {

                }
                drawer_Layout.close();
                return true;
            }

            private void addFragment(Fragment fragment) {
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.content_view,fragment);
                transaction.commit();
            }
        });
    }
}