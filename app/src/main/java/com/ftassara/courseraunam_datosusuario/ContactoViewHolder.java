package com.ftassara.courseraunam_datosusuario;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView imgFoto;
    public TextView  tvNombre;
    public TextView tvTelefono;
    public TextView tvMail;
    ContactoAdapter.onContactoListener listener;
    public ContactoViewHolder(@NonNull View itemView,ContactoAdapter.onContactoListener listener) {
        super(itemView);

        //aca defino todos los views dentro del "cardview layout"
        imgFoto = (ImageView) itemView.findViewById(R.id.foto);
        tvNombre = (TextView) itemView.findViewById(R.id.cvnombre);
        tvTelefono = (TextView) itemView.findViewById(R.id.cvrating);
        this.listener=listener;
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        listener.onContactoClic(getAdapterPosition());
    }
}
