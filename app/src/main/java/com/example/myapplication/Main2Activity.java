package com.example.myapplication;

import android.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;



public class Main2Activity extends AppCompatActivity {

    Fragment fragment = new Weather();
    Fragment fragment1 = new City();
    Fragment fragment2 = new SavedCities();
    Fragment fragment3 = new Author();

    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

        final android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        FragmentTransaction replace = (FragmentTransaction) fragmentTransaction.replace(R.id.container, fragment);
        replace.commit();
        final DrawerLayout  mDrawerLayout = findViewById(R.id.my_drawer_layout);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();

                int idItem = menuItem.getItemId();
                if (idItem == R.id.select_cities) {
                    fragmentTransaction.replace(R.id.container, fragment1);
                } else if (idItem == R.id.weather) {
                    fragmentTransaction.replace(R.id.container, fragment);
                } else if (idItem == R.id.saved_cities) {
                    fragmentTransaction.replace(R.id.container, fragment2);

                } else if (idItem == R.id.author) {
                    fragmentTransaction.replace(R.id.container, fragment3);
                }

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                return true;
            }

        });

    }
}
