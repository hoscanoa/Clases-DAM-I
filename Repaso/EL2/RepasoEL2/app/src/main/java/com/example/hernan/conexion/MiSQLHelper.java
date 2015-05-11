package com.example.hernan.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hernan on 10/05/2015.
 */
public class MiSQLHelper extends SQLiteOpenHelper {

    public MiSQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context,"BDCibertec",factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DOCENTE(docenteId TEXT, docenteNombre TEXT, docenteEmail TEXT, docenteTelefono TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
