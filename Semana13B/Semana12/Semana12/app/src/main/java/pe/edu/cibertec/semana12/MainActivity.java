package pe.edu.cibertec.semana12;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pe.edu.cibertec.ws.ConsumeWS;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button btnok;
    ProgressDialog pd=null;
    String res="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnok=(Button)findViewById(R.id.btnOk);
        btnok.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {
        if(v == btnok){

            pd=ProgressDialog.show(this,
                    "Ejecutando",
                    "Espere profavor",true,false);

            new Tarea().execute();

        }
    };


    private class Tarea extends AsyncTask<String , Void , Object>{
        @Override
        protected Object doInBackground(String... params) {
            ConsumeWS ws = new ConsumeWS();
            res= ws.Grabar("A0002","Ana",15);
            return null;
        }

        protected void onPostExecute(Object result){
            pd.dismiss();
            Toast.makeText(getBaseContext(),res,Toast.LENGTH_LONG).show();
        }
    }
}









