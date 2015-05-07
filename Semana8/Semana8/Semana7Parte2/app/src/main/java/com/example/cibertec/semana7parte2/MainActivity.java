package com.example.cibertec.semana7parte2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pe.edu.cibertec.beans.Docente;
import pe.edu.cibertec.conexion.MySQLHelper;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button btnGrabar;
    int estado =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGrabar = (Button) findViewById(R.id.btnGrabar);
        btnGrabar.setOnClickListener(this);

        Intent rec = getIntent();
        if(rec.getSerializableExtra("doc")!=null) {
            estado=1;
            Docente obj = (Docente) rec.getSerializableExtra("doc");

            ((EditText) findViewById(R.id.edtId)).setText(obj.getDocenteId());
            (findViewById(R.id.edtId)).setEnabled(false);

            ((EditText) findViewById(R.id.edtNombre)).setText(obj.getDocenteNombre());
            ((EditText) findViewById(R.id.edtEmail)).setText(obj.getDocenteEmail());
            ((EditText) findViewById(R.id.edtTelefono)).setText(obj.getDocenteTelefono());
        }

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
        if(v==btnGrabar)
        {
            try {
                MySQLHelper sql = new MySQLHelper(this,null,null,1);
                SQLiteDatabase db = sql.getWritableDatabase();

                Docente obj = new Docente();
                obj.setDocenteId(((EditText)findViewById(R.id.edtId)).getText().toString());
                obj.setDocenteNombre(((EditText) findViewById(R.id.edtNombre)).getText().toString());
                obj.setDocenteEmail(((EditText) findViewById(R.id.edtEmail)).getText().toString());
                obj.setDocenteTelefono(((EditText) findViewById(R.id.edtTelefono)).getText().toString());
                if(estado==0) {
                    db.execSQL("INSERT INTO DOCENTE VALUES(?,?,?,?);", new Object[]{obj.getDocenteId(),

                            obj.getDocenteNombre(),
                            obj.getDocenteEmail(),
                            obj.getDocenteTelefono()});
                }
                else {

                    db.execSQL("UPDATE DOCENTE SET docenteNombre=?, docenteEmail=?, docenteTelefono=? WHERE docenteId=?;", new Object[]{
                            obj.getDocenteNombre(),
                            obj.getDocenteEmail(),
                            obj.getDocenteTelefono(),
                            obj.getDocenteId()});
                }
                AlertDialog alerta = new AlertDialog.Builder(this).create();
                alerta.setTitle("Confirmación");
                alerta.setMessage("Registro de Grabado");
                alerta.setIcon(R.drawable.donwload);
                alerta.setButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent ir = new Intent(getApplicationContext(),ListadoActivity.class);
                        startActivity(ir);
                    }
                });
                alerta.show();

            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
