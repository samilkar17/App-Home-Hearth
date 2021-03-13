package com.e.parcial1_sebastian_amilkar_murillo_hurtado2151016.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseAnemia extends SQLiteOpenHelper {
    private Context context;
    private static  final  String DATABASE_NAME ="HemoHearthAnemia.db";
    private static  final  int DATABASE_VERSION = 1;


    private  static  final  String TABLE_NAME = "anemia";
    private static  final  String COLUMN_ID = "id";
    private static  final  String COLUMN_NOMBRE = "nombre";
    private static  final  String COLUMN_APELLIDO = "apellido";
    private static  final  String COLUMN_CORREO = "correo";
    private static  final  String COLUMN_HEMOGLOBINA = "hemoglobina";
    private static  final  String COLUMN_EDAD = "edad";
    private static  final  String COLUMN_TIEMPO = "tiempo";





    public DatabaseAnemia(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NOMBRE + " TEXT, " +
                        COLUMN_APELLIDO + " TEXT, " +
                        COLUMN_CORREO + " TEXT, " +
                        COLUMN_HEMOGLOBINA + " DOUBLE, " +
                        COLUMN_EDAD + " INTEGER, " +
                        COLUMN_TIEMPO + " TEXT);";



        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void añadirPaciente(String nombre, String apellido,String correo, double hemoglobina, int edad, String tiempo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NOMBRE, nombre);
        cv.put(COLUMN_APELLIDO, apellido);
        cv.put(COLUMN_CORREO, correo);
        cv.put(COLUMN_HEMOGLOBINA, hemoglobina);
        cv.put(COLUMN_EDAD, edad);
        cv.put(COLUMN_TIEMPO, tiempo);






        long resultado = db.insert(TABLE_NAME,null,cv);

        if(resultado == -1){
            Toast.makeText(context, "Error al insertar dato", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Paciente añadido", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor leerTodo(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db !=null){
            cursor = db.rawQuery(query,null);
        }
        return  cursor;
    }
}
