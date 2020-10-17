package com.ftassara.courseraunam_datosusuario;

public class Contacto {

    private String Contacto;
    private String Telefono;
    private String Mail;
    private int Foto;




    public Contacto(int foto, String contacto, String telefono, String mail) {
        Contacto = contacto;
        Telefono = telefono;
        Mail = mail;
        Foto = foto;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String contacto) {
        Contacto = contacto;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        this.Foto = foto;
    }
}
