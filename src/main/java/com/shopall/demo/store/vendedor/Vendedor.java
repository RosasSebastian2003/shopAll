package com.shopall.demo.store.vendedor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.shopall.demo.store.cliente.Cliente;
import jakarta.persistence.FetchType; //Lazy fetch

@Entity
@Table(name = "vendedor")
public class Vendedor {

    @Id
    @Column(name = "id_vendedor")
    
    @SequenceGenerator( //Generamos una secuencia para el id
        name = "vendedor_sequence",
        sequenceName = "vendedor_sequence",
        allocationSize = 1
    )

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, //AUTOINCREMENT
        generator = "vendedor_sequence"
    )

    private Long id;
    private String nombre;
    private int numTel;
    private String zona;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Cliente cliente;

    //Constructor vacio 
    public Vendedor() {
    
    }

    //Constructor con parametros
    public Vendedor(Long id, String nombre, int num_telefono, String zona) {
        this.id = id;
        this.nombre = nombre;
        numTel = num_telefono;
        this.zona = zona;
    }

    //Constructor con parametros
    public Vendedor(String nombre, int num_telefono, String zona) {
        this.nombre = nombre;
        numTel = num_telefono;
        this.zona = zona;
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
        return numTel;
    }

    public void setNum_telefono(int num_telefono) {
        numTel = num_telefono;
    }

    //Zona
    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
    
    //Cliente
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


}
