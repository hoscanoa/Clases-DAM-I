package com.example.cibertec.semana3parte1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;


public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner spnPais, spnCiudad;

    int[] imagenes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnPais = (Spinner)findViewById(R.id.spnPais);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, new String[]{"PERÙ","MÈXICO","BRASIL"});
        spnPais.setAdapter(myAdapter);
        spnPais.setOnItemSelectedListener(this);

        spnCiudad = (Spinner)findViewById(R.id.spnCiudad);
        spnCiudad.setOnItemSelectedListener(this);
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
       if(parent==spnCiudad)
       {
           ImageView img = (ImageView)findViewById(R.id.imgCiudad);
            img.setImageResource(imagenes[position]);

       }

        if(parent==spnPais)
        {
            String[] ciudades = null;
            switch (position)
            {
                case 0:
                    ciudades=new String[]{"TUMBES", "CUZCO", "LIMA"};
                    imagenes = new int[]{R.drawable.tumbes, R.drawable.cuzco, R.drawable.lima};
                    break;
                case 1:
                    ciudades=new String[]{"CANCUN", "ACAPULCO"};
                    imagenes = new int[]{R.drawable.cancun, R.drawable.acapulco};
                    break;
                default:
                    ciudades=new String[]{"RIO DE JANEIRO", "SAO PAULO", "BRASILIA"};
                    imagenes = new int[]{R.drawable.rio, R.drawable.sao, R.drawable.brasilia};
                    break;
            }
            ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,ciudades);
            spnCiudad.setAdapter(myAdapter);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
