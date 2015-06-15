package com.hoscanoa.developer.daos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hoscanoa.developer.beans.Alumno;
import com.hoscanoa.developer.conexion.DbHelper;

import java.util.ArrayList;

/**
 * Created by Hernan on 15/06/2015.
 */
public class AlumnoDAO {
    private Context context;

    public  AlumnoDAO (Context context)
    {
        this.context=context;
    }

    public ArrayList<Alumno> listar(int cursoId) {
        ArrayList<Alumno> lista = new ArrayList<>();
        try {
            DbHelper helper = new DbHelper(context);
            SQLiteDatabase database = helper.getReadableDatabase();
            Cursor q = database.rawQuery("SELECT A.* FROM ALUMNOS A INNER JOIN ALUMNOS_CURSOS AC ON A.alumnoId=AC.alumnoId WHERE AC.cursoId=?", new String[]{String.valueOf(cursoId)});
            Alumno obj;
            while (q.moveToNext())
            {
                obj = new Alumno();
                obj.setAlumnoId(q.getInt(0));
                obj.setNombres(q.getString(1));
                obj.setApellidoPaterno(q.getString(2));
                obj.setApellidoMaterno(q.getString(3));
                obj.setFechaNacimiento(q.getString(4));
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
