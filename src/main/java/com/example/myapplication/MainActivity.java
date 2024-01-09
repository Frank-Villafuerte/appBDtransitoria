package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}