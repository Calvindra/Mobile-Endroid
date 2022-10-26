package com.example.endroid;

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
        Button bKontak= (Button) findViewById(R.id.bOpen);
        Button bGambar= (Button) findViewById(R.id.bGambar);
        Button bMusik= (Button) findViewById(R.id.bMusik);
        Button bKesehatan= (Button) findViewById(R.id.bKesehatan);
        bKontak.setOnClickListener(operasi);
        bGambar.setOnClickListener(operasi);
        bMusik.setOnClickListener(operasi);
        bKesehatan.setOnClickListener(operasi);

    }

    View.OnClickListener operasi = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            switch (view.getId()){
                case R.id.bOpen:bukaKontak();break;
                case R.id.bMusik:bukaKalkulator();break;
                case R.id.bGambar:bukaBiodata();break;
                case R.id.bKesehatan:bukaKesehatan();break;
            }



        }
    };


    void bukaKontak(){
        Intent intentku = new Intent(getBaseContext(), kontak.class);
        startActivityForResult(intentku, 0);
    }

    void bukaKalkulator(){
        Intent intentku = new Intent(getBaseContext(), kalkulator.class);
        startActivityForResult(intentku, 0);
    }

    void bukaBiodata(){
        Intent intentku = new Intent(getBaseContext(), biodata.class);
        startActivityForResult(intentku, 0);
    }

    void bukaKesehatan(){
        Intent intentku = new Intent(getBaseContext(), PencatatKesehatan.class);
        startActivityForResult(intentku, 0);
    }
}