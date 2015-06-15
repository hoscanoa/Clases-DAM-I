package com.hoscanoa.developer.solucionec2.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hoscanoa.developer.solucionec2.R;

/**
 * Created by Hernan on 11/05/2015.
 */
public class MiConexion extends SQLiteOpenHelper {

    public MiConexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context,"BDA",factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE JUGADOR(nombre TEXT, fechaNacimiento TEXT, edad INTEGER, numeroCamiseta INTEGER, posicion TEXT, observacion TEXT, foto INTEGER, bandera INTEGER);");
        db.execSQL("INSERT INTO JUGADOR VALUES(?,?,?,?,?,?,?,?)",new Object[]{"Pele","23/10/1940",72,10,"Delantero", "Es el mejor jugador de Bazil", R.drawable.pele, R.drawable.brazil});
        db.execSQL("INSERT INTO JUGADOR VALUES(?,?,?,?,?,?,?,?)",new Object[]{"Franz Beckenbauer","11/11/1945",67,10,"Delantero", "Es el mejor jugador de Alemania", R.drawable.beckenbauer, R.drawable.germany});
        db.execSQL("INSERT INTO JUGADOR VALUES(?,?,?,?,?,?,?,?)",new Object[]{"Michel Platini","21/06/1955",57,11,"Volante","Es el mejor jugador de Francia", R.drawable.platini, R.drawable.france});

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
