package com.hackathon.sailors.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.hackathon.sailors.R;
import com.hackathon.sailors.preffs.Data;

public class SplashScreen extends Activity {

    public static final String PREFS_SID = "auth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateUI();
    }


    private void updateUI() {
        Thread thread  = new Thread(){

            @Override
            public  void run(){
                try {
                    Thread.sleep(1000);
                    if(isUserLogedIn()){
                        startHome();
                        finish();
                    }else{
                        startLogin();
                        finish();
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    private void startHome() {
        Intent i = new Intent(this, Home.class);
        startActivity(i);
    }

    private boolean isUserLogedIn() {

        //check if user is logged in
        String token = Data.getSidToken(getSharedPreferences(SplashScreen.PREFS_SID, SplashScreen.MODE_PRIVATE));
        return token.length() != 0;
    }

    private void startLogin() {
        Intent i = new Intent(this, AuthHolder.class);
        startActivity(i);
    }
}