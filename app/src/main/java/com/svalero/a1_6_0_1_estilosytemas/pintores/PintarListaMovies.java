package com.svalero.a1_6_0_1_estilosytemas.pintores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.a1_6_0_1_estilosytemas.R;
import com.svalero.a1_6_0_1_estilosytemas.beans.Film;

import java.util.ArrayList;

public class PintarListaMovies
                    extends RecyclerView .Adapter<PintarListaMovies.FilmViewHolder>{
    private ArrayList<Film> lstFilms;

    public PintarListaMovies(ArrayList<Film> lstFilms){
        this.lstFilms = lstFilms;
    }
    /*Construir la fila sobre el lienzo*/
    /*La parte de pintado y su asistente ViewHolder*/
    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.
                    from(parent.getContext()).
                    inflate(R.layout.row, parent, false);
        return new FilmViewHolder(v);
    }

    /*Enlazado de los datos*/
    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder,
                                 int position) {
        Film film = lstFilms.get(position);
            holder.txtTitleFilm.setText(film.getTitulo());
            holder.txtOverviewFilm.setText(film.getSinopsis());

        /*****************TRAER IMAGEN**********************/
       /* String urlImage = "http://192.168.43.143:42644/RakutenTVAndroid/images/" +
                lstFilms.get(posFila).getUrl()+".png";
        String urlDePrueba =
                "http://192.168.43.143:42644/RakutenTVAndroid/images/mision_imposible.png";
        */

        /*Picasso o Glide*/
            /*Picasso.get().load(urlDePrueba).
                    into(holder.imgFilm);
            */

        /***************************************************/
    }

    @Override
    public int getItemCount() {
        return lstFilms.size();
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder{
            public ImageView imgFilm;
            public TextView txtTitleFilm;
            private TextView txtOverviewFilm;

            public FilmViewHolder(@NonNull View itemView) {
                super(itemView);
                imgFilm = itemView.findViewById(R.id.imgFilm);
                txtTitleFilm = itemView.findViewById(R.id.txtTitleFilm);
                txtOverviewFilm = itemView.findViewById(R.id.txtOverviewFilm);
            }
        }

}
