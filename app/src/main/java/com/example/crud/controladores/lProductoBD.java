package com.example.crud.controladores;

import com.example.crud.modelos.Producto;

import java.util.List;

public interface lProductoBD {

    Producto elemento(int id);
    Producto elemento(String nombre);

    List<Producto>lista(); //devuelve la lista de todos los elementos

    void agregar (Producto producto);
    void actualizar (int id,Producto producto);

    void borrar (int id);

}
