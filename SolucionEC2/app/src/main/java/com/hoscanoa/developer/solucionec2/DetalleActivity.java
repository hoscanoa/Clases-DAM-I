package com.hoscanoa.developer.solucionec2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.hoscanoa.developer.solucionec2.beans.Jugador;


public class DetalleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Intent intent = getIntent();
        Jugador jugador = (Jugador)intent.getSerializableExtra("jugador");

        ImageView imgFoto = (ImageView)findViewById(R.id.imgFoto2);
        imgFoto.setImageResource(jugador.getFoto());

        ImageView imgBandera = (ImageView)findViewById(R.id.imgBandera2);
        imgBandera.setImageResource(jugador.getBandera());

        TextView txtNumero = (TextView)findViewById(R.id.txtNumero2);
        txtNumero.setText(""+jugador.getNumeroCamiseta());

        TextView txtNombre = (TextView)findViewById(R.id.txtNombre2);
        txtNombre.setText(jugador.getNombre());

        TextView txtPosicion = (TextView)findViewById(R.id.txtPosicion2);
        txtPosicion.setText(jugador.getPosicion());

        TextView txtFechaNacimiento = (TextView)findViewById(R.id.txtFechaNacimiento2);
        txtFechaNacimiento.setText(jugador.getFechaNacimiento());

        TextView txtObser = (TextView)findViewById(R.id.txtObservaciones2);
        txtObser.setText(jugador.getObservacion());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle, menu);
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
