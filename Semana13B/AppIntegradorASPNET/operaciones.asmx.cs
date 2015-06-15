using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace AppIntegradorASPNET
{
    /// <summary>
    /// Summary description for operaciones
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class operaciones : System.Web.Services.WebService
    {

        [WebMethod]
        public String Sumar(Int32 pNumero1, Int32 pNumero2)
        {
            return (pNumero1 + pNumero2).ToString();
        }
    }
}
