package org.pizzabackend.pizzabackend.servicio;

import org.pizzabackend.pizzabackend.modelo.Pizza;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IPizzaService {

    Optional<Pizza> consultarPorId(String nombre);
    boolean existePorId(String nombre);
    Set<Pizza> consultarTodas();

    // Inserción
    Optional<Pizza> registrar(Pizza nueva);

    // Actualización
    Optional<Pizza> actualizar(Pizza nueva);

    // Borrado
    boolean borrarPorId(String nombre);

}
