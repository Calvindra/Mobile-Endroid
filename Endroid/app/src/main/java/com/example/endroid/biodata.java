package com.example.endroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;

public class biodata extends AppCompatActivity {

        private EditText nrp,nama;
        private Button simpan,ambildata;
        private SQLiteDatabase dbku;
        private SQLiteOpenHelper Opendb;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_biodata);

            nrp=(EditText)findViewById(R.id.nrp);
            nama=(EditText)findViewById(R.id.nama);
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
            dbku.execSQL("create table if not exists mhs(nrp TEXT, nama TEXT);");
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
                    case R.id.simpan:simpan();
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

        private void simpan()
        {
            ContentValues dataku=new ContentValues();
            dataku.put("nrp",nrp.getText().toString());
            dataku.put("nama",nama.getText().toString());
            dbku.insert("mhs",null,dataku);
            Toast.makeText(this,"Data Tersimpan",Toast.LENGTH_LONG).show();
        }

        private void ambildata()
        {
            Cursor cur=dbku.rawQuery("select * from mhs where nrp='" + nrp.getText().toString()+ "'",null);
            if(cur.getCount()>0)
            {
                Toast.makeText(this,"Data Ditemukan Sejumlah " + cur.getCount(),Toast.LENGTH_LONG).show();
                cur.moveToFirst();
                nama.setText(cur.getString(cur.getColumnIndex("nama")));
            }
            else
                Toast.makeText(this,"Data Tidak Ditemukan",Toast.LENGTH_LONG).show();
        }
    }