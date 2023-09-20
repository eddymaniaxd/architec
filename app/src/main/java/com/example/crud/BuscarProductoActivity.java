package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crud.controladores.ProductoBD;
import com.example.crud.modelos.Producto;


public class BuscarProductoActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;
    EditText txtnombre;
    Button btnbuscar;
    ProductoBD productoBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_producto2);
        init();
    }
    private void init(){
        context =getApplicationContext();
        txtnombre =findViewById(R.id.bus_txtnombre);
        btnbuscar = findViewById(R.id.bus_btnbuscar);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.bus_btnbuscar){
            String nombre = txtnombre.getText().toString();
            Producto producto =buscarProducto(nombre);
            if (producto != null){
                Bundle bolsa = new Bundle();
                bolsa.putInt("id",producto.getId());
                bolsa.putString("nombre",producto.getNombre());
                bolsa.putDouble("precio",producto.getPrecio());
                bolsa.putInt("fecha",producto.getFecha());

                Intent i = new Intent(context,GestionarProductoActivity.class);
                i.putExtras(bolsa);
                startActivity(i);
            }else {
                Toast.makeText(context,"No existe el producto con ese nombre",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    private Producto buscarProducto(String nombre) {
          productoBD = new ProductoBD(context,"ProductosBD.db",null,1);

        return productoBD.elemento(nombre);
    }
}