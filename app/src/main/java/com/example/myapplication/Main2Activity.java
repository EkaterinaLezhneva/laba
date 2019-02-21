package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    Intent myIntent;
    TextView nameUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

        myIntent = getIntent();
        nameUser = findViewById(R.id.nameUser);

        if(myIntent != null){
            String name = myIntent.getStringExtra("nameUser");
            nameUser.setText(name);
        }
    }
}
