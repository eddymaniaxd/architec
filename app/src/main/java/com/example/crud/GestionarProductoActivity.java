package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.crud.controladores.ProductoBD;

public class GestionarProductoActivity extends AppCompatActivity {

    Context context;
    EditText txtnombre,txtprecio,txtfecha;
    int id;
    ProductoBD productoBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar_producto);
        init();
    }
    private void init(){
        context =getApplicationContext();
        txtnombre =findViewById(R.id.g_txtnombre);
        txtprecio =findViewById(R.id.g_txtprecio);
        txtfecha =findViewById(R.id.g_txtfecha);

        Intent i =getIntent();
        Bundle bolsa = i.getExtras();
        id = bolsa.getInt("id");
        if(id!=0){
            txtnombre.setText(bolsa.getString("nombre"));
            txtprecio.setText(bolsa.getString("precio"));
            txtfecha.setText(bolsa.getString("fecha"));
        }
    }
}