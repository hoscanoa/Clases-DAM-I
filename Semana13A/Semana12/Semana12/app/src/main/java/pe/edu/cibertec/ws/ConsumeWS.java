package pe.edu.cibertec.ws;

import org.ksoap2.serialization.SoapObject;

/**
 * Created by Cibertec on 08/06/2015.
 */
public class ConsumeWS {

    public String Grabar(String cod, String nom, int nota)
    {
        String res="";
        try {
            SoapObject soap = new SoapObject("http://tempuri.org/","Grabar");
            soap.addProperty("cod",cod);
            soap.addProperty("nom",nom);
            soap.addProperty("nota",nota);
        }
        catch (Exception e)
        {
            res=e.getMessage();
        }
        return res;
    }
}
