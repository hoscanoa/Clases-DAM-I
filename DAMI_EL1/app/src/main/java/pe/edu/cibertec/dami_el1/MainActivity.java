package pe.edu.cibertec.dami_el1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.cibertec.dami_el1.bean.Usuario;
import pe.edu.cibertec.dami_el1.dao.UsuarioDAO;


public class MainActivity extends Activity implements View.OnClickListener {

    EditText edtUser, edtPass;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUser = (EditText)findViewById(R.id.edtUser);
        edtPass = (EditText)findViewById(R.id.edtPass);

        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this);




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
        if(v==btnIngresar)
        {
            String user, pass;
            user = edtUser.getText().toString();
            pass=edtPass.getText().toString();

            if(user.trim().isEmpty() || pass.trim().isEmpty())
            {
                Toast.makeText(this,"Debe ingresar un Usuario o Password",Toast.LENGTH_LONG).show();
            }
            else
            {

                UsuarioDAO dao = new UsuarioDAO();
                Usuario u= dao.buscar(user, pass);

                if(u!=null)
                {
                    Intent intent = new Intent(this, SegundoActivity.class);
                    intent.putExtra("usuario",u);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(this,"Usuario o Password incorrecto",Toast.LENGTH_LONG).show();
                }



            }
        }
    }
}
