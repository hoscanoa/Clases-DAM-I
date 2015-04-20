package pe.edu.cibertec.semana4parte1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class ResultadoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent rec = getIntent();
        String opcion = rec.getExtras().get("opcionrec").toString();
        String tipo = rec.getExtras().get("tiporec").toString();

        WebView web = (WebView) findViewById(R.id.webView);

        if(tipo.equals("FACIL")){
            if(opcion.equals("A")){
                web.loadUrl("www.google.com.pe");
            }
            else if(opcion.equals("C")){
                web.loadUrl("www.yahoo.com");
            }
            else{
                web.loadUrl("www.gmail.com");
            }
        }
        else
        {
            if(opcion.equals("A")){
                web.loadUrl("www.hotmail.com");
            }
            else if(opcion.equals("C")){
                web.loadUrl("www.dropbox.com");
            }
            else{
                web.loadUrl("www.cibertec.edu.pe");
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resultado, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
