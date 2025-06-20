package org.bedu.clientes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    @ManyToOne
    @JoinColumn(name = "marca_id")

    private Marca marca;

    public Producto(){}

    public Producto(String nombre, Marca marca){
        this.nombre = nombre;
        this.marca = marca;
    }

    public Long getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public Marca getMarca(){
        return marca;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setMarca(Marca marca){
        this.marca = marca;
    }
}
