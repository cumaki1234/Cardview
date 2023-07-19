package xyz.cumaki.cardview.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import xyz.cumaki.cardview.Modelo.Producto;
import xyz.cumaki.cardview.R;
import xyz.cumaki.cardview.imagene_productos;

public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.ProductoViewHolder>{

    private Context Ctx;
    private List<Producto> lstProducto;

    public AdaptadorProducto(Context mCtx, List<Producto> productos){
        this.lstProducto= productos;
        this.Ctx = mCtx;
    }
    @NonNull
    @Override
    public AdaptadorProducto.ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.lyitem, null);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorProducto.ProductoViewHolder holder, int position) {
        Producto usuario = lstProducto.get(position);
        holder.txtTitle.setText(usuario.getTitle());
        holder.txtPrecio.setText(usuario.getPrice());
        holder.txtDescripcion.setText(usuario.getRating());


        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();

                b.putStringArray("Imagenes", usuario.getImagenes());
                b.putString("Titulo", usuario.getTitle());
                b.putString("Descripcion", usuario.getDescription());

                Intent intent = new Intent(Ctx, imagene_productos.class);
                intent.putExtras(b);
                Ctx.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return lstProducto.size();
    }
    class ProductoViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle,txtPrecio,txtDescripcion;

        ImageView imgItem;
        CardView cardview;
        public ProductoViewHolder(View itemView){
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
            imgItem= itemView.findViewById(R.id.imgItem);
            cardview = itemView.findViewById(R.id.Item);
        }
    }
}
