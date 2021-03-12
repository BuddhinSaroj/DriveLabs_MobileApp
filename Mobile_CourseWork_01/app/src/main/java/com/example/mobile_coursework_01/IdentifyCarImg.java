package com.example.mobile_coursework_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class IdentifyCarImg extends AppCompatActivity {

    Random random = new Random();
    private ImageView randomImg01;
    private ImageView randomImg02;
    private ImageView randomImg03;
    private TextView timerView;
    private TextView displayingCarName;
    private TextView correctOrIncorrect;
    private int carOne ;
    private int carTwo ;
    private int carThree ;
    private int clicks = 0 ;
    private boolean switchedOn;
    private CountDownTimer countdownTimer;
    private boolean isTimerOn = true;
    private long milliSecondsCount= 20000;

    //create three set of arrays for store car images.
    int firstSetOfCar [] = {R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5,R.drawable.img_27,R.drawable.img_28,R.drawable.img_29,R.drawable.img_30,R.drawable.img_31,R.drawable.img_20,R.drawable.img_21};
    int secondSetOfCar [] = {R.drawable.img_6,R.drawable.img_7,R.drawable.img_8,R.drawable.img_9,R.drawable.img_10,R.drawable.img_11,R.drawable.img_12,R.drawable.img_13,R.drawable.img_25,R.drawable.img_26};
    int thirdSetOfCar [] = {R.drawable.img_14,R.drawable.img_15,R.drawable.img_16,R.drawable.img_17,R.drawable.img_18,R.drawable.img_19,R.drawable.img_22,R.drawable.img_23,R.drawable.img_24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_car_img);
        Intent intent = getIntent();
        switchedOn = intent.getBooleanExtra("isChecked",false);
        displayingCarName = findViewById(R.id.txt_carName);
        randomImg01 = findViewById(R.id.random_Img_01);
        randomImg02 = findViewById(R.id.random_Img_02);
        randomImg03 = findViewById(R.id.random_Img_03);
        timerView = findViewById(R.id.timerView2);
        correctOrIncorrect = findViewById(R.id.corrections);
        carImgGenerate();

        if (savedInstanceState != null) {
            clicks = savedInstanceState.getInt("clicks");
            carOne = savedInstanceState.getInt("carOne");
            randomImg01.setImageResource(firstSetOfCar[carOne]);

            carTwo = savedInstanceState.getInt("carTwo");
            randomImg02.setImageResource(secondSetOfCar[carTwo]);//secondSetOfCar[arrayIndex];

            carThree = savedInstanceState.getInt("carThree");
            randomImg03.setImageResource(thirdSetOfCar[carThree]);//thirdSetOfCar[arrayIndex];

            displayingCarName.setText(savedInstanceState.getString("car_name"));

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
                        if (clicks == 0) {//if user didn't click on the any image,click variable also zero.
                            msg();
                        }
                    }
                }.start();

            }
        }
    }

    private void carImgGenerate()
    {
        carOne = random.nextInt(12);
        carTwo = random.nextInt(10);  //generate three random numbers for images.
        carThree = random.nextInt(8);

        System.out.println(carOne+" "+carTwo+" "+carThree);

        int randomArr = random.nextInt(3);

        randomImg01.setImageResource(firstSetOfCar[carOne]); //firstSetOfCar[arrayIndex];
        randomImg02.setImageResource(secondSetOfCar[carTwo]);//secondSetOfCar[arrayIndex];
        randomImg03.setImageResource(thirdSetOfCar[carThree]);//thirdSetOfCar[arrayIndex];

        if(randomArr == 0)
        {
            if((carOne>=0 && carOne<=4))
            {
                displayingCarName.setText("Audi");
            }
            else if((carOne>=5 && carOne<=9))
            {
                displayingCarName.setText("Toyota");
            }
            else if((carOne>=10 && carOne<=11))
            {
                displayingCarName.setText("Peugeot");
            }
        }

        else if(randomArr == 1)
        {
            if((carTwo>=0 && carTwo<=2))
            {
                displayingCarName.setText("BMW");
            }
            else if((carTwo>=3 && carTwo<=7))
            {
                displayingCarName.setText("Honda");
            }
            else if((carTwo>=8 && carTwo<=9))
            {
                displayingCarName.setText("Tesla");
            }
        }
        else if(randomArr == 2)
        {
            if((carThree>=0 && carThree<=2))
            {
                displayingCarName.setText("Mercedes");
            }
            else if((carThree>=3 && carThree<=5))
            {
                displayingCarName.setText("Nissan");
            }
            else if((carThree>=6 && carThree<=8))
            {
                displayingCarName.setText("Suzuki");
            }
        }
    }

    public void firstRandomImg(View view)
    {
        if(clicks == 0)
        {
            clicks++;

            if (displayingCarName.getText() == "Audi" || displayingCarName.getText() == "Toyota" || displayingCarName.getText() == "Peugeot") {
                correctOrIncorrect.setTextColor(Color.parseColor("#00FF00"));
                correctOrIncorrect.setText("CORRECT!");
            } else {
                correctOrIncorrect.setTextColor(Color.parseColor("#f01c05"));
                correctOrIncorrect.setText("WRONG ! ");
            }
        }
        else if (clicks == 5)//this part connect with msg();
        {
            //correctOrIncorrect.setText("Time exceeded click on next button");
            Toast.makeText(getApplicationContext(),"Time exceeded click on next button",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"You Already Clicked an Image",Toast.LENGTH_SHORT).show();
        }
        if(countdownTimer != null) {//if user select 1st image,and that time current time is stop.
            countdownTimer.cancel();
            isTimerOn = false;
            countdownTimer = null;
        }
    }

    public void secondRandomImg(View view)
    {
        if(clicks == 0)
        {
            clicks++;

            if (displayingCarName.getText() == "BMW" || displayingCarName.getText() == "Honda" || displayingCarName.getText() == "Tesla") {
                correctOrIncorrect.setTextColor(Color.parseColor("#00FF00"));
                correctOrIncorrect.setText("CORRECT!");
            } else {
                correctOrIncorrect.setTextColor(Color.parseColor("#f01c05"));
                correctOrIncorrect.setText("WRONG ! ");
            }
        }
        else if (clicks == 5)//this part connect with msg();
        {
            //correctOrIncorrect.setText("Time exceeded click on next button");
            Toast.makeText(getApplicationContext(),"Time exceeded click on next button",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"You Already Clicked an Image",Toast.LENGTH_SHORT).show();
        }
        if(countdownTimer != null) {//if user select 2nd image,and that time current time is stop.
            countdownTimer.cancel();
            isTimerOn = false;
            countdownTimer = null;
        }

    }

    public void thirdRandomImg(View view)
    {
        if(clicks == 0)
        {
            clicks++;

            if (displayingCarName.getText() == "Mercedes" || displayingCarName.getText() == "Nissan" || displayingCarName.getText() == "Suzuki") {
                correctOrIncorrect.setTextColor(Color.parseColor("#00FF00"));
                correctOrIncorrect.setText("CORRECT!");
            } else {
                correctOrIncorrect.setTextColor(Color.parseColor("#f01c05"));
                correctOrIncorrect.setText("WRONG ! ");
            }
        }
        else if (clicks == 5)//this part connect with msg();
        {
            //correctOrIncorrect.setText("Time exceeded click on next button");
            Toast.makeText(getApplicationContext(),"Time exceeded click on next button",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"You Already Clicked an Image",Toast.LENGTH_SHORT).show();
        }
        if(countdownTimer != null) { //if user select 3rd image,and that time current time is stop.
            countdownTimer.cancel();
            isTimerOn = false;
            countdownTimer = null;
        }
    }
    public void msg(){
        correctOrIncorrect.setTextColor(Color.parseColor("#f01c05"));
        correctOrIncorrect.setText("WRONG ! ");//this method calls after the onFinish()
        clicks = clicks+5; //this part use to give a message to user about time has exceeded.
    }                      //after time exceeding user try again to click on the images,but in this part block that chance.

    public void nextOnClick(View view) {
        if(countdownTimer != null) { //if user without selecting any image,this block use to stop current time in the timer.
            countdownTimer.cancel();
            isTimerOn = false;
            countdownTimer = null;
        }
        next();
    }
    public void next(){
        clicks = 0; //after click on the next button click variable set to zero
        correctOrIncorrect.setText("");
        carImgGenerate();
        if (switchedOn){
            milliSecondsCount = 20000;
            isTimerOn = true;
            timeFunction();
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("clicks",clicks);
        outState.putInt("carOne",carOne);
        outState.putInt("carTwo",carTwo);
        outState.putInt("carThree",carThree);
        outState.putString("car_name",displayingCarName.getText().toString());
        outState.putString("correctOrIncorrectTxt", correctOrIncorrect.getText().toString());
        outState.putInt("correctOrIncorrectColor", correctOrIncorrect.getCurrentTextColor());
        outState.putLong("timerValue",milliSecondsCount);
        outState.putBoolean("isTimerOn",isTimerOn);
    }
}
