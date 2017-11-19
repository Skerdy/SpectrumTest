package com.example.user.spectrumtest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.user.spectrumtest.LoginActivity;
import com.example.user.spectrumtest.R;
import com.hanks.htextview.base.HTextView;

/**
 * Created by user on 11/19/2017.
 */

public class SplashScreen extends AppCompatActivity {

    private HTextView textview, textView1, textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,WindowManager.LayoutParams. FLAG_FULLSCREEN);

        textview =(HTextView) findViewById(R.id.text_splash);
        textView1 = (HTextView) findViewById(R.id.text_splash1);
        textView2 = (HTextView) findViewById(R.id.text_splash2);
        textview.animateText("Spectrum Track");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                textView1.animateText("W2020 - Demo v1");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textView2.animateText("@Skerdjan");
                    }
                },200);
            }
        },1000);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent mainIntent = new Intent(SplashScreen.this, MainMenu.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();
            }
        }, 2500);

    }




}
