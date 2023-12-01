package com.shopall.demo.store.cliente;

import jakarta.persistence.*;


@Entity
@Table(name = "cliente")
public class Cliente {
    @Id //Estable el id como llave primaria
    @Column(name = "id_cliente") //Cambiamos el nombre de la columna a id_cliente
    
    @SequenceGenerator( //Generamos una secuencia para el id
        name = "cliente_sequence",
        sequenceName = "cliente_sequence",
        allocationSize = 1
    )

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, //AUTOINCREMENT
        generator = "cliente_sequence"
    )

    private Long id;
    private String nombre;

    @Column(name = "num_telefono")
    private int numTel;
    
    //Constructor vacio
    public Cliente() {
    
    }

    //Constructor con parametros (sin ID)
    public Cliente(String nombre, int num_telefono) {
        this.nombre = nombre;
        this.numTel = num_telefono;
    }

    //Constructor con parametros
    public Cliente(Long id, String nombre, int num_telefono) {
        this.id = id;
        this.nombre = nombre;
        this.numTel = num_telefono;
    }

    //Getters y Setters
    //Id
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Nombre
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Numero de telefono
    public int getNum_telefono() {
        return this.numTel;
    }

    public void setNum_telefono(int num_telefono) {
        this.numTel = num_telefono;
    }

}