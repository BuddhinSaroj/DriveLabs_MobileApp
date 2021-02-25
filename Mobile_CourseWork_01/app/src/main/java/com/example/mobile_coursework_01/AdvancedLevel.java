package com.example.mobile_coursework_01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import es.dmoral.toasty.Toasty;

public class AdvancedLevel extends AppCompatActivity {

    Random random = new Random();
    int firstSetOfCar [] = {R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5,R.drawable.img_27,R.drawable.img_28,R.drawable.img_29,R.drawable.img_30,R.drawable.img_31,R.drawable.img_20,R.drawable.img_21};
    int secondSetOfCar [] = {R.drawable.img_6,R.drawable.img_7,R.drawable.img_8,R.drawable.img_9,R.drawable.img_10,R.drawable.img_11,R.drawable.img_12,R.drawable.img_13,R.drawable.img_25,R.drawable.img_26};
    int thirdSetOfCar [] = {R.drawable.img_14,R.drawable.img_15,R.drawable.img_16,R.drawable.img_17,R.drawable.img_18,R.drawable.img_19,R.drawable.img_22,R.drawable.img_23,R.drawable.img_24};
    ImageView randomImg01;
    ImageView randomImg02;
    ImageView randomImg03;
    EditText inputTxtOne;
    EditText inputTxtTwo;
    EditText inputTxtThree;
    TextView txtCorrectionOne;
    TextView txtCorrectionTwo;
    TextView txtCorrectionThree;
    TextView counterView;
    Button submitBtn;
    int carOne;
    int carTwo;
    int carThree;
    int greenColorValue = Color.parseColor("#23cc1b");
    int redColorValue = Color.parseColor("#f01c05");
    int defHintColorValue = Color.parseColor("#808080");
    int defTextColorValue = Color.parseColor("#000000");
    int yellowColorValue = Color.parseColor("#e3ff00");
    int attempts = 0;
    int count;
    String carModelOne="";
    String carModelTwo="";
    String carModelThree="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_level);
        submitBtn = findViewById(R.id.submitBtn);
        txtCorrectionOne = (TextView)findViewById(R.id.txt_correction1);
        txtCorrectionTwo = (TextView)findViewById(R.id.txt_correction2);
        txtCorrectionThree =(TextView) findViewById(R.id.txt_correction3);
        counterView = (TextView)findViewById(R.id.counter);
        carImgGenerate();
    }

    private void carImgGenerate()
    {
        carOne = random.nextInt(12);
        carTwo = random.nextInt(10);
        carThree = random.nextInt(8);

        System.out.println(carOne+" "+carTwo+" "+carThree);


        randomImg01 = findViewById(R.id.imageView1);
        randomImg01.setImageResource(firstSetOfCar[carOne]);
        inputTxtOne = findViewById(R.id.txt_img1);

        randomImg02 = findViewById(R.id.imageView2);
        randomImg02.setImageResource(secondSetOfCar[carTwo]);
        inputTxtTwo = findViewById(R.id.txt_img2);

        randomImg03 = findViewById(R.id.imageView3);
        randomImg03.setImageResource(thirdSetOfCar[carThree]);
        inputTxtThree = findViewById(R.id.txt_img3);

    }

    public void submitBtn(View view) {
        attempts++;
        checkingTxt();
    }

    private void checkingTxt() {
        if (submitBtn.getText().equals("Submit")) {
            String model = inputTxtOne.getText().toString();
            if ((carOne >= 0 && carOne <= 4) && !(inputTxtOne.getText().toString().equalsIgnoreCase("Correct ! "))) {
                if (inputTxtOne.getText().toString().equalsIgnoreCase("Audi")) {
                    inputTxtOne.setText("Correct ! ");
                    inputTxtOne.setTextColor(greenColorValue);
                    inputTxtOne.setEnabled(false);
                    count++;
                } else if (!(inputTxtOne.getText().toString().equalsIgnoreCase("Audi"))) {
                    inputTxtOne.setHint("Wrong!");
                    inputTxtOne.setHintTextColor(redColorValue);
                    inputTxtOne.setText("");
                    carModelOne = "Audi";
                }
            }
            if ((carOne >= 5 && carOne <= 9) && !(inputTxtOne.getText().toString().equalsIgnoreCase("Correct ! "))) {
                if (inputTxtOne.getText().toString().equalsIgnoreCase("Toyota")) {
                    inputTxtOne.setText("Correct ! ");
                    inputTxtOne.setTextColor(greenColorValue);
                    inputTxtOne.setEnabled(false);
                    count++;
                } else if (!(inputTxtOne.getText().toString().equalsIgnoreCase("Toyota"))) {
                    inputTxtOne.setHint("Wrong!");
                    inputTxtOne.setHintTextColor(redColorValue);
                    inputTxtOne.setText("");
                    carModelOne = "Toyota";
                }
            }
            if ((carOne >= 10 && carOne <= 11) && !(inputTxtOne.getText().toString().equalsIgnoreCase("Correct ! "))) {
                if (inputTxtOne.getText().toString().equalsIgnoreCase("Peugeot")) {
                    inputTxtOne.setText("Correct ! ");
                    inputTxtOne.setTextColor(greenColorValue);
                    inputTxtOne.setEnabled(false);
                    count++;
                } else if (!(inputTxtOne.getText().toString().equalsIgnoreCase("Peugeot"))) {
                    inputTxtOne.setHint("Wrong!");
                    inputTxtOne.setHintTextColor(redColorValue);
                    inputTxtOne.setText("");
                    carModelOne = "Peugeot";
                }
            }
            if ((carTwo >= 0 && carTwo <= 2) && !(inputTxtTwo.getText().toString().equalsIgnoreCase("Correct ! "))) {
                if (inputTxtTwo.getText().toString().equalsIgnoreCase("BMW")) {
                    inputTxtTwo.setText("Correct ! ");
                    inputTxtTwo.setTextColor(greenColorValue);
                    inputTxtTwo.setEnabled(false);
                    count++;
                } else if (!(inputTxtTwo.getText().toString().equalsIgnoreCase("BMW"))) {
                    inputTxtTwo.setHint("Wrong!");
                    inputTxtTwo.setHintTextColor(redColorValue);
                    inputTxtTwo.setText("");
                    carModelTwo = "BMW";
                }
            }
            if ((carTwo >= 3 && carTwo <= 7)&& !(inputTxtTwo.getText().toString().equalsIgnoreCase("Correct ! "))) {
                if (inputTxtTwo.getText().toString().equalsIgnoreCase("Honda")) {
                    inputTxtTwo.setText("Correct ! ");
                    inputTxtTwo.setTextColor(greenColorValue);
                    inputTxtTwo.setEnabled(false);
                    count++;
                } else if (!(inputTxtTwo.getText().toString().equalsIgnoreCase("Honda"))) {
                    inputTxtTwo.setHint("Wrong!");
                    inputTxtTwo.setHintTextColor(redColorValue);
                    inputTxtTwo.setText("");
                    carModelTwo = "Honda";
                }
            }
            if ((carTwo >= 8 && carTwo <= 9)&& !(inputTxtTwo.getText().toString().equalsIgnoreCase("Correct ! "))) {
                if (inputTxtTwo.getText().toString().equalsIgnoreCase("Tesla")) {
                    inputTxtTwo.setText("Correct ! ");
                    inputTxtTwo.setTextColor(greenColorValue);
                    inputTxtTwo.setEnabled(false);
                    count++;
                } else if (!(inputTxtTwo.getText().toString().equalsIgnoreCase("Tesla"))) {
                    inputTxtTwo.setHint("Wrong!");
                    inputTxtTwo.setHintTextColor(redColorValue);
                    inputTxtTwo.setText("");
                    carModelTwo = "Tesla";
                }
            }
            if ((carThree >= 0 && carThree <= 2) && !(inputTxtThree.getText().toString().equalsIgnoreCase("Correct ! "))) {
                if (inputTxtThree.getText().toString().equalsIgnoreCase("Mercedes")) {
                    inputTxtThree.setText("Correct ! ");
                    inputTxtThree.setTextColor(greenColorValue);
                    inputTxtThree.setEnabled(false);
                    count++;
                } else if (!(inputTxtThree.getText().toString().equalsIgnoreCase("Mercedes"))) {
                    inputTxtThree.setHint("Wrong!");
                    inputTxtThree.setHintTextColor(redColorValue);
                    inputTxtThree.setText("");
                    carModelThree = "Mercedes";
                }
            }
            if ((carThree >= 3 && carThree <= 5) && !(inputTxtThree.getText().toString().equalsIgnoreCase("Correct ! "))) {
                if (inputTxtThree.getText().toString().equalsIgnoreCase("Nissan")) {
                    inputTxtThree.setText("Correct ! ");
                    inputTxtThree.setTextColor(greenColorValue);
                    inputTxtThree.setEnabled(false);
                    count++;
                } else if (!(inputTxtThree.getText().toString().equalsIgnoreCase("Nissan"))) {
                    inputTxtThree.setHint("Wrong!");
                    inputTxtThree.setHintTextColor(redColorValue);
                    inputTxtThree.setText("");
                    carModelThree = "Nissan";
                }
            }
            if ((carThree >= 6 && carThree <= 8) && !(inputTxtThree.getText().toString().equalsIgnoreCase("Correct ! "))) {
                if (inputTxtThree.getText().toString().equalsIgnoreCase("Suzuki")) {
                    inputTxtThree.setText("Correct ! ");
                    inputTxtThree.setTextColor(greenColorValue);
                    inputTxtThree.setEnabled(false);
                    count++;
                } else if (!(inputTxtThree.getText().toString().equalsIgnoreCase("Suzuki"))) {
                    inputTxtThree.setHint("Wrong!");
                    inputTxtThree.setHintTextColor(redColorValue);
                    inputTxtThree.setText("");
                    carModelThree = "Suzuki";
                }
            }
            counterView.setText(String.valueOf(count));//set marks
            if (attempts > 3){
                if (inputTxtOne.getHint().toString().equals("Wrong!") ){
                    txtCorrectionOne.setText(carModelOne);
                    txtCorrectionOne.setTextColor(yellowColorValue);
                }
                if(inputTxtTwo.getText().toString().equals("")){
                    txtCorrectionTwo.setText(carModelTwo);
                    txtCorrectionTwo.setTextColor(yellowColorValue);
                }
                if (inputTxtThree.getText().toString().equals("")){
                    txtCorrectionThree.setText(carModelThree);
                    txtCorrectionThree.setTextColor(yellowColorValue);
                }
                attempts = 0;
                inputTxtOne.setEnabled(false);
                inputTxtTwo.setEnabled(false);
                inputTxtThree.setEnabled(false);
                submitBtn.setText("Next");
                Toasty.error(this, "No attempts left ! ", Toast.LENGTH_LONG).show();
            }if((inputTxtOne.getText().toString().equals("Correct ! ") && inputTxtTwo.getText().toString().equals("Correct ! ") &&inputTxtThree.getText().toString().equals("Correct ! "))){
                attempts = 0;
                submitBtn.setText("Next");
                Toasty.success(this, "CORRECT!", Toast.LENGTH_LONG).show();
            }
        }
        else if(submitBtn.getText().equals("Next")){
            submitBtn.setText("Submit");
            carImgGenerate();
            inputTxtOne.setText("");
            inputTxtOne.setTextColor(defTextColorValue);
            inputTxtOne.setEnabled(true);
            inputTxtOne.setHint("Car Make img 01");
            inputTxtOne.setHintTextColor(defHintColorValue);

            inputTxtTwo.setText("");
            inputTxtTwo.setTextColor(defTextColorValue);
            inputTxtTwo.setEnabled(true);
            inputTxtTwo.setHint("Car Make img 02");
            inputTxtTwo.setHintTextColor(defHintColorValue);

            inputTxtThree.setText("");
            inputTxtThree.setTextColor(defTextColorValue);
            inputTxtThree.setEnabled(true);
            inputTxtThree.setHint("Car Make img 03");
            inputTxtThree.setHintTextColor(defHintColorValue);

            txtCorrectionOne.setText("");
            txtCorrectionTwo.setText("");
            txtCorrectionThree.setText("");
        }
    }
}