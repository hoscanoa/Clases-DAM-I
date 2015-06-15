package pe.edu.cibertec.ws;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

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

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.bodyOut=soap;
            envelope.dotNet=true;
            envelope.encodingStyle=SoapSerializationEnvelope.XSD;

            HttpTransportSE transporte = null;
            try {
                String URL="http://10.0.2.2:52148/Service.asmx";
                transporte = new HttpTransportSE(URL);
                transporte.debug=true;
                transporte.call("http://tempuri.org/Grabar",envelope);
                res=envelope.getResponse().toString();

            }catch (Exception e)
            {
                res=e.getMessage();
            }
        }
        catch (Exception e)
        {
            res=e.getMessage();
        }
        return res;
    }
}
