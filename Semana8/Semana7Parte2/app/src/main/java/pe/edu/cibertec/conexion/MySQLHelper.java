package pe.edu.cibertec.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cibertec on 28/04/2015.
 */
public class MySQLHelper extends SQLiteOpenHelper{

    public MySQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "BDCibertec", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DOCENTE(docenteId TEXT, docenteNombre TEXT, docenteEmail TEXT, docenteTelefono TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
