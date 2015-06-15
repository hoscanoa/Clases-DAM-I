package com.hoscanoa.developer.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.hoscanoa.developer.beans.Alumno;
import com.hoscanoa.developer.daos.AlumnoDAO;

import java.util.ArrayList;


public class TablaActivity extends ActionBarActivity {

    int cursoId;
    TableLayout tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla);
        cursoId = (int) getIntent().getExtras().get("cursoId");
        tabla = (TableLayout)findViewById(R.id.tabla);
        cargarTabla();
    }

    private void cargarTabla() {
        AlumnoDAO alumnoDAO = new AlumnoDAO(this);
        ArrayList<Alumno> lista = alumnoDAO.listar(cursoId);

        TableRow fila;
        TextView alumnoId, nombres, fechaNacimiento;

        fila = new TableRow(this);

        alumnoId = new TextView(this);
        alumnoId.setText("Código");

        nombres = new TextView(this);
        nombres.setText("Nombre");

        fechaNacimiento = new TextView(this);
        fechaNacimiento.setText("Nacimiento");

        fila.addView(alumnoId);
        fila.addView(nombres);
        fila.addView(fechaNacimiento);

        tabla.addView(fila);

        for (Alumno a : lista)
        {
            fila = new TableRow(this);
            alumnoId = new TextView(this);
            alumnoId.setText(""+a.getAlumnoId());

            nombres = new TextView(this);
            nombres.setText(a.getNombres()+" "+a.getApellidoPaterno()+" "+a.getApellidoMaterno());

            fechaNacimiento = new TextView(this);
            fechaNacimiento.setText(a.getFechaNacimiento());

            fila.addView(alumnoId);
            fila.addView(nombres);
            fila.addView(fechaNacimiento);

            tabla.addView(fila);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabla, menu);
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
