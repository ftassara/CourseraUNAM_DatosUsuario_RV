package com.ftassara.courseraunam_datosusuario.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ftassara.courseraunam_datosusuario.R;
import com.ftassara.courseraunam_datosusuario.activities.FavoritosActivity;
import com.ftassara.courseraunam_datosusuario.activities.MainActivity;
import com.ftassara.courseraunam_datosusuario.adapter.ContactoAdapter;
import com.ftassara.courseraunam_datosusuario.pojo.Mascotas;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment implements ContactoAdapter.onContactoListener {
    private RecyclerView listaMascotas;
    ArrayList<Mascotas> mMascotas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recycler,container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.recyclerview);
        //Creo el Layou Manager, en este caso lineal, y lo asocio al recycler view, asi pone una abajo de otra (porque es linear)
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);


        initListaContactos();
        incializarAdaptador();
        return v;
    }

    public void incializarAdaptador(){
        ContactoAdapter adapter =  new ContactoAdapter(mMascotas, this);
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


}
