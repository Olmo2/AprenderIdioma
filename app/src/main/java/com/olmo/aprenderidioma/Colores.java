package com.olmo.aprenderidioma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Colores extends AppCompatActivity implements View.OnClickListener {


    Button buttonRed,buttonYellow,buttonBlue,buttonGreen,buttonOrange,buttonPurple,buttonTeal,buttonLime,buttonBrown;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colores);


        buttonRed = findViewById(R.id.buttonRed);
        buttonRed.setOnClickListener(this);

        buttonYellow = findViewById(R.id.buttonYellow);
        buttonYellow.setOnClickListener(this);

        buttonBlue = findViewById(R.id.buttonBlue);
        buttonBlue.setOnClickListener(this);

        buttonGreen = findViewById(R.id.buttonGreen);
        buttonGreen.setOnClickListener(this);

        buttonOrange = findViewById(R.id.buttonOrange);
        buttonOrange.setOnClickListener(this);

        buttonPurple = findViewById(R.id.buttonPurple);
        buttonPurple.setOnClickListener(this);

        buttonTeal = findViewById(R.id.buttonTeal);
        buttonTeal.setOnClickListener(this);

        buttonLime = findViewById(R.id.buttonLime);
        buttonLime.setOnClickListener(this);

        buttonBrown = findViewById(R.id.buttonBrown);
        buttonBrown.setOnClickListener(this);

        ConstraintLayout constraintLayout = findViewById(R.id.layoutColores);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonRed:
                mp = MediaPlayer.create(this, R.raw.red);
                mp.start();
                break;

            case R.id.buttonYellow:
                mp = MediaPlayer.create(this, R.raw.yellow);
                mp.start();
                break;
            case R.id.buttonBlue:
                mp = MediaPlayer.create(this, R.raw.blue);
                mp.start();
                break;
            case R.id.buttonGreen:
                mp = MediaPlayer.create(this, R.raw.green);
                mp.start();
                break;
            case R.id.buttonOrange:
                mp = MediaPlayer.create(this, R.raw.orange);
                mp.start();
                break;
            case R.id.buttonPurple:
                mp = MediaPlayer.create(this, R.raw.purple);
                mp.start();
                break;
            case R.id.buttonTeal:
                mp = MediaPlayer.create(this, R.raw.teal);
                mp.start();
                break;
            case R.id.buttonLime:
                mp = MediaPlayer.create(this, R.raw.lime);
                mp.start();
                break;
            case R.id.buttonBrown:
                mp = MediaPlayer.create(this, R.raw.brown);
                mp.start();
                break;




        }
    }
}