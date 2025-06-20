package org.bedu.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
// Interfaz que extiende JpaRepository para realizar operaciones CRUD y consultas personalizadas
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Busca productos cuyo nombre contenga la cadena dada (sensible a mayúsculas/minúsculas)
    List<Producto> findByNombreContaining(String nombre);

    // Busca productos con precio mayor al valor dado
    List<Producto> findByPrecioGreaterThan(double precio);

    // Busca productos cuyo nombre contenga la cadena dada, sin importar mayúsculas o minúsculas
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    // Busca productos con precio dentro del rango [min, max]
    List<Producto> findByPrecioBetween(double min, double max);

    // Busca productos cuyo nombre comienza con el prefijo dado, sin importar mayúsculas o minúsculas
    List<Producto> findByNombreStartingWithIgnoreCase(String prefijo);
}