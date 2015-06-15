package com.hoscanoa.developer.beans;

/**
 * Created by Hernan on 15/06/2015.
 */
public class Curso {
    private int cursoId;
    private String descripcion;
    private int creditos;

    @Override
    public String toString() {
        return descripcion;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
}
