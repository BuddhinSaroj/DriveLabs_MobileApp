package com.example.mobile_coursework_01;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
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
    Button btn_identify_next;
    int random_car;
    String carMake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_the_car_make);
        randomCarImage();

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
        random_car = random.nextInt(31);
        ImageView imageView = (ImageView) findViewById(R.id.random_imageView);
        String carId = "img_" + random_car;
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
    public void identifyButtonOnClick(View view) {
        txt_correction = findViewById(R.id.txt_carName);
        btn_identify_next = findViewById(R.id.btn_identify);

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


}