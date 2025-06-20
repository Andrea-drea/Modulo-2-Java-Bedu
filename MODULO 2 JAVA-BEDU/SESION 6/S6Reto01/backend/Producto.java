package org.bedu.backend;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

@Entity // Indica que esta clase es una entidad que se mapea a una tabla en la base de datos
public class Producto {
    @Id // Define el campo que será la clave primaria en la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El valor del ID se genera automáticamente (auto-incremental)
    private Long id;

    // Campos que serán columnas en la tabla 'producto'
    @NotBlank // Valida que el campo no esté vacío ni solo con espacios en blanco
    private String nombre;
    @NotBlank
    private String descripcion;
    @Min(1) // Valida que el valor mínimo permitido para precio sea 1
    private double precio;

    // Constructor sin parámetros requerido por JPA para crear instancias de la entidad
    protected Producto() {}

    // Constructor para crear objetos Producto con sus atributos
    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters para acceder a los atributos (necesarios para el funcionamiento de JPA y buenas prácticas)
    // Métodos getters para acceder a los atributos privados
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }

    // Sobrescribe el método toString para imprimir una representación legible del objeto Producto
    @Override
    public String toString() {
        return String.format("Producto[id=%d, nombre='%s', precio=%.2f]",
                id, nombre, precio);
    }
}