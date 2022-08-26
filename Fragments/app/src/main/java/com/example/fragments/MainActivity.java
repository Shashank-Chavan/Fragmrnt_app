package com.example.fragments;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.BatteryManager;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportFragmentManager().beginTransaction().add(R.id.show,new Show_Time()).commit();
        /*TextView text = findViewById(R.id.textView2);
        BatteryManager bm = (BatteryManager)getSystemService(BATTERY_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            int percentage = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
            text.setText("Battery Percentage is "+percentage+" %");
        }*/

        setupTime();
        setupDate();
        setupBattery();

    }
    protected void setupTime(){
        final Button B = findViewById(R.id.TimeButton);
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.container1,new Show_Time());
                fr.addToBackStack(null);
                fr.commit();
            }
        });
    }
    protected void setupDate(){
        final Button B = findViewById(R.id.DateButton);
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.container1,new Show_Date());
                fr.addToBackStack(null);
                fr.commit();
            }
        });
    }
    protected void setupBattery(){
        final Button B = findViewById(R.id.BatteryButton);
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.container1,new Battery());
                fr.addToBackStack(null);
                fr.commit();

            }
        });
    }

}