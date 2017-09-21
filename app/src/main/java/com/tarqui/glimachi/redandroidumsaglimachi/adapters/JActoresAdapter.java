package com.tarqui.glimachi.redandroidumsaglimachi.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.tarqui.glimachi.redandroidumsaglimachi.ActoresActivity;
import com.tarqui.glimachi.redandroidumsaglimachi.PeliculasActivity;
import com.tarqui.glimachi.redandroidumsaglimachi.R;
import com.tarqui.glimachi.redandroidumsaglimachi.model.BActor;
import java.util.ArrayList;
import java.util.List;



public class JActoresAdapter extends RecyclerView.Adapter<JActoresAdapter.DeviceViewHolder> {

    private Context context;
    private List<BActor> dataset;
    public JActoresAdapter(List<BActor> dataset, ActoresActivity context) {
        this.dataset = dataset;
        this.context = context;
//        this.onPeliculaSelectedListener = (OnPeliculaSelectedListener) context;
    }

    @Override
    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pelicula, parent, false);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DeviceViewHolder holder, int position) {
        BActor p = dataset.get(position);



        holder.tituloTextView.setText(p.getNombreActor());
        holder.descripcionTextView.setText(p.getDescription());

        //String url = "http://image.tmdb.org/t/p/w185" + p.getImagen();

        //String url="https://images-na.ssl-images-amazon.com/images/M/MV5BNDg1NTU2OWEtM2UzYi00ZWRmLWEwMTktZWNjYWQ1NWM1OThjXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_UX182_CR0,0,182,268_AL_.jpg";
        //String url = p.getPoster().getThumb();

        String url = p.getImage().getThumb();

        Glide.with(context).load(url).into(holder.fotoImageView);

//        holder.setOnPeliculaItemClick(p, onPeliculaItemClickListener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class DeviceViewHolder extends RecyclerView.ViewHolder {

        TextView tituloTextView;
        TextView descripcionTextView;
        ImageView fotoImageView;

        public DeviceViewHolder(View itemView) {
            super(itemView);

            tituloTextView = (TextView) itemView.findViewById(R.id.tituloTextView);
            descripcionTextView = (TextView) itemView.findViewById(R.id.descripcionTextView);
            fotoImageView = (ImageView) itemView.findViewById(R.id.fotoImageView);
        }
    }

    public void add(BActor actor) {
        dataset.add(actor);
        notifyDataSetChanged();
    }

    public void setDataset(List<BActor> listaObjetos) {
        if (listaObjetos == null) {
            dataset = new ArrayList<>();
        } else {
            dataset = listaObjetos;
        }
        notifyDataSetChanged();
    }

    public void clear() {
        dataset.clear();
        notifyDataSetChanged();
    }

}