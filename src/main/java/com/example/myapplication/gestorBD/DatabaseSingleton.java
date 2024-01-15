package com.example.myapplication.gestorBD;

import android.content.Context;

public class DatabaseSingleton {
    private static DatabaseSingleton instance;
    private DataBase dbHelper;

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
}
