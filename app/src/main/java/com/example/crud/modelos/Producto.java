package com.example.crud.modelos;

import androidx.annotation.NonNull;

public class Producto {

    // Atributos de la clase Producto
    private int id;
    private String nombre;
    private double precio ;
    private int fecha;

    //Constructor sin Argumentos
    public Producto(){

    }

    //Constructor Argumentos

    public Producto(int id, String nombre, double precio, int fecha) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    @NonNull
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", fecha=" + fecha +
                '}';
    }
}//PRODUCTO
