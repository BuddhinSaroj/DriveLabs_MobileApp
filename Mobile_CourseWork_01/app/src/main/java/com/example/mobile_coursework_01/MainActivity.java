package com.example.mobile_coursework_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void identifyCarMakeOnClick(View view) {
        intent = new Intent(MainActivity.this,IdentifyTheCarMake.class);
        startActivity(intent);
    }

    public void hintOnClick(View view) {
        intent = new Intent(MainActivity.this,HintsGuessing.class);
        startActivity(intent);
    }

    public void identifyCarImgOnClick(View view) {
        intent = new Intent(MainActivity.this,IdentifyCarImg.class);
        startActivity(intent);
    }

    public void advancedLevelOnclick(View view) {
        intent = new Intent(MainActivity.this,AdvancedLevel.class);
        startActivity(intent);
    }
}