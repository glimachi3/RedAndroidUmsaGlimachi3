package com.tarqui.glimachi.redandroidumsaglimachi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText;
    String strPelicula;
    private String strActor;
    private Button btnPelicula;
    private Button btnActor;
    private View rootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        btnPelicula = (Button) findViewById(R.id.btnPelicula);
        btnPelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPantallaPelicula();
            }
        });

        btnActor = (Button) findViewById(R.id.btnActor);
        btnActor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPantallaActor();
            }
        });

        rootView = findViewById(R.id.rootView);
    }
    private void irPantallaPelicula() {
        usernameEditText = (EditText) findViewById(R.id.pelicula);
        strPelicula = usernameEditText.getText().toString().trim();
        Bundle parmetros = new Bundle();
        parmetros.putString("pelicula", strPelicula);
/*
        Intent i = new Intent(this, MainActivity.class);
        i.putExtras(parmetros);
        startActivity(i);*/
        Intent intent = new Intent(this, PeliculasActivity.class);
        intent.putExtras(parmetros);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
    private void irPantallaActor() {
        usernameEditText = (EditText) findViewById(R.id.actor);
        strActor = usernameEditText.getText().toString().trim();
       // Bundle parmetros = new Bundle();
      //  parmetros.putString("actor", strActor);
        Intent intent = new Intent(this, ActoresActivity.class);
       intent.putExtra("actor",strActor);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
