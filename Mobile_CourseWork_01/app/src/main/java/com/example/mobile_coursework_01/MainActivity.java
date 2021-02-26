package com.example.mobile_coursework_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    Switch timer;
    boolean value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = findViewById(R.id.switch_timer);
    }

    public void identifyCarMakeOnClick(View view) {
        if (timer.isChecked()){
            value = true;
        }else {
            value = false;
        }
        intent = new Intent(MainActivity.this,IdentifyTheCarMake.class);
        intent.putExtra("isChecked",value);
        startActivity(intent);
    }

    public void hintOnClick(View view) {
        if (timer.isChecked()){
            value = true;
        }else {
            value = false;
        }
        intent = new Intent(MainActivity.this,HintsGuessing.class);
        intent.putExtra("isChecked",value);
        startActivity(intent);
    }

    public void identifyCarImgOnClick(View view) {
        if (timer.isChecked()){
            value = true;
        }else {
            value = false;
        }
        intent = new Intent(MainActivity.this,IdentifyCarImg.class);
        intent.putExtra("isChecked",value);
        startActivity(intent);
    }

    public void advancedLevelOnclick(View view) {
        if (timer.isChecked()){
            value = true;
        }else {
            value = false;
        }
        intent = new Intent(MainActivity.this,AdvancedLevel.class);
        intent.putExtra("isChecked",value);
        startActivity(intent);
    }
}