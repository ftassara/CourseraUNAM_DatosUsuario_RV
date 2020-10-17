package com.ftassara.courseraunam_datosusuario;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoViewHolder> {
    ArrayList<Contacto> data;
    OnElementClickListener ELementClickListener;
    public ContactoAdapter(ArrayList<Contacto> data,OnElementClickListener onElementClickListener) {
        this.data = data;
        this.ELementClickListener = onElementClickListener;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        //aca hago todos los setTExt en base a la posicion
        Contacto contacto = data.get(position);
        holder.imgFoto.setImageResource(contacto.getFoto());
        holder.tvNombre.setText(contacto.getContacto());
        holder.tvTelefono.setText(contacto.getTelefono());
        holder.tvMail.setText(contacto.getMail());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    interface OnElementClickListener {
        void setElementOnClickListener(int position);
    }
}