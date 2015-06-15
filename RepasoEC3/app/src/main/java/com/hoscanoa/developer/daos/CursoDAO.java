package com.hoscanoa.developer.daos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hoscanoa.developer.beans.Curso;
import com.hoscanoa.developer.conexion.DbHelper;

import java.util.ArrayList;

/**
 * Created by Hernan on 15/06/2015.
 */
public class CursoDAO {

    private Context context;

    public CursoDAO(Context context)
    {
        this.context=context;
    }

    public ArrayList<Curso> listar(int profesorId) {
        ArrayList<Curso> lista = new ArrayList<>();
        try {
            DbHelper helper = new DbHelper(context);
            SQLiteDatabase database = helper.getReadableDatabase();
            Cursor q = database.rawQuery("SELECT C.* FROM CURSOS C INNER JOIN CARGA_DOCENTE CD ON C.cursoId=CD.cursoId WHERE CD.profesorId=?", new String[]{String.valueOf(profesorId)});
            Curso obj;
            while (q.moveToNext())
            {
                obj = new Curso();
                obj.setCursoId(q.getInt(0));
                obj.setDescripcion(q.getString(1));
                obj.setCreditos(q.getInt(2));
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
