package com.example.mobile_coursework_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class Login_page extends AppCompatActivity {

    int counter=0;
    ProgressBar progressBar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        progress();
    }
    //from stackOverFlow
    public void progress(){
        progressBar=findViewById(R.id.progressBar);
        final Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                counter++;
                progressBar.setProgress(counter);
                if (counter==100){
                    timer.cancel();
                    intent=new Intent(Login_page.this,MainActivity.class); //if counter goes to 100%,then start the MainActivity.
                    startActivity(intent);
                }
            }
        };
        timer.schedule(timerTask,0,50);
    }
}