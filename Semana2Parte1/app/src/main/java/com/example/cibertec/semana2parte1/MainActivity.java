package com.example.cibertec.semana2parte1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);
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
        if(v == btnCalcular)
        {
            double precio=0, recargo=0, subtotal=0, igv=0, total=0;
            Spinner spnDestino = (Spinner)findViewById(R.id.spnDestino);
            switch (spnDestino.getSelectedItemPosition())
            {
                case 0: precio=700;
                    break;
                case 1: precio=200;
                    break;
                default: precio=500;

            }

            RadioGroup rdgClase = (RadioGroup) findViewById(R.id.rdgClase);

            switch (rdgClase.getCheckedRadioButtonId())
            {
                case R.id.radioButton:
                    recargo= precio*0.2;
                    break;
                default:
                    recargo= precio*0.05;
            }

            EditText txtCantidad = (EditText) findViewById(R.id.edtCantidad);
            int cantidad = Integer.parseInt(txtCantidad.getText().toString());

            subtotal= (precio+ recargo)*cantidad;

            CheckBox chkIgv = (CheckBox) findViewById(R.id.chkIgv);
            if(chkIgv.isChecked())
            {
                igv = precio *0.18;
            }
            total+=subtotal+igv;

            String msg = "Ventas de boletos\nPrecio: "+precio+"\nRecargo: "+recargo+"\nSubtotal: "+subtotal+"\nTotal: "+total;

            Toast.makeText(this,msg, Toast.LENGTH_LONG).show();

        }
    }
}
