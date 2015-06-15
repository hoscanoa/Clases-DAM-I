package com.hoscanoa.developer.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.hoscanoa.developer.beans.Curso;
import com.hoscanoa.developer.beans.Profesor;
import com.hoscanoa.developer.daos.CursoDAO;
import com.hoscanoa.developer.daos.ProfesorDAO;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Spinner spnProfesor, spnCurso;
    Button btnVer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnProfesor = (Spinner) findViewById(R.id.spnProfesor);
        spnProfesor.setOnItemSelectedListener(this);
        cargaProfesor();
        spnCurso = (Spinner) findViewById(R.id.spnCurso);
        btnVer = (Button) findViewById(R.id.btnVer);
        btnVer.setOnClickListener(this);
    }

    private void cargaProfesor() {
        ProfesorDAO profesorDAO = new ProfesorDAO(this);
        ArrayList<Profesor> lista = profesorDAO.listar();
        ArrayAdapter<Profesor> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lista);
        spnProfesor.setAdapter(adapter);
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
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent==spnProfesor)
        {
            CursoDAO cursoDAO = new CursoDAO(this);
            Profesor profesor = (Profesor) spnProfesor.getSelectedItem();
            ArrayList<Curso> lista = cursoDAO.listar(profesor.getProfesorId());
            ArrayAdapter<Curso> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lista);
            spnCurso.setAdapter(adapter);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if(v==btnVer)
        {
            Curso curso = (Curso)spnCurso.getSelectedItem();
            Intent ir = new Intent(this, TablaActivity.class);
            ir.putExtra("cursoId",curso.getCursoId());
            startActivity(ir);
        }
    }
}
