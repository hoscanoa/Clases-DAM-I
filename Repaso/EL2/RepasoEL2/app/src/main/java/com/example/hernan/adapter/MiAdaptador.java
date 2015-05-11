package com.example.hernan.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hernan.beans.Docente;
import com.example.hernan.repasoel2.R;

import java.util.ArrayList;

/**
 * Created by Hernan on 11/05/2015.
 */
public class MiAdaptador extends BaseAdapter {

    private Activity a;
    private ArrayList<Docente> lista;

    public MiAdaptador(Activity a, ArrayList<Docente> lista)
    {
        super();
        this.a=a;
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
            LayoutInflater inflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.layoutdocente, null);
        }

        Docente obj = lista.get(position);

        TextView txt;

        ImageView imv = (ImageView)v.findViewById(R.id.imgFoto);
        int foto=a.getResources().getIdentifier("drawable/"+obj.getDocenteNombre().toString().toLowerCase(),null,a.getPackageName());
        imv.setImageResource(foto);

        txt= (TextView)v.findViewById(R.id.txtNombre);
        txt.setText(obj.getDocenteNombre());

        txt= (TextView)v.findViewById(R.id.txtEmail);
        txt.setText(obj.getDocenteEmail());

        txt= (TextView)v.findViewById(R.id.txtTelefono);
        txt.setText(obj.getDocenteTelefono());

        return v;
    }
}
