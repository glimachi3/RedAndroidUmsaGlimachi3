package com.tarqui.glimachi.redandroidumsaglimachi;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.tarqui.glimachi.redandroidumsaglimachi.adapters.JActoresAdapter;
import com.tarqui.glimachi.redandroidumsaglimachi.model.BActor;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class ActoresActivity extends AppCompatActivity {
    private RecyclerView peliculasRecyclerView;
    private ProgressBar progressBar;
    private View rootView;
    private String strActor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actores);

        Bundle bundle = this.getIntent().getExtras();
        strActor = bundle.getString("actor");

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
        //Call<List<BActor>> call = service.obtenerActores("megan fox");
       Call<List<BActor>> call = service.obtenerActores(strActor);

        call.enqueue(new Callback<List<BActor>>() {
            @Override
            public void onResponse(Call<List<BActor>> call, Response<List<BActor>> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    JActoresAdapter adaptador = new JActoresAdapter(response.body(), ActoresActivity.this);
                    peliculasRecyclerView.setAdapter(adaptador);
                } else {
                    mostrarMessage("Ocurrío un problema en el servidor");
                }
            }

            @Override
            public void onFailure(Call<List<BActor>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                mostrarMessage("Error al obtener películas: " + t.getMessage());
            }
        });

    }

    private void mostrarMessage(String mensaje) {
        Snackbar.make(rootView, mensaje, Snackbar.LENGTH_LONG).show();
    }
}
