package com.example.cibertec.semana1parte1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    Button btnCalcular;
    EditText txtSoles, txtTasa;
    TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void calcularOnclick(View v)
    {
        txtSoles = (EditText)findViewById(R.id.edtSoles);
        txtTasa = (EditText)findViewById(R.id.edtTasa);
        lblResultado = (TextView)findViewById(R.id.txtResultado);

        Double soles = Double.parseDouble(txtSoles.getText().toString());
        Double tasa =  Double.parseDouble(txtTasa.getText().toString());

        lblResultado.setText("$"+Math.round(100*soles/tasa)/100.0);

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
}
