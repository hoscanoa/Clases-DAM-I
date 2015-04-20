package com.example.cibertec.semana1parte2;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity  {

  //  Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // btnCalcular = (Button)findViewById(R.id.btnCalcular);
       // btnCalcular.setOnClickListener(this);
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
        /*
    @Override
    public void onClick(View v) {
        if(v==btnCalcular)
        {
            EditText edtSoles = (EditText)findViewById(R.id.edtSoles);
            EditText edtTasa = (EditText)findViewById(R.id.edtTasa);
            TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
            double soles = Double.parseDouble(edtSoles.getText().toString());
            double tasa = Double.parseDouble(edtTasa.getText().toString());

            double dolares = soles/tasa;
            txtResultado.setText(String.valueOf(dolares));


        }
    }    */

    public void calcularOnClick(View v) {


        EditText edtSoles = (EditText)findViewById(R.id.edtSoles);
        EditText edtTasa = (EditText)findViewById(R.id.edtTasa);
        TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
        double soles = Double.parseDouble(edtSoles.getText().toString());
        double tasa = Double.parseDouble(edtTasa.getText().toString());

        double dolares = soles/tasa;
        txtResultado.setText(String.valueOf(dolares));


    }
}