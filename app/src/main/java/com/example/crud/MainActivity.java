package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Context context;
    Button btnListar,btnRegistrar,btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        context = getApplicationContext();
        btnRegistrar = findViewById(R.id.btnregistrar);
        btnBuscar = findViewById(R.id.btnbuscar);
        btnListar = findViewById(R.id.btnlistar);

    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.btnregistrar) {
            Toast.makeText(context, "Registrar", Toast.LENGTH_LONG).show();
            Intent i =new Intent(context,GestionarProductoActivity.class);
            startActivity(i);
        } else if (viewId == R.id.btnlistar) {
            Toast.makeText(context, "Listar", Toast.LENGTH_LONG).show();
            Intent i2 =new Intent(context,ListadoProductoActivity.class);
            startActivity(i2);
        } else if (viewId == R.id.btnbuscar) {
            Toast.makeText(context, "Buscar", Toast.LENGTH_LONG).show();
            Intent i3 =new Intent(context, BuscarProductoActivity.class);
            startActivity(i3);
        }
    }

}