package org.pizzabackend.pizzabackend.servicio;

import org.pizzabackend.pizzabackend.modelo.Ingrediente;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IIngredienteService {

    // Consulta
    Optional<Ingrediente> consultarPorId(String nombre);
    boolean existePorId(String nombre);
    Set<Ingrediente> consultarTodos();

    // Inserción
    Optional<Ingrediente> registrar(Ingrediente nuevo);

    // Actualización
    Optional<Ingrediente> actualizar(Ingrediente nuevo);

    // Borrado
    boolean borrarPorId(String nombre);

}
