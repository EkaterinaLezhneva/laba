package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {

    Intent myIntent;
    TextView nameUser;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

        myIntent = getIntent();
        nameUser = findViewById(R.id.nameUser);
        mDrawerLayout = findViewById(R.id.my_drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Fragment myfragment = new Fragment();
                Class fragmentClass = null;
                int idItem = menuItem.getItemId();
                if (idItem == R.id.select_cities) {
                    fragmentClass = City.class;

                } else if (idItem == R.id.weather) {
                    fragmentClass = Weather.class;
                } else if (idItem == R.id.saved_cities) {
                    fragmentClass = SavedCities.class;

                } else if (idItem == R.id.author) {
                    fragmentClass = Author.class;
                }


                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, new Fragment()).commit();
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }

        });


        if (myIntent != null) {
            String name = myIntent.getStringExtra("nameUser");
            nameUser.setText(name);
        }
    }
}
