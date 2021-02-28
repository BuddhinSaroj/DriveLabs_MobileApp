package com.example.mobile_coursework_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import es.dmoral.toasty.Toasty;

public class IdentifyTheCarMake extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    TextView txt_correction;
    TextView timerView;
    Button btn_identify_next;
    ImageView imageView;
    int random_car;
    String carId;
    String carMake;
    boolean switchedOn;
    CountDownTimer countdownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_the_car_make);
        txt_correction = findViewById(R.id.txt_carName);
        btn_identify_next = findViewById(R.id.btn_identify);
        timerView = findViewById(R.id.timerView);
        Intent intent = getIntent();
        switchedOn = intent.getBooleanExtra("isChecked",false);
        randomCarImage();
        timeFunction();
        // Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            random_car = savedInstanceState.getInt("random_car");
            String carImage = "img_" + random_car;
            imageView.setImageDrawable(getResources().getDrawable(getID(carImage)));
            btn_identify_next.setText(savedInstanceState.getString("next_button"));
            txt_correction.setText(savedInstanceState.getString("text_correction"));

        }
    }

    public void timeFunction(){
        if(switchedOn){
             countdownTimer = new CountDownTimer(20000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    timerView.setText(""+millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                    function();
                }
            }.start();

        }

        spinner = findViewById(R.id.spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cars_arrayList, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    private void randomCarImage() {
        Random random = new Random();
        random_car = 1+random.nextInt(30);
        imageView = (ImageView) findViewById(R.id.random_imageView);
        carId = "img_" + random_car;
        imageView.setImageDrawable(getResources().getDrawable(getID(carId)));
    }

    private int getID(String carId) {//from stackOverFlow
        int ResourceID = getResources().getIdentifier(carId,"drawable",getPackageName());
        if (ResourceID == 0) {
            throw new IllegalArgumentException(
                    "No resource string found with name : " + carId
            );
        }
        else {
            return ResourceID;
        }
    }
    public void identifyButtonOnClick(View view) {
        if(countdownTimer != null) {
            countdownTimer.cancel();
            countdownTimer = null;
        }
        function();
    }

    public void function(){
        timerView.setText("");
        if(btn_identify_next.getText().equals("Identify")){
            carMake = spinner.getSelectedItem().toString();
            if(random_car >= 1 && random_car <= 5){
                if(carMake.equals("Audi")){
                    Toasty.success(this,"Correct ! ", Toast.LENGTH_LONG).show();
                }
                else {
                    Toasty.error(this,"Wrong ! ",Toast.LENGTH_LONG).show();
                    txt_correction.setText("Correct answer is : Audi");
                }
            }
            else if(random_car >= 6 && random_car <= 8){
                if(carMake.equals("BMW")){
                    Toasty.success(this,"Correct ! ", Toast.LENGTH_LONG).show();
                }
                else {
                    Toasty.error(this,"Wrong ! ",Toast.LENGTH_LONG).show();
                    txt_correction.setText("Correct answer is : BMW");
                }
            }
            else if(random_car >= 9 && random_car <= 13){
                if(carMake.equals("Honda")){
                    Toasty.success(this,"Correct ! ", Toast.LENGTH_LONG).show();
                }
                else {
                    Toasty.error(this,"Wrong ! ",Toast.LENGTH_LONG).show();
                    txt_correction.setText("Correct answer is : Honda");
                }
            }
            else if(random_car >= 14 && random_car <= 16){
                if(carMake.equals("Mercedes")){
                    Toasty.success(this,"Correct ! ", Toast.LENGTH_LONG).show();
                }
                else {
                    Toasty.error(this,"Wrong ! ",Toast.LENGTH_LONG).show();
                    txt_correction.setText("Correct answer is : Mercedes");
                }
            }
            else if(random_car >= 17 && random_car <= 19){
                if(carMake.equals("Nissan")){
                    Toasty.success(this,"Correct ! ", Toast.LENGTH_LONG).show();
                }
                else {
                    Toasty.error(this,"Wrong ! ",Toast.LENGTH_LONG).show();
                    txt_correction.setText("Correct answer is : Nissan");
                }
            }
            else if(random_car >= 20 && random_car <= 21){
                if(carMake.equals("Peugeot")){
                    Toasty.success(this,"Correct ! ", Toast.LENGTH_LONG).show();
                }
                else {
                    Toasty.error(this,"Wrong ! ",Toast.LENGTH_LONG).show();
                    txt_correction.setText("Correct answer is : Peugeot");
                }
            }
            else if(random_car >= 22 && random_car <= 24){
                if(carMake.equals("Suzuki")){
                    Toasty.success(this,"Correct ! ", Toast.LENGTH_LONG).show();
                }
                else {
                    Toasty.error(this,"Wrong ! ",Toast.LENGTH_LONG).show();
                    txt_correction.setText("Correct answer is : Suzuki");
                }
            }
            else if(random_car >= 25 && random_car <= 26){
                if(carMake.equals("Tesla")){
                    Toasty.success(this,"Correct ! ", Toast.LENGTH_LONG).show();
                }
                else {
                    Toasty.error(this,"Wrong ! ",Toast.LENGTH_LONG).show();
                    txt_correction.setText("Correct answer is : Tesla");
                }
            }
            else if(random_car >= 27 && random_car <= 31){
                if(carMake.equals("Toyota")){
                    Toasty.success(this,"Correct ! ", Toast.LENGTH_LONG).show();
                }
                else {
                    Toasty.error(this,"Wrong ! ",Toast.LENGTH_LONG).show();
                    txt_correction.setText("Correct answer is : Toyota");
                }
            }
            btn_identify_next.setText("Next");
        }
        else if(btn_identify_next.getText().equals("Next")){
            if (switchedOn){
                timeFunction();
            }
            btn_identify_next.setText("Identify");
            txt_correction.setText("");
            randomCarImage();
            spinner = findViewById(R.id.spinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cars_arrayList, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("random_car",random_car);
        outState.putString("next_button",btn_identify_next.getText().toString());
        outState.putString("text_correction",txt_correction.getText().toString());
    }
}