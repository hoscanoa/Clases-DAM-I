package com.hoscanoa.developer.solucionec2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hoscanoa.developer.solucionec2.adapter.MiAdaptador;
import com.hoscanoa.developer.solucionec2.beans.Jugador;
import com.hoscanoa.developer.solucionec2.conexion.MiConexion;

import java.util.ArrayList;


public class ListadoActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{

    ListView lstJugadores;
    MiAdaptador adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        MiConexion miSQLHelper = new MiConexion(this, null, null, 1);
        SQLiteDatabase db = miSQLHelper.getReadableDatabase();

        Cursor q = db.rawQuery("SELECT * FROM JUGADOR;", null);
        Jugador obj;
        while (q.moveToNext())
        {
            obj = new Jugador();
            obj.setNombre(q.getString(0));
            obj.setFechaNacimiento(q.getString(1));
            obj.setEdad(q.getInt(2));
            obj.setNumeroCamiseta(q.getInt(3));
            obj.setPosicion(q.getString(4));
            obj.setObservacion(q.getString(5));
            obj.setFoto(q.getInt(6));
            obj.setBandera(q.getInt(7));
            jugadores.add(obj);
        }
        lstJugadores=(ListView)findViewById(R.id.lstJugadores);

        adapter = new MiAdaptador(this,jugadores);
        lstJugadores.setAdapter(adapter);
        lstJugadores.setOnItemClickListener(this);
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent ir = new Intent(this, DetalleActivity.class);
        Jugador obj=(Jugador)(lstJugadores.getItemAtPosition(position));
        ir.putExtra("jugador", obj);
        startActivity(ir);
    }
}
