package com.example.cibertec.semana7parte2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import pe.edu.cibertec.beans.Docente;
import pe.edu.cibertec.conexion.MySQLHelper;


public class ListadoActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{

    ListView lsvDocentes;
    int posi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        ArrayList<Docente> docentes = new ArrayList<>();
        MySQLHelper sql = new MySQLHelper(this,null,null,1);
        SQLiteDatabase db = sql.getReadableDatabase();
        Cursor q = db.rawQuery("SELECT * FROM DOCENTE;",null);
        Docente obj;
        while (q.moveToNext())
        {
            obj = new Docente();
            obj.setDocenteId(q.getString(0));
            obj.setDocenteNombre(q.getString(1));
            obj.setDocenteEmail(q.getString(2));
            obj.setDocenteTelefono(q.getString(3));
            docentes.add(obj);
        }

        lsvDocentes = (ListView)findViewById(R.id.lsvDocentes);

        ArrayAdapter<Docente> adapter = new ArrayAdapter<Docente>(this,android.R.layout.simple_list_item_1, docentes);
        lsvDocentes.setAdapter(adapter);

        lsvDocentes.setOnItemClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listado, menu);
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
        if(id==R.id.menuNuevo)
        {
            Intent ir = new Intent(this,MainActivity.class);
            startActivity(ir);
        }
        if(id==R.id.menuVer)
        {
            int position=lsvDocentes.getSelectedItemPosition();
            Docente obj=(Docente)lsvDocentes.getItemAtPosition(posi);
            Intent ir = new Intent(this,MainActivity.class);
            ir.putExtra("doc",obj);
            startActivity(ir);
        }
        if(id==R.id.menuEliminar)
        {
            int position=lsvDocentes.getSelectedItemPosition();
            Docente obj=(Docente)lsvDocentes.getItemAtPosition(position);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        posi = position;
    }
}
