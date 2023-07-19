package xyz.cumaki.cardview.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import xyz.cumaki.cardview.R;

public class Imagenes extends RecyclerView.Adapter<Imagenes.ImagenesViewHolder> {
    private Context Ctx;
    private List<String> lstImagenes;
    public Imagenes(Context mCtx, List<String> imagenes) {
        this.lstImagenes = imagenes;
        Ctx = mCtx;
    }

    @NonNull
    @Override
    public Imagenes.ImagenesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.lyimagenes, null);
        return new Imagenes.ImagenesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Imagenes.ImagenesViewHolder holder, int position) {
        String imagen = lstImagenes.get(position);


    }

    @Override
    public int getItemCount() {
        return lstImagenes.size();
    }
    class ImagenesViewHolder extends RecyclerView.ViewHolder {

        ImageView imgItem;
        CardView Item;

        public ImagenesViewHolder(View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            Item = itemView.findViewById(R.id.Item);
        }
    }
}
