package xyz.cumaki.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import xyz.cumaki.cardview.Adaptadores.Imagenes;

public class imagene_productos extends AppCompatActivity {
    RecyclerView imagenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagene_productos);


        imagenes = (RecyclerView) findViewById(R.id.Imagenes);
        imagenes.setHasFixedSize(true);
        imagenes.setLayoutManager(new GridLayoutManager(this, 2));


        Bundle b = this.getIntent().getExtras();
        String [] imag = b.getStringArray("Imagenes");
        List<String> lstImagenes = Arrays.asList(imag);

        Imagenes adapterIma = new Imagenes(this, lstImagenes);
        imagenes .setAdapter(adapterIma);
    }
}