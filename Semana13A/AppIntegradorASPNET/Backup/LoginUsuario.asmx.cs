using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Data.SqlClient;
using System.Data;

namespace AppIntegradorASPNET
{
    /// <summary>
    /// Summary description for LoginUsuario
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class LoginUsuario : System.Web.Services.WebService
    {

        [WebMethod]
        public string ValidarUsuario(String pLoginUsuario, String pContrasenia)
        {
            String StrResultado = "0";
            SqlConnection oconexion = new SqlConnection("server=....;uid=BaseDatos;password=...;database=BaseDatos;");
            SqlCommand ocomando = new SqlCommand("[uspUsuario_Android_ValidarUsuario]", oconexion);
            ocomando.Parameters.Add("@LoginUsuario", SqlDbType.VarChar, 50).Value = pLoginUsuario;
            ocomando.Parameters.Add("@Contrasenia", SqlDbType.VarChar, 150).Value = pContrasenia;
            ocomando.Connection = oconexion;
            ocomando.CommandType = CommandType.StoredProcedure;
            try
            {
                oconexion.Open();
                SqlDataReader oDataReader = ocomando.ExecuteReader();
                while (oDataReader.Read())
                {
                    StrResultado = oDataReader.GetInt32(0).ToString() + "|" +
                        oDataReader.GetString(1).ToString() + "|" +
                            oDataReader.GetString(2).ToString() + "|" +
                                oDataReader.GetString(3).ToString() + "|" +
                                    oDataReader.GetString(4).ToString();
                }
            }
            catch (Exception e)
            {
                throw new Exception("ValidarUsuario():" + e.Message);
            }
            finally
            {
                if (oconexion.State == ConnectionState.Open) { oconexion.Close(); }
                ocomando.Dispose();
                oconexion.Dispose();
            }
            return StrResultado;
        }
    }
}
