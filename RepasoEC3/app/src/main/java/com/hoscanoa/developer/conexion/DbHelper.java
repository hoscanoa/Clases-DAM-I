package com.hoscanoa.developer.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hernan on 15/06/2015.
 */
public class DbHelper extends SQLiteOpenHelper {

    public  DbHelper(Context context)
    {
        super(context,"repaso.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PRAGMA);
        db.execSQL(CREATE_ALUMNOS);
        db.execSQL(CREATE_CURSOS);
        db.execSQL(CREATE_PROFESORES);
        db.execSQL(CREATE_ALUMNOS_CURSOS);
        db.execSQL(CREATE_CARGA_DOCENTE);

            db.execSQL(INSERT_ALUMNOS);
            db.execSQL(INSERT_CURSOS);
            db.execSQL(INSERT_PROFESORES);
            db.execSQL(INSERT_ALUMNOS_CURSOS);
            db.execSQL(INSERT_CARGA_DOCENTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    private static final String CREATE_PRAGMA = "PRAGMA foreign_keys = ON;";

    private static final String CREATE_ALUMNOS = "CREATE TABLE ALUMNOS (alumnoId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , nombres VARCHAR(20) NOT NULL , apellidoPaterno VARCHAR(20) NOT NULL , apellidoMaterno VARCHAR(20) NOT NULL , fechaNacimiento DATETIME NOT NULL );";

    private static final String INSERT_ALUMNOS = "INSERT INTO ALUMNOS VALUES(1,'Catherine','Wallace','Fuller','21-12-1980'),\n" +
            "(2,'Jeffrey','Ward','Mcdonald','07-09-1988'),\n" +
            "(3,'Jessica','Hughes','Oliver','05-02-1986'),\n" +
            "(4,'Paula','Smith','Nichols','31-12-1986'),\n" +
            "(5,'Jane','Stephens','Hart','05-08-1984'),\n" +
            "(6,'Carolyn','Burton','Barnes','22-09-1988'),\n" +
            "(7,'Steve','Hamilton','Payne','05-04-1991'),\n" +
            "(8,'Lois','Nichols','Powell','02-01-1981'),\n" +
            "(9,'Arthur','Stewart','Richardson','20-02-1987'),\n" +
            "(10,'Kevin','Wright','Henderson','31-03-1984'),\n" +
            "(11,'Albert','Thomas','Davis','13-06-1992'),\n" +
            "(12,'Jane','Cole','Andrews','20-07-1984'),\n" +
            "(13,'Tina','Jenkins','Peters','24-05-1981'),\n" +
            "(14,'Carolyn','Hanson','Nichols','17-05-1984'),\n" +
            "(15,'Howard','Brooks','Sims','13-04-1981'),\n" +
            "(16,'Diane','Webb','Morrison','26-05-1983'),\n" +
            "(17,'Daniel','Black','Moreno','17-10-1995'),\n" +
            "(18,'Henry','Fox','Spencer','28-08-1983'),\n" +
            "(19,'Stephanie','Romero','Fernandez','16-04-1984'),\n" +
            "(20,'Mary','Clark','Diaz','06-03-1988');";

    private static final String CREATE_CURSOS = "CREATE TABLE CURSOS (cursoId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , descripcion VARCHAR(20) NOT NULL  UNIQUE , creditos INTEGER NOT NULL );";

        private static final String INSERT_CURSOS ="INSERT INTO CURSOS VALUES(1,'ALGORITMOS I',4),\n" +
            "(2,'LENGUAJE DE PROGRAMCIÓN I',3),\n" +
            "(3,'ESTRUCTURAS DE INFORMACIÓN',4),\n" +
            "(4,'MATEMÁTICA DISCRETA',5),\n" +
            "(5,'TÉCNICAS DE PROGRAMACIÓN',5);";

    private static final String CREATE_PROFESORES = "CREATE TABLE PROFESORES (profesorId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , nombres VARCHAR(20), apellidoPaterno VARCHAR(20), apellidoMaterno VARCHAR(20));";
        private static final String INSERT_PROFESORES ="INSERT INTO PROFESORES VALUES(1,'Jeffrey','Harris','Reynolds'),\n" +
            "(2,'Brandon','Moore','Hernandez'),\n" +
            "(3,'Joe','Price','Mendoza'),\n" +
            "(4,'James','Andrews','Medina'),\n" +
            "(5,'Patrick','Carter','Lewis');";


    private static final String CREATE_ALUMNOS_CURSOS = "CREATE TABLE ALUMNOS_CURSOS \n" +
            "(alumnoCursoId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , \n" +
            "alumnoId INTEGER  NOT NULL REFERENCES ALUMNOS(alumnoId) , \n" +
            "cursoId INTEGER NOT NULL REFERENCES CURSOS(cursoId) \n" +
            ");";

        private static final String INSERT_ALUMNOS_CURSOS ="INSERT INTO ALUMNOS_CURSOS VALUES(1,1,1),\n" +
            "(2,1,2),\n" +
            "(3,1,3),\n" +
            "(4,1,4),\n" +
            "(5,1,5),\n" +
            "(6,2,1),\n" +
            "(7,2,2),\n" +
            "(8,2,3),\n" +
            "(9,2,4),\n" +
            "(10,2,5),\n" +
            "(11,3,1),\n" +
            "(12,3,2),\n" +
            "(13,3,3),\n" +
            "(14,3,4),\n" +
            "(15,3,5),\n" +
            "(16,4,1),\n" +
            "(17,4,2),\n" +
            "(18,4,3),\n" +
            "(19,4,4),\n" +
            "(20,4,5),\n" +
            "(21,5,1),\n" +
            "(22,5,2),\n" +
            "(23,5,3),\n" +
            "(24,5,4),\n" +
            "(25,6,1),\n" +
            "(26,6,2),\n" +
            "(27,6,3),\n" +
            "(28,6,4),\n" +
            "(29,6,5),\n" +
            "(30,7,1),\n" +
            "(31,7,2),\n" +
            "(32,7,3),\n" +
            "(33,7,4),\n" +
            "(34,7,5),\n" +
            "(35,8,1),\n" +
            "(36,8,2),\n" +
            "(37,8,3),\n" +
            "(38,8,4),\n" +
            "(39,8,5),\n" +
            "(40,9,1),\n" +
            "(41,9,2),\n" +
            "(42,9,3),\n" +
            "(43,9,4),\n" +
            "(44,10,1),\n" +
            "(45,10,2),\n" +
            "(46,10,3),\n" +
            "(47,10,4),\n" +
            "(48,10,5),\n" +
            "(49,11,1),\n" +
            "(50,11,2),\n" +
            "(51,11,3),\n" +
            "(52,11,4),\n" +
            "(53,12,2),\n" +
            "(54,12,3),\n" +
            "(55,12,4),\n" +
            "(56,12,5),\n" +
            "(57,13,1),\n" +
            "(58,13,2),\n" +
            "(59,13,3),\n" +
            "(60,13,4),\n" +
            "(61,13,5),\n" +
            "(62,14,1),\n" +
            "(63,14,2),\n" +
            "(64,14,3),\n" +
            "(65,14,4),\n" +
            "(66,14,5),\n" +
            "(67,15,1),\n" +
            "(68,15,2),\n" +
            "(69,15,3),\n" +
            "(70,15,4),\n" +
            "(71,15,5),\n" +
            "(72,16,1),\n" +
            "(73,16,2),\n" +
            "(74,16,3),\n" +
            "(75,16,4),\n" +
            "(76,16,5),\n" +
            "(77,17,1),\n" +
            "(78,17,2),\n" +
            "(79,17,3),\n" +
            "(80,17,4),\n" +
            "(81,17,5),\n" +
            "(82,18,1),\n" +
            "(83,18,2),\n" +
            "(84,18,3),\n" +
            "(85,18,4),\n" +
            "(86,18,5),\n" +
            "(87,19,1),\n" +
            "(88,19,2),\n" +
            "(89,19,3),\n" +
            "(90,19,4),\n" +
            "(91,19,5),\n" +
            "(92,20,1),\n" +
            "(93,20,2),\n" +
            "(94,20,3),\n" +
            "(95,20,4),\n" +
            "(96,20,5);";

    private static final String CREATE_CARGA_DOCENTE ="CREATE TABLE CARGA_DOCENTE (cargaDocenteId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , profesorId INTEGER NOT NULL , cursoId INTEGER NOT NULL );";

        private static final String INSERT_CARGA_DOCENTE ="INSERT INTO CARGA_DOCENTE VALUES(1,1,1),\n" +
            "(2,1,2),\n" +
            "(3,1,3),\n" +
            "(4,2,2),\n" +
            "(5,2,3),\n" +
            "(6,2,4),\n" +
            "(7,2,5),\n" +
            "(8,3,2),\n" +
            "(9,3,4),\n" +
            "(10,3,5),\n" +
            "(11,4,1),\n" +
            "(12,4,4),\n" +
            "(13,4,5),\n" +
            "(14,5,1),\n" +
            "(15,5,2),\n" +
            "(16,5,3),\n" +
            "(17,5,4);";

    private static final String DROP_TABLES = "DROP TABLE IF EXISTS ALUMNOS_CURSOS;\n" +
            "DROP TABLE IF EXISTS CARGA_DOCENTE;\n" +
            "DROP TABLE IF EXISTS ALUMNOS;\n" +
            "DROP TABLE IF EXISTS CURSOS;\n" +
            "DROP TABLE IF EXISTS PROFESORES;";
}
