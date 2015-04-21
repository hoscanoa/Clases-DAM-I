package pe.edu.cibertec.dami_el1.bean;

import java.io.Serializable;

/**
 * Created by Cibertec on 20/04/2015.
 */
public class Usuario implements Serializable {
    private String login;
    private String password;
    private String nombre;
    private int ingles;
    private String telefono;
    private String email;
    private char sexo;
    private int distrito;
    private int foto;
    private String facebook;

    public  Usuario()
    {}

    public  Usuario(String login, String password, String nombre, int ingles, String telefono, String email, char sexo, int distrito, int foto, String facebook)
    {
        this.login=login;
        this.password=password;
        this.nombre=nombre;
        this.telefono=telefono;
        this.setIngles(ingles);
        this.email=email;
        this.sexo=sexo;
        this.distrito=distrito;
        this.foto=foto;
        this.facebook=facebook;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getDistrito() {
        return distrito;
    }

    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public int getIngles() {
        return ingles;
    }

    public void setIngles(int ingles) {
        this.ingles = ingles;
    }
}
