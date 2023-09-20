package com.example.crud.controladores;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import androidx.annotation.Nullable;

import com.example.crud.modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoBD extends SQLiteOpenHelper implements lProductoBD {
    Context contexto;
    private final List<Producto> productosList = new ArrayList<>();


    public ProductoBD(@Nullable Context context,@Nullable String name ,
                      @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
        this.contexto=context;

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE Productos(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT,"+
                "precio REAL,"+
                "fecha INTEGER)";
        sqLiteDatabase.execSQL(sql);
        String insert ="INSERT INTO Productos VALUES(null," +
                "'Celular',"+
                "180,"+
                "2017)";
        sqLiteDatabase.execSQL(insert );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public Producto elemento(int id) {
        SQLiteDatabase database =getReadableDatabase();
        String sql ="SELECT * FROM productos WHERE _id=" + id;
        try (Cursor cursor = database.rawQuery(sql, null)) {
            if (cursor.moveToNext())
                return extraerProducto(cursor);
            else
                return null;
        } catch (Exception e) {
            Log.d("TAG", "Error elemento(id) ProductoBD" + e.getMessage());
            throw e;
        }
    }

    private Producto extraerProducto(Cursor cursor) {
        Producto producto = new Producto();
        producto.setId(cursor.getInt(0));
        producto.setNombre(cursor.getString(1));
        producto.setPrecio(cursor.getDouble(2));
        producto.setFecha(cursor.getInt(3));

        return producto;
    }


    @Override
    public Producto elemento(String nombre) {

        SQLiteDatabase database =getReadableDatabase();
        String sql ="SELECT * FROM productos WHERE nombre='" + nombre +"'";
        try (Cursor cursor = database.rawQuery(sql, null)) {
            if (cursor.moveToNext())
                return extraerProducto(cursor);
            else
                return null;
        } catch (Exception e) {
            Log.d("TAG", "Error elemento(nombre) ProductoBD" + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Producto> lista() {

      SQLiteDatabase database = getReadableDatabase();
      String sql ="SELECT* FROM productos ORDER BY titulo ASC";
      Cursor cursor = database.rawQuery(sql,null);
      if (cursor.moveToFirst()){
          do {
             productosList.add(
                     new Producto(cursor.getInt(0),
                             cursor.getString(1),
                             cursor.getDouble(2),
                             cursor.getInt(3))
             );
          }while (cursor.moveToNext());
      }
    cursor.close();
      return productosList;


    }

    @Override
    public void agregar(Producto producto) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre",producto.getNombre());
        values.put("precio",producto.getPrecio());
        values.put("fecha",producto.getFecha());
        database.insert("productos",null,values);
    }

    @Override
    public void actualizar(int id, Producto producto) {
        SQLiteDatabase database = getWritableDatabase();
        String[] parametros = {String.valueOf(id)};

        ContentValues values = new ContentValues();
        values.put("nombre",producto.getNombre());
        values.put("precio",producto.getPrecio());
        values.put("fecha",producto.getFecha());

        database.update("productos",values,"_id=?",parametros);
    }

    @Override
    public void borrar(int id) {
        SQLiteDatabase database = getWritableDatabase();
        String[] parametros = {String.valueOf(id)};

        database.delete("productos","_id?",parametros);

    }
}//ProductoBD
