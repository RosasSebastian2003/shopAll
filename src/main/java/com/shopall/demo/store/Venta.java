package com.shopall.demo.store;

import java.sql.Timestamp;

public class Venta {
    private long id;
    private Timestamp fecha;
    private float precio;

    //Constructor vacio
    public Venta() {
    
    }

    //Constructor parametrado
    public Venta(long id, Timestamp fecha, float precio) {
        this.id = id;
        this.fecha = fecha;
        this.precio = precio;
    }

    //Getters y Setters
    //Id    
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //Fecha
    public Timestamp getFecha() {
        return this.fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    //Precio
    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
