package com.ftassara.courseraunam_datosusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetalleContacto extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);
        Bundle extras = getIntent().getExtras();
        String contacto = extras.getString(getResources().getString(R.string.pcontacto));
        String telefono = extras.getString(getResources().getString(R.string.ptelefono));
        String mail = extras.getString(getResources().getString(R.string.pmail));


        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvMail = (TextView) findViewById(R.id.tvMail);
//ASIGNO EL VALOR A CADA TEXT VIEW
        tvNombre.setText(contacto);
        tvTelefono.setText(telefono);
        tvMail.setText(mail);

    }

    public void llamar(View v){
        String telefono = tvTelefono.getText().toString();
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));

    }

    public void mail (View v){
        String mail = tvMail.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:" + mail));
        emailIntent.putExtra(Intent.EXTRA_EMAIL,mail);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"Email"));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}