using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Data.SqlClient;
using System.Data;

[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]

public class Service : System.Web.Services.WebService
{
    public Service () {

        //Elimine la marca de comentario de la línea siguiente si utiliza los componentes diseñados 
        //InitializeComponent(); 
    }

    [WebMethod]
    public string HelloWorld() {
        return "Hola a todos";
    }


    [WebMethod]
    public String Grabar(String cod, String nom, int nota)
    {
        String res="";
        try
        {
            SqlConnection cn = new SqlConnection("Integrated Security=true;initial catalog=WB; uid=sa; password=sql; server=.");
            SqlCommand cmd = new SqlCommand();
            cn.Open();
            cmd.Connection = cn;
            cmd.CommandType = CommandType.Text;
            cmd.CommandText = "INSERT INTO alumno values(@cod,@nom,@nota)";
            cmd.Parameters.AddWithValue("@cod", cod);
            cmd.Parameters.AddWithValue("@nom", nom);
            cmd.Parameters.AddWithValue("@nota", nota);
            res=cmd.ExecuteNonQuery()+" fila afectada";
            cn.Close();
        }
        catch (Exception e)
        {
            res = e.Message;
        }

        return res;
    }

    [WebMethod]
    public DataSet Listado()
    {
        DataSet ds = new DataSet();
        SqlConnection cn = new SqlConnection("Integrated Security=true;initial catalog=WB; uid=sa; password=sql; server=.");
        SqlDataAdapter da= new SqlDataAdapter("SELECT * FROM alumno",cn);
        da.Fill(ds);
        return ds;
    }


}