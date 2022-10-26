package com.example.endroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class kalkulator extends AppCompatActivity {

    EditText editTextLayar;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button buttonTambah, buttonKurang, buttonKali, buttonBagi;
    Button buttonClear, buttonEqual;


    public static double nilaiSekarang=0;
    public static String operasiSekarang="";
    public static double hasil=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);
        Button bTutup = (Button) findViewById(R.id.bTutup);
        bTutup.setOnClickListener(op);
        editTextLayar= (EditText) findViewById(R.id.editTextLayar);
        Button button0= (Button) findViewById(R.id.button0);
        button0.setOnClickListener(op);
        Button button1= (Button) findViewById(R.id.button1);
        button1.setOnClickListener(op);
        Button button2= (Button) findViewById(R.id.button2);
        button2.setOnClickListener(op);
        Button button3= (Button) findViewById(R.id.button3);
        button3.setOnClickListener(op);
        Button button4= (Button) findViewById(R.id.button4);
        button4.setOnClickListener(op);
        Button button5= (Button) findViewById(R.id.button5);
        button5.setOnClickListener(op);
        Button button6= (Button) findViewById(R.id.button6);
        button6.setOnClickListener(op);
        Button button7= (Button) findViewById(R.id.button7);
        button7.setOnClickListener(op);
        Button button8= (Button) findViewById(R.id.button8);
        button8.setOnClickListener(op);
        Button button9= (Button) findViewById(R.id.button9);
        button9.setOnClickListener(op);
        Button buttonTambah= (Button) findViewById(R.id.buttonTambah);
        buttonTambah.setOnClickListener(op);
        Button buttonKurang= (Button) findViewById(R.id.buttonKurang);
        buttonKurang.setOnClickListener(op);
        Button buttonKali= (Button) findViewById(R.id.buttonKali);
        buttonKali.setOnClickListener(op);
        Button buttonBagi= (Button) findViewById(R.id.buttonBagi);
        buttonBagi.setOnClickListener(op);
        Button buttonClear= (Button) findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(op);
        Button buttonEqual= (Button) findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(op);
    }

    View.OnClickListener op= new View.OnClickListener(){
        @Override
        public void onClick(View view){
            switch (view.getId()){
                case R.id.button0:
                    editTextLayar.setText(editTextLayar.getText().toString().trim() +"0");
                    break;
                case R.id.button1:
                    editTextLayar.setText(editTextLayar.getText().toString().trim() +"1");
                    break;
                case R.id.button2:
                    editTextLayar.setText(editTextLayar.getText().toString().trim() +"2");
                    break;
                case R.id.button3:
                    editTextLayar.setText(editTextLayar.getText().toString().trim() +"3");
                    break;
                case R.id.button4:
                    editTextLayar.setText(editTextLayar.getText().toString().trim() +"4");
                    break;
                case R.id.button5:
                    editTextLayar.setText(editTextLayar.getText().toString().trim() +"5");
                    break;
                case R.id.button6:
                    editTextLayar.setText(editTextLayar.getText().toString().trim() +"6");
                    break;
                case R.id.button7:
                    editTextLayar.setText(editTextLayar.getText().toString().trim() +"7");
                    break;
                case R.id.button8:
                    editTextLayar.setText(editTextLayar.getText().toString().trim() +"8");
                    break;
                case R.id.button9:
                    editTextLayar.setText(editTextLayar.getText().toString().trim() +"9");
                    break;
                case R.id.buttonTambah:
                    operasiSekarang= "tambah";
                    nilaiSekarang= Double.parseDouble(editTextLayar.getText().toString());
                    editTextLayar.setText("");
                    break;
                case R.id.buttonKurang:
                    operasiSekarang= "kurang";
                    nilaiSekarang= Double.parseDouble(editTextLayar.getText().toString());
                    editTextLayar.setText("");
                    break;
                case R.id.buttonKali:
                    operasiSekarang= "kali";
                    nilaiSekarang= Double.parseDouble(editTextLayar.getText().toString());
                    editTextLayar.setText("");
                    break;
                case R.id.buttonBagi:
                    operasiSekarang= "bagi";
                    nilaiSekarang= Double.parseDouble(editTextLayar.getText().toString());
                    editTextLayar.setText("");
                    break;
                case R.id.buttonClear:
                    editTextLayar.setText("");
                    break;
                case R.id.buttonEqual:
                    if(operasiSekarang.equals("tambah")){
                        hasil= nilaiSekarang+Double.parseDouble(editTextLayar.getText().toString().trim());
                    }
                    if(operasiSekarang.equals("kurang")){
                        hasil= nilaiSekarang-Double.parseDouble(editTextLayar.getText().toString().trim());
                    }
                    if(operasiSekarang.equals("kali")){
                        hasil= nilaiSekarang*Double.parseDouble(editTextLayar.getText().toString().trim());
                    }
                    if(operasiSekarang.equals("bagi")){
                        hasil= nilaiSekarang/Double.parseDouble(editTextLayar.getText().toString().trim());
                    }


                    int nilaiTemp= (int) hasil;

                    if (nilaiTemp==  hasil){
                        editTextLayar.setText(String.valueOf((int)hasil));
                    }
                    else{
                        editTextLayar.setText(String.valueOf(hasil));
                    }break;

                case R.id.bTutup:finish();break;
            }
        }
    };

//    void init(){
//
//        editTextLayar= (EditText) findViewById(R.id.editTextLayar);
//        button0= (Button) findViewById(R.id.button0);
//        button0.setOnClickListener((View.OnClickListener) this);
//        button1= (Button) findViewById(R.id.button1);
//        button1.setOnClickListener((View.OnClickListener) this);
//        button2= (Button) findViewById(R.id.button2);
//        button2.setOnClickListener((View.OnClickListener) this);
//        button3= (Button) findViewById(R.id.button3);
//        button3.setOnClickListener((View.OnClickListener) this);
//        button4= (Button) findViewById(R.id.button4);
//        button4.setOnClickListener((View.OnClickListener) this);
//        button5= (Button) findViewById(R.id.button5);
//        button5.setOnClickListener((View.OnClickListener) this);
//        button6= (Button) findViewById(R.id.button6);
//        button6.setOnClickListener((View.OnClickListener) this);
//        button7= (Button) findViewById(R.id.button7);
//        button7.setOnClickListener((View.OnClickListener) this);
//        button8= (Button) findViewById(R.id.button8);
//        button8.setOnClickListener((View.OnClickListener) this);
//        button9= (Button) findViewById(R.id.button9);
//        button9.setOnClickListener((View.OnClickListener) this);
//        buttonTambah= (Button) findViewById(R.id.buttonTambah);
//        buttonTambah.setOnClickListener((View.OnClickListener) this);
//        buttonKurang= (Button) findViewById(R.id.buttonKurang);
//        buttonKurang.setOnClickListener((View.OnClickListener) this);
//        buttonKali= (Button) findViewById(R.id.buttonKali);
//        buttonKali.setOnClickListener((View.OnClickListener) this);
//        buttonBagi= (Button) findViewById(R.id.buttonBagi);
//        buttonBagi.setOnClickListener((View.OnClickListener) this);
//        buttonClear= (Button) findViewById(R.id.buttonClear);
//        buttonClear.setOnClickListener((View.OnClickListener) this);
//    }


}