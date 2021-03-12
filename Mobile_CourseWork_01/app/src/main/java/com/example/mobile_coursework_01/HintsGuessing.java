package com.example.mobile_coursework_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class HintsGuessing extends AppCompatActivity {
    private int random_car;
    private String carId;
    private String carModel;
    private TextView txt_characters;
    private EditText inputTxt;
    private Button submitBtn;
    private TextView answers;
    private TextView exceeded;
    private ImageView imageView;
    private boolean switchedOn;
    private CountDownTimer countdownTimer;
    private TextView timerView;
    private TextView correctionOrIncorrect;
    private boolean isTimerOn = true;
    private long milliSecondsCount= 20000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hints_guessing);
        Intent intent = getIntent();
        switchedOn = intent.getBooleanExtra("isChecked",false);
        imageView = (ImageView) findViewById(R.id.random_imageView2);
        txt_characters = findViewById(R.id.txt_hint);
        inputTxt = findViewById(R.id.input_char);
        submitBtn = findViewById(R.id.btn_submit);
        answers = findViewById(R.id.answer);
        exceeded = findViewById(R.id.exceed);
        timerView = findViewById(R.id.timerView3);
        correctionOrIncorrect = findViewById(R.id.correction);
        randomCarImage();
        charSpacings();

        if (savedInstanceState != null) {
            random_car = savedInstanceState.getInt("random_car");
            String carImage = "img_" + random_car;
            imageView.setImageDrawable(getResources().getDrawable(getID(carImage)));
            carId = savedInstanceState.getString("carId");
            carModel = savedInstanceState.getString("carModel");
            txt_characters.setText(savedInstanceState.getString("txt_characters"));
            exceeded.setText(savedInstanceState.getString("exceeded"));
            answers.setText(savedInstanceState.getString("answers"));
            answers.setTextColor(savedInstanceState.getInt("answersTxtColor"));
            submitBtn.setText(savedInstanceState.getString("submitBtn"));
            correctionOrIncorrect.setText(savedInstanceState.getString("correctOrIncorrectTxt"));
            correctionOrIncorrect.setTextColor(savedInstanceState.getInt("correctOrIncorrectColor"));
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
                        correctionOrIncorrect.setText("                         WRONG!\nTime exceeded click on next button");
                        correctionOrIncorrect.setTextColor(Color.parseColor("#FF0000"));
                        answers.setText("Correct answer is : " + carModel);
                        submitBtn.setText("Next");
                    }
                }.start();

            }
        }
    }
    private void randomCarImage() {
        Random random = new Random();
        random_car =1+ random.nextInt(30);

        carId= "img_" + random_car;
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
            correctionOrIncorrect.setText("Incorrect letter");
            correctionOrIncorrect.setTextColor(Color.parseColor("#FF0000"));
        }
        else if ((inputLetter.length() == 0 || inputLetter.length()>=2) && submitBtn.getText().toString().equalsIgnoreCase("Submit") ){
            correctionOrIncorrect.setText("Enter one letter");
            correctionOrIncorrect.setTextColor(Color.parseColor("#FF0000"));
        }
        else if (attempts > 0 && submitBtn.getText().toString().equalsIgnoreCase("Submit")) {
            for (int i = 0; i < carModel.length(); i++) {
                character = carModel.charAt(i);
                if (character.toString().equalsIgnoreCase(inputLetter)) {
                    StringBuilder sb = new StringBuilder(dash);
                    sb.replace(i, i + 1, inputLetter);
                    txt_characters.setText(sb);
                    correctionOrIncorrect.setText("");
                    dash = sb.toString();
                }
            }if (carModel.equalsIgnoreCase(dash)){
                correctionOrIncorrect.setText("CORRECT");
                correctionOrIncorrect.setTextColor(Color.parseColor("#32CD32"));
                if(countdownTimer != null) {//if user guess the correct answer,and that code used to stop current running time.
                    countdownTimer.cancel();
                    isTimerOn = false;
                    countdownTimer = null;
                }
                submitBtn.setText("Next");
            }
        }
        else if (attempts <= 0 && submitBtn.getText().toString().equalsIgnoreCase("Submit")){//if user guess the incorrect letter or left maximum attempts
            if(countdownTimer != null) {//that code used to stop current running time.
                countdownTimer.cancel();
                isTimerOn = false;
                countdownTimer = null;
            }
            exceeded.setText("Oooops ! Your attempts are left");
            answers.setText("Correct answer is : " + carModel);
            correctionOrIncorrect.setText("WRONG!");
            correctionOrIncorrect.setTextColor(Color.parseColor("#FF0000"));
            submitBtn.setText("Next");
            inputTxt.setText("");
        }

        else if(submitBtn.getText().toString().equalsIgnoreCase("Next")){
            submitBtn.setText("Submit");
            exceeded.setText("");
            answers.setText("");
            inputTxt.setText("");
            correctionOrIncorrect.setText("");
            attempts = 3;
            next();
        }
    }
    public void next(){
        randomCarImage();
        charSpacings();
        if (switchedOn){
            milliSecondsCount = 20000;
            isTimerOn = true;
            timeFunction();
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("random_car",random_car);
        outState.putString("carId",carId);
        outState.putString("carModel",carModel);
        outState.putString("txt_characters",txt_characters.getText().toString());
        outState.putString("exceeded",exceeded.getText().toString());
        outState.putString("answers",answers.getText().toString());
        outState.putInt("answersTxtColor",answers.getCurrentTextColor());
        outState.putString("submitBtn",submitBtn.getText().toString());

        outState.putString("correctOrIncorrectTxt", correctionOrIncorrect.getText().toString());
        outState.putInt("correctOrIncorrectColor", correctionOrIncorrect.getCurrentTextColor());

        outState.putLong("timerValue",milliSecondsCount);
        outState.putBoolean("isTimerOn",isTimerOn);
    }
}
