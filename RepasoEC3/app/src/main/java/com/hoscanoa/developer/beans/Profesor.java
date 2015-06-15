package com.hoscanoa.developer.beans;

/**
 * Created by Hernan on 15/06/2015.
 */
public class Profesor {
    private int profesorId;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;

    @Override
    public String toString() {
        return nombres+" "+apellidoPaterno+" "+apellidoMaterno;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
}
