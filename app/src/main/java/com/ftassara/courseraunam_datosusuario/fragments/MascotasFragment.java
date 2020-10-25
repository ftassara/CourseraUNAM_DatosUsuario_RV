package com.ftassara.courseraunam_datosusuario.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ftassara.courseraunam_datosusuario.R;
import com.ftassara.courseraunam_datosusuario.adapter.ContactoAdapter;
import com.ftassara.courseraunam_datosusuario.adapter.MascotaAdapter;
import com.ftassara.courseraunam_datosusuario.pojo.Mascotas;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MascotasFragment extends Fragment  implements ContactoAdapter.onContactoListener{
    private RecyclerView listaMascotas;
    ArrayList<Mascotas> mMascotas;
    private ImageView imgMascota;
    private TextView nameMascota;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_mascotas,container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.recyclerview);
        imgMascota = (ImageView) v.findViewById(R.id.imgMascota);
        nameMascota = (TextView) v.findViewById(R.id.textMascota);

        //Creo el Layou Manager, en este caso lineal, y lo asocio al recycler view, asi pone una abajo de otra (porque es linear)
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(glm);


        initGridFotos();
        incializarAdaptador();
        return v;
    }

    public void incializarAdaptador(){
        MascotaAdapter adapter =  new MascotaAdapter(mMascotas, this);
        listaMascotas.setAdapter(adapter);
    }
    private void initGridFotos() {
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