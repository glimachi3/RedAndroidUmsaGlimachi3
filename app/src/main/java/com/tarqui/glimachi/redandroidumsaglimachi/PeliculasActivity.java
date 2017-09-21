package com.tarqui.glimachi.redandroidumsaglimachi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.tarqui.glimachi.redandroidumsaglimachi.adapters.JPeliculasAdapter;
import com.tarqui.glimachi.redandroidumsaglimachi.model.BPelicula;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PeliculasActivity extends AppCompatActivity {

    private RecyclerView peliculasRecyclerView;
    private ProgressBar progressBar;
    private View rootView;
    private static final Gson gson = new Gson();
   private String strPelicula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);

        Bundle bundle = this.getIntent().getExtras();
        strPelicula = bundle.getString("pelicula");
        peliculasRecyclerView = (RecyclerView) findViewById(R.id.peliculasRecyclerView);
        peliculasRecyclerView.setHasFixedSize(true);
        peliculasRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        rootView = findViewById(R.id.rootView);
    }
    @Override
    protected void onStart() {
        super.onStart();

        cargarDatos();
    }

    private void cargarDatos() {

        progressBar.setVisibility(View.VISIBLE);

        TheMovieDatabaseService service = ServiceGenerator.createService(TheMovieDatabaseService.class);
        //Call<List<BPelicula>> call = service.obtenerPeliculas("transformers");
        Call<List<BPelicula>> call = service.obtenerPeliculas(strPelicula);
        call.enqueue(new Callback<List<BPelicula>>() {
            @Override
            public void onResponse(Call<List<BPelicula>> call, Response<List<BPelicula>> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    JPeliculasAdapter adaptador = new JPeliculasAdapter(response.body(), PeliculasActivity.this);
                    peliculasRecyclerView.setAdapter(adaptador);
                } else {
                    mostrarMessage("Ocurrío un problema en el servidor");
                }
            }
            @Override
            public void onFailure(Call<List<BPelicula>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                mostrarMessage("Error al obtener películas: " + t.getMessage());
            }
        });
    }
    private void mostrarMessage(String mensaje) {
        Snackbar.make(rootView, mensaje, Snackbar.LENGTH_LONG).show();
    }

}
