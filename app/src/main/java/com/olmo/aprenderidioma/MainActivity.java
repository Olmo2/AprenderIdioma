package com.olmo.aprenderidioma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button buttonAprender,buttonJugar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout constraintLayout = findViewById(R.id.layoutBienvenida);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        buttonAprender = findViewById(R.id.buttonAprender);
        buttonAprender.setOnClickListener(this);

        buttonJugar = findViewById(R.id.buttonJugar);
        buttonJugar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonAprender:
               intent = new Intent(this,Aprender.class);
               startActivity(intent);
                break;

            case R.id.buttonJugar:
                intent = new Intent(this,Jugar.class);
                startActivity(intent);
                break;
        }
    }
}