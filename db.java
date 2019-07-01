package com.example.mac12.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db = null;
    Button btn;
    EditText firstname,lastname;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("test",MODE_PRIVATE,null);

        db.execSQL("CREATE TABLE IF NOT EXISTS user(id INTEGER PRIMARY KEY AUTOINCREMENT, nom varchar(60) UNIQUE, prenom varchar(60) UNIQUE)");

        String nomU = "Landry";
        String prenom ="cooo";

        db.execSQL("INSERT INTO user(nom,prenom) VALUES('"+nomU+"','"+prenom+"')");

        Cursor cursor =db.rawQuery("SELECT * FROM user",null);
        cursor.moveToFirst();
         int nbEnreg =cursor.getCount();
        String ligne[][]= new String[nbEnreg][3];

            for (int i=0; i<nbEnreg; i++){
                ligne[i][0]=cursor.getString(0);
                ligne[i][1]=cursor.getString(1);
                ligne[i][2]=cursor.getString(2);

                Log.d("enreg", "\nid :"+ligne[i][0]+"\nnom :"+ligne[i][1]+"\nprenom"+ligne[i][2]);
                cursor.moveToNext();
            }


    }



}