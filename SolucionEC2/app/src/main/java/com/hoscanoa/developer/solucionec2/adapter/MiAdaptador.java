package com.hoscanoa.developer.solucionec2.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hoscanoa.developer.solucionec2.R;
import com.hoscanoa.developer.solucionec2.beans.Jugador;

import java.util.ArrayList;

/**
 * Created by Hernan on 11/05/2015.
 */
public class MiAdaptador extends BaseAdapter {

    private Activity activity;
    private ArrayList<Jugador> lista;

    public MiAdaptador(Activity activity, ArrayList<Jugador> lista)
    {
        super();
        this.activity=activity;
        this.lista=lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
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
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.layoutjugadores, null);
        }

        Jugador obj = lista.get(position);

        TextView txt;

        ImageView imgFoto = (ImageView)v.findViewById(R.id.imgFoto);
        imgFoto.setImageResource(obj.getFoto());

        txt= (TextView)v.findViewById(R.id.txtNombre);
        txt.setText(obj.getNombre());

        txt= (TextView)v.findViewById(R.id.txtFechaNacimiento);
        txt.setText(obj.getFechaNacimiento() + " (age " +obj.getEdad()+")");

        ImageView imgBandera = (ImageView)v.findViewById(R.id.imgBandera);
        imgBandera.setImageResource(obj.getBandera());

        return v;
    }
}
