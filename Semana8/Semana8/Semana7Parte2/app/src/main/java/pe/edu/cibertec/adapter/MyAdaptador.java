package pe.edu.cibertec.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cibertec.semana7parte2.R;

import java.util.ArrayList;

import pe.edu.cibertec.beans.Docente;

/**
 * Created by Cibertec on 05/05/2015.
 */
public class MyAdaptador extends BaseAdapter{

    Activity actividad;
    ArrayList<Docente> docentes;

    public MyAdaptador(Activity a, ArrayList<Docente> lista){
        super();
        actividad=a;
        docentes=lista;
    }

    @Override
    public int getCount() {
        return docentes.size();
    }

    @Override
    public Object getItem(int position) {
        return docentes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;

        if(v==null)
        {
            LayoutInflater inflater = (LayoutInflater)actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.layoutdocente,null);
        }

        Docente obj = docentes.get(position);

        try {
            ImageView imv = (ImageView)v.findViewById(R.id.imgFoto);
            int foto = 0;

            foto = actividad.getResources().getIdentifier("drawable/"+obj.getDocenteNombre().toLowerCase(),null,actividad.getPackageName());

            imv.setImageResource(foto);
        }
        catch (Exception e)
        {

        }


        TextView txt;
        txt=(TextView)v.findViewById(R.id.txtNombre);
        txt.setText(obj.getDocenteNombre());

        txt=(TextView)v.findViewById(R.id.txtEmail);
        txt.setText(obj.getDocenteEmail());

        txt=(TextView)v.findViewById(R.id.txtTelefono);
        txt.setText(obj.getDocenteTelefono());


        return v;
    }
}
