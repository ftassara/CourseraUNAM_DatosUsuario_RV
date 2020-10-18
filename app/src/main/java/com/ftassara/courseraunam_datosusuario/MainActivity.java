package com.ftassara.courseraunam_datosusuario;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements ContactoAdapter.onContactoListener {
    ArrayList<Mascotas> mMascotas;
    private RecyclerView listaMascotas;
    ImageView imgFav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Defino la toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        listaMascotas = (RecyclerView) findViewById(R.id.recyclerview);
        //Creo el Layou Manager, en este caso lineal, y lo asocio al recycler view, asi pone una abajo de otra (porque es linear)
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        initListaContactos();
        incializarAdaptador();

        imgFav = (ImageView) findViewById(R.id.imgFav);
        imgFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navaFAV(view);
            }
        });



    }
    public void incializarAdaptador(){
        ContactoAdapter adapter =  new ContactoAdapter(mMascotas,this);
        listaMascotas.setAdapter(adapter);
    }
    private void initListaContactos() {
        mMascotas = new ArrayList<Mascotas>();
        mMascotas.add(new Mascotas(R.drawable.perro1,"Perro A","1"));
        mMascotas.add(new Mascotas(R.drawable.perro2,"Perro B","0"));
        mMascotas.add(new Mascotas(R.drawable.perro1,"Perro C","1"));
        mMascotas.add(new Mascotas(R.drawable.perro2,"Perro D","0"));
        mMascotas.add(new Mascotas(R.drawable.perro1,"Perro E","1"));
        mMascotas.add(new Mascotas(R.drawable.perro1,"Perro F","0"));
        mMascotas.add(new Mascotas(R.drawable.perro1,"Perro G","1"));
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

    public void navaFAV (View v){
        Log.d("navaFAV","Boton apretado");
        Intent intent = new Intent(MainActivity.this, FavoritosActivity.class);
        startActivity(intent);
    }

}