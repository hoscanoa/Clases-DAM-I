package com.hoscanoa.developer.daos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hoscanoa.developer.beans.Alumno;
import com.hoscanoa.developer.beans.Profesor;
import com.hoscanoa.developer.conexion.DbHelper;

import java.util.ArrayList;

/**
 * Created by Hernan on 15/06/2015.
 */
public class ProfesorDAO {
    private Context context;

    public ProfesorDAO(Context context)
    {
        this.context=context;
    }

    public ArrayList<Profesor> listar() {
        ArrayList<Profesor> lista = new ArrayList<>();
        try {
            DbHelper helper = new DbHelper(context);
            SQLiteDatabase database = helper.getReadableDatabase();
            Cursor q = database.rawQuery("SELECT * FROM PROFESORES",null);
            Profesor obj;
            while (q.moveToNext())
            {
                obj = new Profesor();
                obj.setProfesorId(q.getInt(0));
                obj.setNombres(q.getString(1));
                obj.setApellidoPaterno(q.getString(2));
                obj.setApellidoMaterno(q.getString(3));
                lista.add(obj);
            }
            q.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

}
