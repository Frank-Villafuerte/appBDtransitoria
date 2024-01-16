package com.example.myapplication.gestorBD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.clases.Empresa;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "books_database";
    private static final int DATABASE_VERSION = 1;
    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS empresas (codigo INTEGER PRIMARY KEY, razon TEXT,ruc INTEGER,mail TEXT, direccion TEXT, telefono INTEGER, mision TEXT, vision TEXT, status TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public List<Empresa> getAllEmpresas() {
        List<Empresa> empresaList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        // Consulta para seleccionar todos los libros
        Cursor cursor = db.rawQuery("SELECT * FROM empresas", null);


            while (cursor.moveToNext()) {
                int codigo = cursor.getInt(cursor.getColumnIndex("codigo"));
                String razon = cursor.getString(cursor.getColumnIndex("razon"));
                int ruc=cursor.getInt(cursor.getColumnIndex("ruc"));
                String direccion = cursor.getString(cursor.getColumnIndex("direccion"));
                String mail = cursor.getString(cursor.getColumnIndex("mail"));
                int telefono=cursor.getInt(cursor.getColumnIndex("telefono"));
                String estado = cursor.getString(cursor.getColumnIndex("status"));
                String mision = cursor.getString(cursor.getColumnIndex("mision"));
                String vision = cursor.getString(cursor.getColumnIndex("vision"));

                Empresa empresa = new Empresa(razon,ruc ,direccion ,mail,telefono,estado,mision,vision,codigo);
                empresaList.add(empresa);
            }



        // Cierra el cursor y la base de datos
        cursor.close();
        db.close();

        return empresaList;
    }
    public void insertEmpresas(List<Empresa> empresaList) {
        SQLiteDatabase db = getWritableDatabase();
        long result;

        try {
            db.beginTransaction();

            // Itera a través de la lista de libros y los inserta en la base de datos
            for (Empresa empresa : empresaList) {
                ContentValues values = new ContentValues();
                values.put("codigo", empresa.getCodigo());
                values.put("razon", empresa.getRazon());
                values.put("ruc", empresa.getRuc());
                values.put("mail", empresa.getMail());
                values.put("direccion", empresa.getDireccion());
                values.put("telefono", empresa.getTelefono());
                values.put("mision", empresa.getMision());
                values.put("vision", empresa.getVision());
                values.put("status", empresa.getEstado());
                db.insertWithOnConflict("empresas", null, values, SQLiteDatabase.CONFLICT_REPLACE);
            }

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

}
