package com.olmo.aprenderidioma;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Aprender extends AppCompatActivity implements View.OnClickListener {

    Button buttonColores;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprender);

        buttonColores = findViewById(R.id.buttonColores);
        buttonColores.setOnClickListener(this);

        ConstraintLayout constraintLayout = findViewById(R.id.layoutAprender);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonColores:
                intent = new Intent(this, Colores.class);
                startActivity(intent);
                break;

        }
    }
}