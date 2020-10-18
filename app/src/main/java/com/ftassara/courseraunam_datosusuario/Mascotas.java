package com.ftassara.courseraunam_datosusuario;

public class Mascotas {

    private String Nombre;
    private String Rating;
//    private String Mail;
       private int Foto;


    public Mascotas(int foto, String contacto, String rating) {
        Nombre = contacto;
        Rating = rating;
//        Mail = mail;
        Foto = foto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }


    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }
}
