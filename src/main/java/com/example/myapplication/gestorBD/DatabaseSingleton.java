package com.example.myapplication.gestorBD;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.clases.Empresa;
import com.example.myapplication.clases.MaeCliente;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSingleton {
    private static DatabaseSingleton instance;
    private DataBase dbHelper;
    private List<MaeCliente> listaMaeCliente=new ArrayList<MaeCliente>();

    private DatabaseSingleton(Context context) {
        dbHelper = new DataBase(context);
    }

    public static synchronized DatabaseSingleton getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseSingleton(context.getApplicationContext());
        }
        return instance;
    }

    public DataBase getDatabaseHelper() {
        return dbHelper;
    }
    public  List<MaeCliente> getListaMaeCliente(){
        return listaMaeCliente;
    }
    public void agregarDato(MaeCliente maeCliente){
        listaMaeCliente.add(maeCliente);
        //peticion http para post mae cliente
    }
    public void eliminarDato(MaeCliente maeCliente, int position){
        listaMaeCliente.get(position);  
        //peticion para delete
    }
    public void modificarDato(){

    }

    public void agregarDato(Empresa empresa1) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("codigo", empresa1.getCodigo());
        values.put("razon", empresa1.getRazon());
        values.put("ruc", empresa1.getRuc());
        values.put("mail", empresa1.getMail());
        values.put("direccion", empresa1.getDireccion());
        values.put("telefono", empresa1.getTelefono());
        values.put("mision", empresa1.getMision());
        values.put("vision", empresa1.getVision());
        values.put("status", empresa1.getEstado());

        long resultado = db.insertWithOnConflict("empresas", null, values, SQLiteDatabase.CONFLICT_REPLACE);

        if (resultado == -1) {
            // Ocurrió un error al insertar el dato

        } else {
            // Éxito al agregar el dato
            Log.i("DatabaseSingleton", "Dato agregado correctamente a la base de datos");
        }

        db.close();
    }

}
