package com.tarqui.glimachi.redandroidumsaglimachi;

import com.tarqui.glimachi.redandroidumsaglimachi.model.BActor;
import com.tarqui.glimachi.redandroidumsaglimachi.model.BPelicula;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by pc_practica on 20/09/2017.
 */

public interface TheMovieDatabaseService {
    @GET("find/movie")
    Call<List<BPelicula>> obtenerPeliculas(@Query("title") String titulo);

    @GET("find/person")
    Call<List<BActor>> obtenerActores(@Query("name") String nombreActor);
}
