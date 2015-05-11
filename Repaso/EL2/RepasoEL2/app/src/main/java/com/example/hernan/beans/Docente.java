package com.example.hernan.beans;

import java.io.Serializable;

/**
 * Created by Hernan on 10/05/2015.
 */
public class Docente implements Serializable {
    private String docenteId;
    private String docenteNombre;
    private String docenteEmail;
    private String docenteTelefono;

    public String toString()
    {
        return docenteId + " - " + docenteNombre+ " - " + docenteEmail + " - " + docenteTelefono ;
    }

    public String getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(String docenteId) {
        this.docenteId = docenteId;
    }

    public String getDocenteNombre() {
        return docenteNombre;
    }

    public void setDocenteNombre(String docenteNombre) {
        this.docenteNombre = docenteNombre;
    }

    public String getDocenteEmail() {
        return docenteEmail;
    }

    public void setDocenteEmail(String docenteEmail) {
        this.docenteEmail = docenteEmail;
    }

    public String getDocenteTelefono() {
        return docenteTelefono;
    }

    public void setDocenteTelefono(String docenteTelefono) {
        this.docenteTelefono = docenteTelefono;
    }
}
