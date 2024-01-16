package com.example.myapplication.gestorBD;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class BackgroundTask extends AsyncTask<Void,Void,Void> {
    private DataBase db;
    private String url;
    private Context context;

    public BackgroundTask(DataBase db, String url, Context context) {
        this.db = db;
        this.url = url;
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        PeticionHTTP httpHandler = new PeticionHTTP(db, url);
        httpHandler.getPost();
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Toast.makeText(context, "Datos cargados", Toast.LENGTH_SHORT).show();
        cancel(true);
    }
}
