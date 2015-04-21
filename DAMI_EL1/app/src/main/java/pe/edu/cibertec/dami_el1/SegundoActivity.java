package pe.edu.cibertec.dami_el1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import pe.edu.cibertec.dami_el1.bean.Usuario;


public class SegundoActivity extends Activity implements View.OnClickListener {

    TextView txtNombre, txtEmail, txtIngles;
    RadioGroup rg;
    EditText edtTelefono;
    CheckBox chkIngles;
    Spinner spDistritos;
    ImageView imgFoto;
    Button btnVerFacebook;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        spDistritos = (Spinner)findViewById(R.id.spnDistrito);
        txtNombre = (TextView)findViewById(R.id.txtNombre);
        txtEmail = (TextView)findViewById(R.id.txtEmail);
        edtTelefono = (EditText)findViewById(R.id.edtTelefono);
        chkIngles = (CheckBox)findViewById(R.id.chkIngles);
        imgFoto = (ImageView)findViewById(R.id.imgFoto);
        btnVerFacebook=(Button)findViewById(R.id.btnVerFacebook);
        btnVerFacebook.setOnClickListener(this);

        String distritos[]={"Los Olivos", "La Victoria", "Comas"};
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,distritos);
        spDistritos.setAdapter(myAdapter);

        usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        txtNombre.setText(usuario.getNombre());
        txtEmail.setText(usuario.getEmail());
        edtTelefono.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.phone,0);
        edtTelefono.setText(usuario.getTelefono());


        if(usuario.getIngles()==0)
        {
            chkIngles.setChecked(false);
        }
        else
        {
            chkIngles.setChecked(true);
        }

        spDistritos.setSelection(usuario.getDistrito());

        if(usuario.getSexo()=='M')
        {
            RadioButton rbM = (RadioButton) findViewById(R.id.rbM);
            rbM.setChecked(true);
        }
        else
        {
            RadioButton rbF = (RadioButton) findViewById(R.id.rbF);
            rbF.setChecked(true);
        }

        imgFoto.setImageResource(usuario.getFoto());


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_segundo, menu);
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
        if(v==btnVerFacebook)
        {
            Intent intent = new Intent(this,TercerActivity.class);
            intent.putExtra("facebook",usuario.getFacebook());
            startActivity(intent);
        }
    }
}
