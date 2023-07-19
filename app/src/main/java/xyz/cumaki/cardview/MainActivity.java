package xyz.cumaki.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import xyz.cumaki.cardview.Adaptadores.AdaptadorProducto;
import xyz.cumaki.cardview.Modelo.Producto;
import xyz.cumaki.cardview.WebService.Asynchtask;
import xyz.cumaki.cardview.WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://dummyjson.com/products",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Producto> lstProductos = new ArrayList<Producto>();
        try {
            JSONObject JsonProuctos= new JSONObject(result);
            JSONArray productos = JsonProuctos.getJSONArray("products");

            ArrayList<Producto> listaproductos = Producto.JsonObjectsBuild(productos);

            int resId = R.anim.layout_animation_down_to_up;
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), resId);
            recyclerView.setLayoutAnimation(animation);

            AdaptadorProducto adapatorUsuario = new AdaptadorProducto(this, listaproductos);
            recyclerView.setAdapter(adapatorUsuario);


        }catch (JSONException e){ Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}