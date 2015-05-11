package com.example.hernan.repasoel2;

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

import com.example.hernan.adapter.MiAdaptador;
import com.example.hernan.beans.Docente;
import com.example.hernan.conexion.MiSQLHelper;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    ListView lstDocentes;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Docente> docentes = new ArrayList<>();
        MiSQLHelper miSQLHelper = new MiSQLHelper(this, null, null, 1);
        SQLiteDatabase db = miSQLHelper.getReadableDatabase();

        Cursor q = db.rawQuery("SELECT * FROM docente;", null);
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
        lstDocentes=(ListView)findViewById(R.id.lstDocentes);

        //ArrayAdapter<Docente> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,docentes);

        MiAdaptador adapter = new MiAdaptador(this,docentes);


        lstDocentes.setAdapter(adapter);

        lstDocentes.setOnItemClickListener(this);
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
        if(id==R.id.menuVer)
        {

            Docente obj = (Docente)(lstDocentes.getItemAtPosition(pos));
            Intent ir = new Intent(this,MainActivity2Activity.class);
            ir.putExtra("doc",obj);
            startActivity(ir);
        }
        if(id==R.id.menuNuevo)
        {
            Intent ir = new Intent(this,MainActivity2Activity.class);
            startActivity(ir);
        }
        if(id==R.id.menuEliminar)
        {

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        pos=position;
    }
}
