package com.example.cibertec.dao;

import com.example.cibertec.beans.Usuario;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Cibertec on 14/04/2015.
 */
public class UsuarioDAO {
    ArrayList<Usuario> usuarios = new ArrayList<>();

    public UsuarioDAO()
    {
        Usuario obj;
        obj = new Usuario();
        obj.setDni("11111111");
        obj.setNombre("Juana Perez");
        obj.setTelefono("949845621");
        obj.setFacebook("http://www.google.com.pe");

        usuarios.add(obj);


        obj = new Usuario();
        obj.setDni("22222222");
        obj.setNombre("Juan Torres");
        obj.setTelefono("974755621");
        obj.setFacebook("http://www.google.com.pe");

        usuarios.add(obj);


        obj = new Usuario();
        obj.setDni("33333333");
        obj.setNombre("Natalia Perez");
        obj.setTelefono("955845621");
        obj.setFacebook("http://www.google.com.pe");

        usuarios.add(obj);
    }

    public Usuario buscar(String dni)
    {
        Usuario obj = null;
        for(Usuario u : usuarios)
        {
            if(u.getDni().equals(dni))
            {
                obj = u;
                break;
            }
        }
        return obj;
    }

}
