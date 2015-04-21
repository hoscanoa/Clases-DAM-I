package pe.edu.cibertec.dami_el1.dao;

import java.util.ArrayList;

import pe.edu.cibertec.dami_el1.R;
import pe.edu.cibertec.dami_el1.bean.Usuario;

/**
 * Created by Cibertec on 20/04/2015.
 */
public class UsuarioDAO {

    public ArrayList<Usuario> usuarios = new ArrayList<>();

    public UsuarioDAO()
    {
        usuarios.add(new Usuario("jperez","123","JUANA PEREZ",1,"5684215","juana@gmail.com",'F',0, R.drawable.juana,"http://www.google.com"));
        usuarios.add(new Usuario("perez","123","PEDRO PEREZ",1,"2784222","pedro@gmail.com",'M',1, R.drawable.pedro,"http://www.yahoo.com"));
        usuarios.add(new Usuario("jpere","123","LUIS PEREZ",0,"1234217","luis@gmail.com",'M',2, R.drawable.luis,"http://www.bing.com"));
    }

    public Usuario buscar(String login, String pass)
    {
        for(Usuario u: usuarios)
        {
            if(u.getLogin().equals(login) && u.getPassword().equals(pass))
                return u;
        }
        return null;
    }

}
