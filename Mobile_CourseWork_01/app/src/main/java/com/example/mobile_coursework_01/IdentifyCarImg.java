package com.example.mobile_coursework_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import es.dmoral.toasty.Toasty;

public class IdentifyCarImg extends AppCompatActivity {

    Random random = new Random();
    ImageView randomImg01;
    ImageView randomImg02;
    ImageView randomImg03;
    TextView timerView;
    TextView displayingCarName;
    int clicks = 0 ;
    boolean switchedOn;
    CountDownTimer countdownTimer;

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
        timerView = findViewById(R.id.timerView2);
        carImgGenerate();
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
                    if (clicks == 0){//if user didn't click on the any image,click variable also zero.
                        msg();
                    }
                }
            }.start();

        }
    }

    private void carImgGenerate()
    {
        int carOne = random.nextInt(12);
        int carTwo = random.nextInt(10);  //generate three random numbers for images.
        int carThree = random.nextInt(8);

        System.out.println(carOne+" "+carTwo+" "+carThree);

        int randomArr = random.nextInt(3);

        randomImg01 = findViewById(R.id.random_Img_01);
        randomImg01.setImageResource(firstSetOfCar[carOne]); //firstSetOfCar[arrayIndex];

        randomImg02 = findViewById(R.id.random_Img_02);
        randomImg02.setImageResource(secondSetOfCar[carTwo]);//secondSetOfCar[arrayIndex];

        randomImg03 = findViewById(R.id.random_Img_03);
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
                Toasty.success(this, "Correct ! ", Toast.LENGTH_LONG).show();
            } else {
                Toasty.error(this, "Wrong ! ", Toast.LENGTH_LONG).show();
            }
        }
        else if (clicks == 5)//this part connect with msg();
        {
            Toasty.warning(this, "Time exceeded click on next button", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"You Already Clicked an Image",Toast.LENGTH_SHORT).show();
        }
        if(countdownTimer != null) {//if user select 1st image,and that time current time is stop.
            countdownTimer.cancel();
            countdownTimer = null;
        }
    }

    public void secondRandomImg(View view)
    {
        if(clicks == 0)
        {
            clicks++;

            if (displayingCarName.getText() == "BMW" || displayingCarName.getText() == "Honda" || displayingCarName.getText() == "Tesla") {
                Toasty.success(this, "Correct ! ", Toast.LENGTH_LONG).show();
            } else {
                Toasty.error(this, "Wrong ! ", Toast.LENGTH_LONG).show();
            }
        }
        else if (clicks == 5)//this part connect with msg();
        {
            Toasty.warning(this, "Time exceeded click on next button", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"You Already Clicked an Image",Toast.LENGTH_SHORT).show();
        }
        if(countdownTimer != null) {//if user select 2nd image,and that time current time is stop.
            countdownTimer.cancel();
            countdownTimer = null;
        }

    }

    public void thirdRandomImg(View view)
    {
        if(clicks == 0)
        {
            clicks++;

            if (displayingCarName.getText() == "Mercedes" || displayingCarName.getText() == "Nissan" || displayingCarName.getText() == "Suzuki") {
                Toasty.success(this, "Correct ! ", Toast.LENGTH_LONG).show();
            } else {
                Toasty.error(this, "Wrong ! ", Toast.LENGTH_LONG).show();
            }
        }
        else if (clicks == 5)//this part connect with msg();
        {
            Toasty.warning(this, "Time exceeded click on next button", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"You Already Clicked an Image",Toast.LENGTH_SHORT).show();
        }
        if(countdownTimer != null) { //if user select 3rd image,and that time current time is stop.
            countdownTimer.cancel();
            countdownTimer = null;
        }
    }
    public void msg(){
        Toasty.error(this, "Wrong ! ", Toast.LENGTH_LONG).show();//this method calls after the onFinish()
        clicks = clicks+5; //this part use to give a message to user about time has exceeded.
    }                      //after time exceeding user try again to click on the images,but in this part block that chance.

    public void nextOnClick(View view) {
        if(countdownTimer != null) { //if user without selecting any image,this block use to stop current time in the timer.
            countdownTimer.cancel();
            countdownTimer = null;
        }
        next();
    }
    public void next(){
        clicks = 0; //after click on the next button click variable set to zero
        carImgGenerate();
        timeFunction();
    }
}