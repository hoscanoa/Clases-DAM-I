package pe.edu.cibertec.semana5part1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class IngresoActivity extends Activity implements View.OnClickListener {

    Button btnEntrar;
   // EditText edtUser, edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        btnEntrar = (Button)findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ingreso, menu);
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
        if(v==btnEntrar)
        {
            EditText edtUser=(EditText)findViewById(R.id.edtLogin);
            EditText edtPass=(EditText)findViewById(R.id.edtPassword);


            if(edtUser.getText().toString().isEmpty() || edtPass.getText().toString().isEmpty()){
                Toast.makeText(this,"Falta ingresar Usuario/Password",Toast.LENGTH_LONG).show();
                return;
            }

            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setMessage("Estas seguro de entrar?");
            alerta.setCancelable(false);
            alerta.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    EditText  edtUser=(EditText)findViewById(R.id.edtLogin);
                    EditText edtPass=(EditText)findViewById(R.id.edtPassword);

                    if(edtUser.getText().toString().equals("CIBERTEC") && edtPass.getText().toString().equals("123")){
                        Intent ir = new Intent(getBaseContext(), DatosActivity.class);
                        startActivity(ir);
                    }
                }
            });
            alerta.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alerta.show();
        }
    }
}
