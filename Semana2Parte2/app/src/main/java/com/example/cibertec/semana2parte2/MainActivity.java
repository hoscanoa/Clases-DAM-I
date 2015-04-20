package com.example.cibertec.semana2parte2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(ImageButton)findViewById(R.id.imgCalcular);
        btn.setOnClickListener(this);
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
        if(v==btn)
        {
            Spinner sp = (Spinner)findViewById(R.id.spnFlor);
            ImageView img = (ImageView)findViewById(R.id.imvFlor);
            String comentario="";
            RatingBar rb = (RatingBar)findViewById(R.id.rbValoracion);
            double p = rb.getRating();
            switch (sp.getSelectedItemPosition())
            {
                case 0:
                    comentario="Flor de varios pétalos";
                    img.setImageResource(R.drawable.c);
                    break;
                case 1:
                    comentario="Flor pequeña";
                    img.setImageResource(R.drawable.h);
                    break;
                default:
                    comentario="Flor de tallo largo";
                    img.setImageResource(R.drawable.t);
                    break;
            }
            comentario+=" le pongo "+p+" puntos";

            ToggleButton tg=(ToggleButton)findViewById(R.id.tgbComentario);
            if(tg.isChecked())
            {
                Toast.makeText(this,comentario,Toast.LENGTH_LONG).show();
            }
        }
    }
}
