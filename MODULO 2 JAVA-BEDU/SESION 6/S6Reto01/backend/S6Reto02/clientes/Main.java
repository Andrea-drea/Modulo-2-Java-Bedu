package org.bedu.clientes;

import org.bedu.clientes.Marca;
import org.bedu.clientes.MarcaRepository;
import org.bedu.clientes.Producto;
import org.bedu.clientes.ProductoRepositoryReto2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Bean
    CommandLineRunner runner(MarcaRepository marcaRepo, ProductoRepositoryReto2 productoRepo){
        return args -> {
            Marca apple = new Marca("Apple");
            Marca samsung = new Marca("Samsung");

            marcaRepo.save(apple);
            marcaRepo.save(samsung);

            productoRepo.save(new Producto("Iphone 15", apple));
            productoRepo.save(new Producto("iPad Pro", apple));
            productoRepo.save(new Producto("Galaxy S23", samsung));
            productoRepo.save(new Producto("Smart TV", samsung));

            System.out.println("Productos por marca: ");
            marcaRepo.findAll().forEach(marca -> {
                System.out.println("Marca: " + marca.getNombre() + ": ");
                productoRepo.findAll().stream()
                        .filter(p -> p.getMarca().getId().equals(marca.getId()))
                        .forEach(p-> System.out.println("- " + p.getNombre()));
            });

        };
    }
}