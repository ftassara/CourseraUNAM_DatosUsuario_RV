package com.ftassara.courseraunam_datosusuario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(miToolBar);
        listaContactos = (RecyclerView) findViewById(R.id.recyclerview);
        //Creo el Layou Manager, en este caso lineal, y lo asocio al recycler view, asi pone una abajo de otra (porque es linear)
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);

        initListaContactos();
        incializarAdaptador();





    }
    public void incializarAdaptador(){
        ContactoAdapter.OnElementClickListener ElementClickListener = new ContactoAdapter.OnElementClickListener() {
            @Override
            public void setElementOnClickListener(int i) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pcontacto),contactos.get(i).getContacto());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pmail),contactos.get(i).getMail());
                startActivity(intent);
                finish();
            }
        };
        ContactoAdapter adapter =  new ContactoAdapter(contactos,ElementClickListener);
        listaContactos.setAdapter(adapter);
    }
    private void initListaContactos() {
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.icons8_telefono_24,"Francisco Tassara","111111","mail1@mail.com"));
        contactos.add(new Contacto(R.drawable.icons8_telefono_24,"Fran Tassara","22222","mail2@mail.com"));
        contactos.add(new Contacto(R.drawable.icons8_subir_correo_24,"F Tassara","33333","mail3@mail.com"));
        contactos.add(new Contacto(R.drawable.icons8_subir_correo_24,"Francisco Tass","44444","mail4@mail.com"));
    }


}