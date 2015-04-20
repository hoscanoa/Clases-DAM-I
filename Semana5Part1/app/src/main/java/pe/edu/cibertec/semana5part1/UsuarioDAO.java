package pe.edu.cibertec.semana5part1;

import java.util.ArrayList;

/**
 * Created by Cibertec on 13/04/2015.
 */
public class UsuarioDAO {

    ArrayList<Usuario> usuarios = new ArrayList<>();

    public  UsuarioDAO()
    {
        Usuario obj;
        for (int i=1;i<=5;i++)
        {
            obj = new Usuario();
            obj.setLogin("CIBERTEC"+i);
            obj.setPassword("PWD"+i);
            obj.setNombre("NOMBRE"+i);
            obj.setCorreo("CORREO" + i);
            usuarios.add(obj);
        }
    }

    public Usuario Buscar(String login, Strign password)
    {
        Usuario usuario = null;

        

        return usuario;
    }
}
