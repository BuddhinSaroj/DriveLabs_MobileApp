package com.example.mobile_coursework_01;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;


public class IdentifyTheCarMake extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private TextView txt_correction;
    private TextView timerView;
    private TextView correctOrIncorrect;
    private Button btn_identify_next;
    private ImageView imageView;
    private int random_car;
    private String carId;
    private String carMake;
    private boolean switchedOn;
    private CountDownTimer countdownTimer;
    private boolean isTimerOn = true;
    private long milliSecondsCount= 20000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_the_car_make);
        txt_correction = findViewById(R.id.txt_carName);
        btn_identify_next = findViewById(R.id.btn_identify);
        timerView = findViewById(R.id.timerView);
        correctOrIncorrect = findViewById(R.id.correctOrWrong);
        Intent intent = getIntent();
        switchedOn = intent.getBooleanExtra("isChecked",false);
        randomCarImage();
        // Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            random_car = savedInstanceState.getInt("random_car");
            String carImage = "img_" + random_car;
            imageView.setImageDrawable(getResources().getDrawable(getID(carImage)));
            btn_identify_next.setText(savedInstanceState.getString("next_button"));
            txt_correction.setText(savedInstanceState.getString("text_correction"));
            correctOrIncorrect.setText(savedInstanceState.getString("correctOrIncorrectTxt"));
            correctOrIncorrect.setTextColor(savedInstanceState.getInt("correctOrIncorrectColor"));
            isTimerOn = savedInstanceState.getBoolean("isTimerOn");
            milliSecondsCount = savedInstanceState.getLong("timerValue");

        }
        timeFunction();
    }

    public void timeFunction(){
        if (isTimerOn) {
            if (switchedOn) {
                countdownTimer = new CountDownTimer(milliSecondsCount, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        milliSecondsCount = millisUntilFinished;
                        isTimerOn = true;
                        timerView.setText("" + millisUntilFinished / 1000);
                    }

                    @Override
                    public void onFinish() {
                        isTimerOn = false;
                        function();
                    }
                }.start();

            }
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
            //milliSecondsCount = 0;
            isTimerOn = false;
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
                    correctOrIncorrect.setTextColor(Color.parseColor("#00FF00"));
                    correctOrIncorrect.setText("CORRECT!");
                }
                else {
                    correctOrIncorrect.setTextColor(Color.parseColor("#f01c05"));
                    correctOrIncorrect.setText("WRONG ! ");
                    txt_correction.setText("Correct answer is : Audi");
                }
            }
            else if(random_car >= 6 && random_car <= 8){
                if(carMake.equals("BMW")){
                    correctOrIncorrect.setTextColor(Color.parseColor("#00FF00"));
                    correctOrIncorrect.setText("CORRECT!");
                }
                else {
                    correctOrIncorrect.setTextColor(Color.parseColor("#f01c05"));
                    correctOrIncorrect.setText("WRONG ! ");
                    txt_correction.setText("Correct answer is : BMW");
                }
            }
            else if(random_car >= 9 && random_car <= 13){
                if(carMake.equals("Honda")){
                    correctOrIncorrect.setTextColor(Color.parseColor("#00FF00"));
                    correctOrIncorrect.setText("CORRECT!");
                }
                else {
                    correctOrIncorrect.setTextColor(Color.parseColor("#f01c05"));
                    correctOrIncorrect.setText("WRONG ! ");
                    txt_correction.setText("Correct answer is : Honda");
                }
            }
            else if(random_car >= 14 && random_car <= 16){
                if(carMake.equals("Mercedes")){
                    correctOrIncorrect.setTextColor(Color.parseColor("#00FF00"));
                    correctOrIncorrect.setText("CORRECT!");
                }
                else {
                    correctOrIncorrect.setTextColor(Color.parseColor("#f01c05"));
                    correctOrIncorrect.setText("WRONG ! ");
                    txt_correction.setText("Correct answer is : Mercedes");
                }
            }
            else if(random_car >= 17 && random_car <= 19){
                if(carMake.equals("Nissan")){
                    correctOrIncorrect.setTextColor(Color.parseColor("#00FF00"));
                    correctOrIncorrect.setText("CORRECT!");
                }
                else {
                    correctOrIncorrect.setTextColor(Color.parseColor("#f01c05"));
                    correctOrIncorrect.setText("WRONG ! ");
                    txt_correction.setText("Correct answer is : Nissan");
                }
            }
            else if(random_car >= 20 && random_car <= 21){
                if(carMake.equals("Peugeot")){
                    correctOrIncorrect.setTextColor(Color.parseColor("#00FF00"));
                    correctOrIncorrect.setText("CORRECT!");
                }
                else {
                    correctOrIncorrect.setTextColor(Color.parseColor("#f01c05"));
                    correctOrIncorrect.setText("WRONG ! ");
                    txt_correction.setText("Correct answer is : Peugeot");
                }
            }
            else if(random_car >= 22 && random_car <= 24){
                if(carMake.equals("Suzuki")){
                    correctOrIncorrect.setTextColor(Color.parseColor("#00FF00"));
                    correctOrIncorrect.setText("CORRECT!");
                }
                else {
                    correctOrIncorrect.setTextColor(Color.parseColor("#f01c05"));
                    correctOrIncorrect.setText("WRONG ! ");
                    txt_correction.setText("Correct answer is : Suzuki");
                }
            }
            else if(random_car >= 25 && random_car <= 26){
                if(carMake.equals("Tesla")){
                    correctOrIncorrect.setTextColor(Color.parseColor("#00FF00"));
                    correctOrIncorrect.setText("CORRECT!");
                }
                else {
                    correctOrIncorrect.setTextColor(Color.parseColor("#f01c05"));
                    correctOrIncorrect.setText("WRONG ! ");
                    txt_correction.setText("Correct answer is : Tesla");
                }
            }
            else if(random_car >= 27 && random_car <= 31){
                if(carMake.equals("Toyota")){
                    correctOrIncorrect.setTextColor(Color.parseColor("#00FF00"));
                    correctOrIncorrect.setText("CORRECT!");
                }
                else {
                    correctOrIncorrect.setTextColor(Color.parseColor("#f01c05"));
                    correctOrIncorrect.setText("WRONG ! ");
                    txt_correction.setText("Correct answer is : Toyota");
                }
            }
            btn_identify_next.setText("Next");
        }
        else if(btn_identify_next.getText().equals("Next")){
            correctOrIncorrect.setText("");
            if (switchedOn){
                milliSecondsCount = 20000;
                isTimerOn = true;
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
        outState.putString("correctOrIncorrectTxt", correctOrIncorrect.getText().toString());
        outState.putInt("correctOrIncorrectColor", correctOrIncorrect.getCurrentTextColor());
        outState.putLong("timerValue",milliSecondsCount);
        outState.putBoolean("isTimerOn",isTimerOn);
    }
}