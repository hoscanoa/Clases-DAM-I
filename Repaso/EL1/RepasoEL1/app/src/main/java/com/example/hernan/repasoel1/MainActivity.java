package com.example.hernan.repasoel1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    String categorias[] ={"Televisores","Audio"};
    String tvs[] ={"Monitor LED TV 23,6\" LT24D310LBSamsung", "LED 32\" 32LB561BLG", "LED 42\" 42LB7000LG", "LED 42\" L42Q530AKSDaewoo"};
    int imgTvs[]={R.drawable.tv13917000,R.drawable.tv13951268,R.drawable.tv14006853,R.drawable.tv14067374};

    String audios[]={"Mini MX-H630 230 W RMSSamsung", "Audífonos Supraurales SHP1900 NegroPhilips", "Audífono Vincha MDR-ZX100/B Tipo DiademaSony"};
    int imgAds[]={R.drawable.ad13032184,R.drawable.ad13607906,R.drawable.ad13948480};

    float starsTvs[]={4,5,2,1};
    float starsAudios[]={1,2,3};
    Spinner spnCategoria, spnProducto;
    ImageView imgProdcuto;
    RatingBar rbProducto;
    Button btnVerMas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnCategoria = (Spinner)findViewById(R.id.spnCategoria);
        spnCategoria.setOnItemSelectedListener(this);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,categorias);
        spnCategoria.setAdapter(myAdapter);

        spnProducto = (Spinner)findViewById(R.id.spnProducto);
        spnProducto.setOnItemSelectedListener(this);

        imgProdcuto = (ImageView)findViewById(R.id.imgProducto);

        rbProducto = (RatingBar)findViewById(R.id.rbProducto);

        btnVerMas = (Button)findViewById(R.id.btnVerMas);
        btnVerMas.setOnClickListener(this);

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
        if(v==btnVerMas)
        {
            Intent intent = new Intent(this, DetalleActivity.class);
            intent.putExtra("categoria", spnCategoria.getSelectedItemPosition());
            intent.putExtra("producto", spnProducto.getSelectedItemPosition());
            startActivity(intent);

        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent==spnCategoria)
        {
            ArrayAdapter<String> myAdapter;
            switch (position)
            {
                case 0:
                    myAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,tvs);
                    break;
                default:
                    myAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,audios);
                    break;
            }
            spnProducto.setAdapter(myAdapter);
        }

        if(parent==spnProducto)
        {

            switch (spnCategoria.getSelectedItemPosition()){
                case 0:
                    imgProdcuto.setImageResource(imgTvs[position]);
                    rbProducto.setRating(starsTvs[position]);
                    break;
                default:
                    imgProdcuto.setImageResource(imgAds[position]);
                    rbProducto.setRating(starsAudios[position]);
                    break;
            }


        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

