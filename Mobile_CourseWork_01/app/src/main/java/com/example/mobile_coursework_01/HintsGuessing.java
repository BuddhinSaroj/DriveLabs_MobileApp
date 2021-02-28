package com.example.mobile_coursework_01;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import es.dmoral.toasty.Toasty;

public class HintsGuessing extends AppCompatActivity {
    int random_car;
    String carId;
    String carModel;
    TextView txt_characters;
    EditText inputTxt;
    Button submitBtn;
    TextView answers;
    TextView exceeded;
    int greenColorValue = Color.parseColor("#23cc1b");
    int yellowColorValue = Color.parseColor("#e3ff00");
    boolean switchedOn;
    CountDownTimer countdownTimer;
    TextView timerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hints_guessing);
        Intent intent = getIntent();
        switchedOn = intent.getBooleanExtra("isChecked",false);
        txt_characters = findViewById(R.id.txt_hint);
        inputTxt = findViewById(R.id.input_char);
        submitBtn = findViewById(R.id.btn_submit);
        answers = findViewById(R.id.answer);
        exceeded = findViewById(R.id.exceed);
        timerView = findViewById(R.id.timerView3);
        randomCarImage();
        charSpacings();
        timeFunction();
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
                    Toasty.warning(getApplicationContext(), "Time exceeded click on next button", Toast.LENGTH_LONG).show();
                    answers.setTextColor(Color.parseColor("#23cc1b"));
                    answers.setText("Correct answer is : " + carModel);
                    submitBtn.setText("Next");
                }
            }.start();

        }
    }
    private void randomCarImage() {
        Random random = new Random();
        random_car =1+ random.nextInt(30);
        ImageView imageView = (ImageView) findViewById(R.id.random_imageView2);
        carId= "img_" + random_car;
        imageView.setImageDrawable(getResources().getDrawable(getID(carId,"drawable",getApplicationContext())));
    }

    private int getID(String carId, String drawable, Context applicationContext) {
        int ResourceID = applicationContext.getResources().getIdentifier(carId, drawable, applicationContext.getApplicationInfo().packageName);
        if (ResourceID == 0) {
            throw new IllegalArgumentException(
                    "No resource string found with name : " + carId
            );
        }
        else {
            return ResourceID;
        }
    }
    private void charSpacings(){
        if (carId.equals("img_1")||carId.equals("img_2")||carId.equals("img_3")||carId.equals("img_4")||carId.equals("img_5")){
            txt_characters.setText("----");
            carModel = "AUDI";
        }
        else if (carId.equals("img_6")||carId.equals("img_7")||carId.equals("img_8")){
            txt_characters.setText("---");
            carModel = "BMW";
        }
        else if (carId.equals("img_9")||carId.equals("img_10")||carId.equals("img_11")||carId.equals("img_12")||carId.equals("img_13")){
            txt_characters.setText("-----");
            carModel = "HONDA";
        }
        else if (carId.equals("img_14")||carId.equals("img_15")||carId.equals("img_16")){
            txt_characters.setText("--------");
            carModel = "MERCEDES";
        }
        else if (carId.equals("img_17")||carId.equals("img_18")||carId.equals("img_19")){
            txt_characters.setText("------");
            carModel = "NISSAN";
        }
        else if (carId.equals("img_20")||carId.equals("img_21")){
            txt_characters.setText("-------");
            carModel = "PEUGEOT";
        }
        else if (carId.equals("img_22")||carId.equals("img_23")||carId.equals("img_24")){
            txt_characters.setText("------");
            carModel = "SUZUKI";
        }
        else if (carId.equals("img_25")||carId.equals("img_26")){
            txt_characters.setText("-----");
            carModel = "TESLA";
        }
        else if (carId.equals("img_27")||carId.equals("img_28")||carId.equals("img_29")||carId.equals("img_30")||carId.equals("img_31")){
            txt_characters.setText("------");
            carModel = "TOYOTA";
        }
    }
    int attempts = 3;

    public void submit(View view) {
        function();
    }

    public void function(){

        String inputLetter = inputTxt.getText().toString().toUpperCase();
        String dash = txt_characters.getText().toString();
        Character character;

        if (!(carModel.contains(inputLetter)) && (attempts > 0)){
            --attempts;
            Toasty.error(this, "Incorrect letter", Toast.LENGTH_SHORT).show();
        }
        else if (attempts > 0 && submitBtn.getText().toString().equalsIgnoreCase("Submit")) {
            for (int i = 0; i < carModel.length(); i++) {
                character = carModel.charAt(i);
                if (character.toString().equalsIgnoreCase(inputLetter)) {
                    StringBuilder sb = new StringBuilder(dash);
                    sb.replace(i, i + 1, inputLetter);
                    txt_characters.setText(sb);
                    dash = sb.toString();
                }
            }if (carModel.equalsIgnoreCase(dash)){
                Toasty.success(this, "CORRECT!", Toast.LENGTH_SHORT).show();
                if(countdownTimer != null) {//if user guess the correct answer,and that code used to stop current running time.
                    countdownTimer.cancel();
                    countdownTimer = null;
                }
                submitBtn.setText("Next");
            }
        }
        else if (attempts <= 0 && submitBtn.getText().toString().equalsIgnoreCase("Submit")){//if user guess the incorrect letter or left maximum attempts
            if(countdownTimer != null) {//that code used to stop current running time.
                countdownTimer.cancel();
                countdownTimer = null;
            }
            exceeded.setTextColor(yellowColorValue);
            exceeded.setText("Oooops ! Your attempts are left");
            answers.setTextColor(greenColorValue);
            answers.setText("Correct answer is : " + carModel);
            Toasty.error(this, "WRONG!", Toast.LENGTH_LONG).show();
            submitBtn.setText("Next");
            inputTxt.setText("");
        }

        else if(submitBtn.getText().toString().equalsIgnoreCase("Next")){
            submitBtn.setText("Submit");
            exceeded.setText("");
            answers.setText("");
            inputTxt.setText("");
            attempts = 3;
            next();
        }
    }
    public void next(){
        randomCarImage();
        charSpacings();
        if (switchedOn){
            timeFunction();
        }
    }
}