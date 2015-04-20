package com.example.cibertec.semana3parte2;

import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    Spinner spnTiempo , spnMaravilla;
    CheckBox chkHistoria;
    TextView txtHistoria;

    int imagenes[]=null;
    String historias[]=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnTiempo = (Spinner) findViewById(R.id.spnTiempo);

        ArrayAdapter<String> myAdatper = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new String[]{"Maravillas Antiguas","Maravillas Modernas"});
        spnTiempo.setAdapter(myAdatper);
        spnTiempo.setOnItemSelectedListener(this);

        spnMaravilla = (Spinner) findViewById(R.id.spnMaravilla);
        spnMaravilla.setOnItemSelectedListener(this);

        chkHistoria=(CheckBox)findViewById(R.id.chkHistoria);
        chkHistoria.setOnCheckedChangeListener(this);

        txtHistoria = (TextView) findViewById(R.id.txtHistoria);

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

        if(parent==spnTiempo)
        {
            ArrayAdapter<String> myAdapter = null;
            switch (position)
            {
                case 0:
                    myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new String[]{"Templo de Artemisa","Coloso de Rodas", "Faro de Alejandría", "Jardines Colgantes de Babilonia", "Mausoleo de Alicarnaso", "Estátua de Zeus", "Las Pirámides de Egipto"});
                    spnMaravilla.setAdapter(myAdapter);
                    imagenes= new int[]{R.drawable.artemisa_a,R.drawable.coloso_a,R.drawable.alejandria_a,R.drawable.babilonia_a,R.drawable.mausoleo_a,R.drawable.zeus_a,R.drawable.piramides_a};
                    historias= new String[]{"En la ciudad de Efeso, a orillas del mar Jónico y junto a la desembocadura del pequeño Meandro. Seguimos a mediados del siglo VI AC. Ésta ciudad ha sido desde siempre un centro de culto a la diosa Artemisa, llamada después Diana por los romanos. Se trata de la soberana de la naturaleza selvática y de los animales salvajes, y suele representársela acompañada por una cierva y armada de arco y flechas. Desde muy antiguo, existe un templo dedicado a la diosa. Pero en el siglo VII a. de C., la ciudad sufrió el ataque de los sumerios y aunque se resistió, no se pudo evitar que el templo se incendiara y fuera destruido.",
                            "Sin viajar apenas en el tiempo (apenas unos tres años hacia delante, hasta el 277 a. de C.) vamos a presenciar la construcción de la última de las maravillas. Para ello abandonaremos el Asia Menor y nos internaremos en el mar Egeo. Allí, apenas a 18 kilómetros de la costa, encontraremos la más importante de las islas Espóradas: Rodas. Es importante porque su ciudad, del mismo nombre, es la capital del Dodecaneso, archipiélago compuesto por una veintena de islas. La situación geográfica de Rodas es privilegiada para comerciar con Grecia, el Asia Menor e incluso Egipto, y gracias a eso se ha convertido en el centro comercial más importante del Mediterráneo Oriental.",
                            "pequeña isla de Faros, frente al puerto. \n" +
                                    "\n" +
                                    "El arquitecto Sostrato de Cnido dirige las obras, que conforme avanzan, adquieren un aspecto más impresionante. Cuando se finaliza, la torre mide más de 120 metros. En su cima está equipada con espejos metálicos para señalar su posición reflejando la luz del sol; y por las noches, a falta de luz, se enciende una hoguera. \n",
                            "Estamos a mediados del siglo VI a. de C., y gobierna el rey Nabucodonosor II, el más famoso de todos los del mismo nombre. Además de un gran guerrero y conquistador, Nabucodonosor es también un gran arquitecto: la ciudad rebosa de construcciones monumentales. Sin embargo, algo se echa de menos en esta majestuosa ciudad: todo es demasiado llano, demasiado rectilíneo. Si subimos lo suficientemente alto, veremos toda la ciudad de un vistazo. ",
                            "Estamos en Halicarnaso, en la Caria, un estado del Asia Menor. Se trata de una ciudad importante; incluso cuenta con una fábrica de esos extraños discos de metal inventados por Creso que hacen las veces de moneda.",
                            "Estamos en el 450 a. de C., y se está terminado de construir el impresionante templo de Zeus, para el que no se escatiman medios: los mejores escultores de Grecia trabajan en él. Los dos frontones representan los preparativos de la competición atlética de Pelópe y Enomao para obtener la mano de Hipodamia, y la lucha entre lapitas y centauros en la boda de Piritoo. Estos frontones, junto con las metopas, serán considerados no sólo el más importante conjunto escultórico del estilo severo, sino las más notables series escultóricas del arte clásico griego junto con el Partenón.\n" +
                                    " Su autor, de quien no se sabrá el nombre, será conocido como el Maestro de Olimpia. ",
                            "La más antigua de las maravillas, y, curiosamente, la única que ha llegado hasta nosotros, es el monumental conjunto de las pirámides de Gizeh, en Egipto. Todos hemos oído hablar de ellas y conocemos su aspecto, así como sabemos que eran las tumbas de los faraones. Pero acerquémonos más, y averigüemos algunos detalles interesantes."};
                    break;
                default:
                    myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new String[]{"Gran Pirámide de Guiza","Chichén Itzá", "El Coliseo Romano", "La estatua Cristo Redentor", "La Gran Muralla China", "Machu Picchu", "Petra", "Taj Majal"});
                    spnMaravilla.setAdapter(myAdapter);
                    imagenes= new int[]{R.drawable.piramide,R.drawable.chichenitza,R.drawable.coliseo,R.drawable.cristo,R.drawable.muralla,R.drawable.machupicchu,R.drawable.petra,R.drawable.tajmajal};
                    historias= new String[]{"La Gran pirámide de Guiza es la más antigua de las Siete maravillas del mundo y la única que aún perdura, además de ser la mayor de las pirámides de Egipto. Fue ordenada construir por el faraón de la cuarta dinastía del Antiguo Egipto Keops. El arquitecto de dicha obra fue Hemiunu.",
                            "Chichén Itzá (en maya: (Chichén) Boca del pozo; de los (Itzá) brujos de agua )?1 es uno de los principales sitios arqueológicos de la península de Yucatán, en México, ubicado en el municipio de Tinum, en el estado de Yucatán.",
                            "El Coliseo (en latín: Amphitheatrum Flavium Romae) es un anfiteatro de la época del Imperio romano, construido en el siglo I y ubicado en el centro de la ciudad de Roma. Originalmente era denominado Anfiteatro Flavio (Amphitheatrum Flavium), en honor a la Dinastía Flavia de emperadores que lo construyó, y pasó a llamarse Colosseum por una gran estatua que había cerca, el Coloso de Nerón, que no ha llegado hasta nosotros. ",
                            "El Cristo Redentor o Cristo de Corcovado es una estatua de 38 metros, con el pedestal de 8 metros, de Jesús de Nazaret con los brazos abiertos mostrando a la ciudad de Río de Janeiro, en Brasil.",
                            "En China, 10 000 li representan el \"infinito\") es una antigua fortificación china construida y reconstruida entre el siglo V a. C. y el siglo XVI (Edad Moderna) para proteger la frontera norte del Imperio chino durante las sucesivas dinastías imperiales de los ataques de los nómadas xiongnu de Mongolia y Manchuria.",
                            "Machu Picchu (del quechua sureño machu pikchu, «Montaña Vieja») es el nombre contemporáneo que se da a una llaqta —antiguo poblado andino— incaica construida a mediados del siglo XV en el promontorio rocoso que une las montañas Machu Picchu y Huayna Picchu en la vertiente oriental de la cordillera Central, al sur del Perú y a 2490 msnm, altitud de su plaza principal. Su nombre original habría sido Picchu o Picho",
                            "Es un importante enclave arqueológico en Jordania, y la capital del antiguo reino nabateo. El nombre de Petra proviene del griego πέτρα que significa piedra, y su nombre es perfectamente idóneo; no se trata de una ciudad construida con piedra sino, literalmente, excavada y esculpida en la piedra.",
                            "El imponente conjunto se erigió en honor de su esposa favorita, Arjumand Bano Begum —más conocida como Mumtaz Mahal— que murió en el parto de su decimocuarta hija. Se estima que su construcción necesitó el esfuerzo de unos 20.000 obreros."};
                    break;
            }
        }

        if(parent==spnMaravilla)
        {
            ImageView imgMaravilla = (ImageView)findViewById(R.id.imgMaravilla);
            imgMaravilla.setImageResource(imagenes[position]);


            txtHistoria.setMovementMethod(new ScrollingMovementMethod());
            if(chkHistoria.isChecked()) {
                txtHistoria.setText(historias[position]);
            }
            else
            {
                txtHistoria.setText("");
            }
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        txtHistoria.setMovementMethod(new ScrollingMovementMethod());
        if(chkHistoria.isChecked()) {
            txtHistoria.setText(historias[spnMaravilla.getSelectedItemPosition()]);
        }
        else
        {
            txtHistoria.setText("");
        }
    }
}
