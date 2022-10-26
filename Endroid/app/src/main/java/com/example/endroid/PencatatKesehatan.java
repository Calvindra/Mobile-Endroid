package com.example.endroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataInput;

public class PencatatKesehatan extends AppCompatActivity {

    private EditText id,nama, nik, keluhan, alamat, diagnosa, dokter;
    private Button simpan,ambildata;
    private SQLiteDatabase dbku;
    private SQLiteOpenHelper Opendb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencatat_kesehatan);

        id=(EditText)findViewById(R.id.idPasien);
        nama=(EditText)findViewById(R.id.nama);
        nik=(EditText)findViewById(R.id.nik);
        keluhan=(EditText)findViewById(R.id.keluhan);
        alamat=(EditText)findViewById(R.id.alamat);
        diagnosa=(EditText)findViewById(R.id.diagnosa);
        dokter=(EditText)findViewById(R.id.dokter);
        simpan=(Button)findViewById(R.id.simpan);
        ambildata=(Button)findViewById(R.id.ambildata);
        simpan.setOnClickListener(operasi);
        ambildata.setOnClickListener(operasi);
        Button tutup = (Button) findViewById(R.id.bTutup);
        tutup.setOnClickListener(opclose);

        Opendb=new SQLiteOpenHelper(this, "db.sql",null,1)
        {
            @Override
            public void onCreate(SQLiteDatabase db)
            {
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
            {
            }
        };

        dbku=Opendb.getWritableDatabase();
        dbku.execSQL("create table if not exists pasienRS(id TEXT, nama TEXT, nik TEXT, alamat TEXT, keluhan TEXT, diagnosa TEXT, dokter TEXT);");
    }

    @Override
    protected void onStop()
    {
        dbku.close();
        Opendb.close();
        super.onStop();
    }

    View.OnClickListener operasi=new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.simpan:simpanAlert();
                    break;
                case R.id.ambildata:ambildata();
                    break;
            }
        }
    };

    View.OnClickListener opclose=new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.bTutup:finish();
                    break;
            }
        }
    };

    private void alert(String message){
        AlertDialog dialog = new AlertDialog.Builder(PencatatKesehatan.this)
                .setTitle("Pesan")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();
    }

    private void simpanAlert(){
        String NIK = nik.getText().toString();
        String NAMA = nama.getText().toString();
        String ID = id.getText().toString();
        String ALAMAT = alamat.getText().toString();
        String KELUHAN = keluhan.getText().toString();
        String DIAGNOSA = diagnosa.getText().toString();
        String DOKTER = dokter.getText().toString();
        if (NIK.equals("") || NAMA.equals("") || ID.equals("") || ALAMAT.equals("") || KELUHAN.equals("") || DIAGNOSA.equals("") || DOKTER.equals("") ){
            alert("Lengkapi Data Anda !!!");
        }else {
            validasi();
        }
    }

    private void validasi(){
        LayoutInflater li = LayoutInflater.from(this);
        View inputnya = li.inflate(R.layout.activity_alertbox,null);
        AlertDialog.Builder dialognya = new AlertDialog.Builder(this);
        dialognya.setView(inputnya);
        dialognya
                .setCancelable(false)
                .setPositiveButton("OK",oknya)
                .setNegativeButton("Batal", oknya);
        dialognya.show();
    }

    DialogInterface.OnClickListener oknya = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case -1 : simpan();
                    break;
                case -2 :
                    break;
            }
        }
    };

    private void simpan()
    {
        ContentValues dataku=new ContentValues();
        dataku.put("id",id.getText().toString());
        dataku.put("nama",nama.getText().toString());
        dataku.put("nik",nik.getText().toString());
        dataku.put("alamat",alamat.getText().toString());
        dataku.put("keluhan",keluhan.getText().toString());
        dataku.put("diagnosa",diagnosa.getText().toString());
        dataku.put("dokter",dokter.getText().toString());
        dbku.insert("pasienRS",null,dataku);
        Toast.makeText(this,"Data Tersimpan",Toast.LENGTH_LONG).show();
    }

    private void ambildata()
    {
        Cursor cur=dbku.rawQuery("select * from pasienRS where id='" + id.getText().toString()+ "'",null);
        if(cur.getCount()>0)
        {
            Toast.makeText(this,"Data Ditemukan Sejumlah " + cur.getCount(),Toast.LENGTH_LONG).show();
            cur.moveToFirst();
            nama.setText(cur.getString(cur.getColumnIndexOrThrow("nama")));
            nik.setText(cur.getString(cur.getColumnIndexOrThrow("nik")));
            alamat.setText(cur.getString(cur.getColumnIndexOrThrow("alamat")));
            keluhan.setText(cur.getString(cur.getColumnIndexOrThrow("keluhan")));
            diagnosa.setText(cur.getString(cur.getColumnIndexOrThrow("diagnosa")));
            dokter.setText(cur.getString(cur.getColumnIndexOrThrow("dokter")));
        }
        else
            Toast.makeText(this,"Data Tidak Ditemukan",Toast.LENGTH_LONG).show();
    }
}