package com.example.cibertec.beans;

import java.io.Serializable;

/**
 * Created by Cibertec on 14/04/2015.
 */
public class Usuario implements Serializable {
    private String dni;
    private String nombre;
    private String telefono;
    private String facebook;


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }
}
