package pe.edu.cibertec.semana4parte1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends Activity {

    CheckBox chk;
    Context cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cnt=this;

        chk = (CheckBox)findViewById(R.id.checkBox);
        chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    RadioButton rbt1, rbt2, rbt3;
                    rbt1 = (RadioButton)findViewById(R.id.radioButton);
                    rbt2 = (RadioButton)findViewById(R.id.radioButton2);
                    rbt3 = (RadioButton)findViewById(R.id.radioButton3);

                    if(chk.isChecked()){
                        rbt1.setText("MILET FIGUEROA");
                        rbt2.setText("SHEYLA ROJAS");
                        rbt3.setText("BRUNELLA HORNA");
                    }
                    else{
                        rbt1.setText("TRACY FREUND");
                        rbt2.setText("PATTY WON");
                        rbt3.setText("KATHY CABALLERO");
                    }
            }
        });


        RadioGroup rd = (RadioGroup)findViewById(R.id.dgModelosgModelos);

        rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @override
            public void onCheckedChange(RadioGroup group, int checkedId)
            {
                String opcion="";
                switch (checkedId)
                {
                    case R.id.radioButton: opcion = "A"; break;
                    case R.id.radioButton2: opcion = "B"; break;
                    case R.id.radioButton3: opcion = "C"; break;
                }

                String tipo="";
                if(chk.isChecked()){
                    tipo="FACIL";
                }
                else {
                    tipo="DIFICIL";
                }

                Intent ir = new Intent(cnt, ResultadoActivity.class);
                ir.putExtra("opcionrec",opcion);
                ir.putExtra("tiporec",tipo);
                startActivity(ir);
            }

        });

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
