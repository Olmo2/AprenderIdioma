package com.olmo.aprenderidioma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Jugar extends AppCompatActivity implements View.OnClickListener {

    static final int NPREGUNTAS = 9;
    private Pregunta[] preguntas = new Pregunta[NPREGUNTAS];
    private int preguntaEnCurso = 0;

    TextView pregunta;
    RadioGroup rg;
    RadioButton res1, res2, res3;
    Button siguiente, reiniciar;
    int resBuenas, resFallos, resVacias = 0;
    ImageView imgPregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        ConstraintLayout Layout = findViewById(R.id.layoutJugar);
        AnimationDrawable animationDrawable = (AnimationDrawable) Layout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        pregunta = findViewById(R.id.tvPregunta);
        res1 = findViewById(R.id.rb1);
        res2 = findViewById(R.id.rb2);
        res3 = findViewById(R.id.rb3);

        siguiente = findViewById(R.id.btnSiguiente);
        siguiente.setOnClickListener(this);
        reiniciar = findViewById(R.id.btnReiniciar);
        reiniciar.setOnClickListener(this);
        reiniciar.setVisibility(View.INVISIBLE);
        imgPregunta = findViewById(R.id.imageViewPregunta);
        rg = findViewById(R.id.rg);

        cargarPreguntas();

        mostrarPreguntaEnCurso();

    }

    public void cargarPreguntas() {
        preguntas[0] = new Pregunta("Name this color", "Blue", "Yellow", "Red", 1, "blue");
        preguntas[1] = new Pregunta("Name this color", "Orange", "Green", "Lime", 2, "green");
        preguntas[2] = new Pregunta("Name this color", "Orange", "Teal", "Blue", 1, "orange");
        preguntas[3] = new Pregunta("Name this color", "Teal", "Brown", "Purple", 3, "purple");
        preguntas[4] = new Pregunta("Name this color", "Lime", "Blue", "Red",  3, "red");
        preguntas[5] = new Pregunta("Name this color", "Teal", "Yellow", "Purple",  2, "yellow");
        preguntas[6] = new Pregunta("Name this color", "Purple", "Brown", "Teal", 3, "teal");
        preguntas[7] = new Pregunta("Name this color", "Blue", "Purple", "Lime", 3, "lime");
        preguntas[8] = new Pregunta("Name this color","Teal", "Brown", "Purple", 2, "brown");
    }

    public void validarRespuesta() {

        // Obtiene la respuesta seleccionada por el usuario
        int resSelect;

        if (res1.isChecked()) {
            resSelect = 1;
        } else if (res2.isChecked()) {
            resSelect = 2;
        } else if (res3.isChecked()) {
            resSelect = 3;
        } else {
            // El usuario no seleccionó ninguna respuesta
            resSelect = 0;
        }


        // Registra las respuestas correctas
        if (preguntas[preguntaEnCurso].getCorrecta() == resSelect) {
            resBuenas++;
            Toast correcto = Toast.makeText( this,"¡Correcta!", Toast.LENGTH_SHORT);
            correcto.setGravity(Gravity.CENTER, 0, 750);
            correcto.show();

            //Registra las no contestadas
        } else if (resSelect == 0) {
            resVacias++;

            //Registra las Incorrectas
        } else {
            resFallos++;
            Toast fallo = Toast.makeText( this,"¡Fallo!", Toast.LENGTH_SHORT);
            fallo.setGravity(Gravity.CENTER, 0, 750);
            fallo.show();
        }
        // Pasa a la siguiente pregunta
        preguntaEnCurso++;
        if (preguntaEnCurso < NPREGUNTAS) {
            mostrarPreguntaEnCurso();
        } else {
            // Si se llega al final del test, se desactiva el botón siguiente
            siguiente.setEnabled(false);
            reiniciar.setVisibility(View.VISIBLE);
            mostrarResultado();
        }
    }

    public void mostrarPreguntaEnCurso() {

        // Muestra la pregunta actual

        Pregunta preguntaActual = preguntas[preguntaEnCurso];


        res1.setText(preguntaActual.getRespuesta()[0]);
        res2.setText(preguntaActual.getRespuesta()[1]);
        res3.setText(preguntaActual.getRespuesta()[2]);

        /*Para cambiar la img*/
        Resources res = getResources();
        String name = preguntaActual.getImg();
        int resID = res.getIdentifier(name, "drawable", getPackageName());
        Drawable drawable = res.getDrawable(resID);
        imgPregunta.setImageDrawable(drawable);
        rg.clearCheck();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSiguiente:
                // Cuando se pasa a la siguienye pregunta, se valida la respuesta de la pregunta actual

                validarRespuesta();
                break;
            case R.id.btnReiniciar:
                Intent intent = new Intent(Jugar.this, MainActivity.class);
                startActivity(intent);
                break;

        }
    }

    public void mostrarResultado() {

        // Muestra el número de respuestas correctas al finalizar el test

        Toast resultadoBuenas;
        String mensaje = "Correctas: " + resBuenas + "/" + NPREGUNTAS + " " + "En Blanco: " + resVacias + "/" + NPREGUNTAS + " " + "Fallos: " + resFallos + "/" + NPREGUNTAS;
        resultadoBuenas = Toast.makeText( this, mensaje, Toast.LENGTH_LONG);
        resultadoBuenas.setGravity(Gravity.CENTER, 0, 750);
        resultadoBuenas.show();


    }

}