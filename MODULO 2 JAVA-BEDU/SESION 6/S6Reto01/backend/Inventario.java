package org.bedu.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication //Marca esta clase como una aplicacion Spring Boot
public class Inventario {

    public static void main(String[] args) {
        SpringApplication.run(Inventario.class, args);
    }

    // Bean que se ejecuta justo después de iniciar la aplicación para correr lógica de prueba
    @Bean
    public CommandLineRunner demo(ProductoRepository repository) {
        return (args) -> {
            //Una entidad en jPA es una clase que se guarda como una fila en una tabla de base de datos
            repository.save(new Producto("Laptop", "Portátil de 16 pulgadas", 1200.00));
            repository.save(new Producto("Teclado mecánico", "Switch azul", 800.00));
            repository.save(new Producto("Mouse gamer", "Alta precisión", 600.00));

            repository.save(new Producto("Nintendo Switch 2", "Portátil y divertida", 14000.00));
            repository.save(new Producto("Mouse Logitech", "Mouse ergonómico con sensor óptico", 450.00));
            repository.save(new Producto("Monitor Samsung", "Monitor LED 24 pulgadas", 3200.00));
            repository.save(new Producto("MacBook Air", "Ultraligera con chip M1", 18000.00));


            // Imprime en consola todos los productos guardados
            System.out.println("📂 Productos disponibles:");
            repository.findAll().forEach(System.out::println);

            // Busca productos cuyo nombre contenga la cadena "Lap"
            System.out.println("\n🔍 Productos que contienen 'Lap':");
            repository.findByNombreContaining("Lap").forEach(System.out::println);

            // Reto 01: Filtra productos con precio mayor a 500
            System.out.println("\n Productos con precio > 500:");
            repository.findByPrecioGreaterThan(500.00).forEach(System.out::println);

            // Busca productos cuyo nombre contenga "lap" sin importar mayúsculas/minúsculas
            System.out.println("\n Productos que contienen 'lap':");
            repository.findByNombreContainingIgnoreCase("LAP").forEach(System.out::println);

            // Filtra productos cuyo precio está entre 400 y 1000
            System.out.println("\n Productos con un rango de precio entre 400 y 1000:");
            repository.findByPrecioBetween(400.00, 1000.00).forEach(System.out::println);

            // Busca productos cuyo nombre comience con la letra "m" o "M"
            System.out.println("\n Productos cuyo nombre comience con 'm' o 'M':");
            repository.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);
        };
    }
}