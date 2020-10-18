package com.ftassara.courseraunam_datosusuario;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity implements ContactoAdapter.onContactoListener {
    ArrayList<Mascotas> mMascotasFav;
    private RecyclerView listaMascotasFav;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        Log.d("Favoritos","Si, entro a favoritos");
        //Defino la toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    listaMascotasFav = (RecyclerView) findViewById(R.id.recyclerviewfav);
    //Creo el Layou Manager, en este caso lineal, y lo asocio al recycler view, asi pone una abajo de otra (porque es linear)
    LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFav.setLayoutManager(llm);

    initListaContactos();
    incializarAdaptador();
    }


    public void incializarAdaptador(){
        ContactoAdapter adapter =  new ContactoAdapter(mMascotasFav,this);
        listaMascotasFav.setAdapter(adapter);
    }
    private void initListaContactos() {
        mMascotasFav = new ArrayList<Mascotas>();
        mMascotasFav.add(new Mascotas(R.drawable.perro1,"Perro A","0"));
        mMascotasFav.add(new Mascotas(R.drawable.perro2,"Perro B","0"));
        mMascotasFav.add(new Mascotas(R.drawable.perro1,"Perro C","0"));
        mMascotasFav.add(new Mascotas(R.drawable.perro2,"Perro D","0"));
        mMascotasFav.add(new Mascotas(R.drawable.perro1,"Perro E","0"));
    }

    @Override
    public void onContactoClic(int i) {
        Log.d("OnContactoClic","Boton apretad");
//        Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
////        intent.putExtra(getResources().getString(R.string.pcontacto),contactos.get(i).getContacto());
////        intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(i).getTelefono());
////        intent.putExtra(getResources().getString(R.string.pmail),contactos.get(i).getMail());
//        startActivity(intent);
////        finish();
    }
}
