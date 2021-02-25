package com.example.mobile_coursework_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    Button next_btn;
    TextView displayingCarName;
    int clicks = 0 ;

    int firstSetOfCar [] = {R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5,R.drawable.img_27,R.drawable.img_28,R.drawable.img_29,R.drawable.img_30,R.drawable.img_31,R.drawable.img_20,R.drawable.img_21};
    int secondSetOfCar [] = {R.drawable.img_6,R.drawable.img_7,R.drawable.img_8,R.drawable.img_9,R.drawable.img_10,R.drawable.img_11,R.drawable.img_12,R.drawable.img_13,R.drawable.img_25,R.drawable.img_26};
    int thirdSetOfCar [] = {R.drawable.img_14,R.drawable.img_15,R.drawable.img_16,R.drawable.img_17,R.drawable.img_18,R.drawable.img_19,R.drawable.img_22,R.drawable.img_23,R.drawable.img_24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_car_img);
        displayingCarName = findViewById(R.id.txt_carName);
        carImgGenerate();
    }

    private void carImgGenerate()
    {
        int carOne = random.nextInt(12);
        int carTwo = random.nextInt(10);
        int carThree = random.nextInt(8);

        System.out.println(carOne+" "+carTwo+" "+carThree);

        int randomArr = random.nextInt(3);

        randomImg01 = findViewById(R.id.random_Img_01);
        randomImg01.setImageResource(firstSetOfCar[carOne]);

        randomImg02 = findViewById(R.id.random_Img_02);
        randomImg02.setImageResource(secondSetOfCar[carTwo]);

        randomImg03 = findViewById(R.id.random_Img_03);
        randomImg03.setImageResource(thirdSetOfCar[carThree]);

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
        else {
            Toast.makeText(getApplicationContext(),"You Already Clicked an Image",Toast.LENGTH_SHORT).show();
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
        else {
            Toast.makeText(getApplicationContext(),"You Already Clicked an Image",Toast.LENGTH_SHORT).show();
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
        else {
            Toast.makeText(getApplicationContext(),"You Already Clicked an Image",Toast.LENGTH_SHORT).show();
        }
    }

    public void nextOnClick(View view) {
        clicks = 0;
        carImgGenerate();
    }
}