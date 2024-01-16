package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.gestorBD.BackgroundTask;
import com.example.myapplication.gestorBD.DataBase;
import com.example.myapplication.gestorBD.DatabaseSingleton;

public class MainActivity extends AppCompatActivity {

    DatabaseSingleton databaseSingleton;
    DataBase dataBase;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseSingleton= DatabaseSingleton.getInstance(this);
        dataBase=databaseSingleton.getDatabaseHelper();
        url="http://134.122.125.35/";

        backgroundTask();
        Button botonIrAActividad2 = findViewById(R.id.iniciar);
        botonIrAActividad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crea un Intent para iniciar la Actividad2
                Intent intent = new Intent(MainActivity.this, ListaDatos.class);
                // Inicia la nueva actividad
                startActivity(intent);
            }
        });
    }
    private void backgroundTask(){
        BackgroundTask backgroundTask=new BackgroundTask(dataBase,url,this);
        backgroundTask.execute();
    }
}