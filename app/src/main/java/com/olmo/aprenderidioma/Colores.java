package com.olmo.aprenderidioma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Colores extends AppCompatActivity implements View.OnClickListener {


    Button buttonRed,buttonYellow;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colores);


        buttonRed = findViewById(R.id.buttonRed);
        buttonRed.setOnClickListener(this);

        buttonYellow = findViewById(R.id.buttonYellow);
        buttonYellow.setOnClickListener(this);

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


        }
    }
}