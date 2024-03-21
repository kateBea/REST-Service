package org.pizzabackend.pizzabackend.servicio;

import org.pizzabackend.pizzabackend.modelo.Pizza;
import org.pizzabackend.pizzabackend.repositorio.IPizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PizzaServiceImpl implements IPizzaService {

    @Autowired
    IPizzaRepository pizzaRepository;

    @Override
    public Optional<Pizza> consultarPorId(String nombre) {
        return pizzaRepository.findById(nombre);
    }

    @Override
    public boolean existePorId(String nombre) {
        return pizzaRepository.existsById(nombre);
    }

    @Override
    public Set<Pizza> consultarTodas() {
        return StreamSupport.stream(pizzaRepository.findAll().spliterator(), false)
            .collect(Collectors.toSet());
    }

    @Override
    public Optional<Pizza> registrar(Pizza nueva) {
        // Comprobar que la pizza pedida existe con sus ingredientes
        // Si no existe comprobar que es una del tipo donde el usuario
        // puede elegir los ingredientes a gusto

        return Optional.of(pizzaRepository.save(nueva));
    }

    @Override
    public Optional<Pizza> actualizar(Pizza nueva) {
        return Optional.of(pizzaRepository.save(nueva));
    }

    @Override
    public boolean borrarPorId(String nombre) {
        pizzaRepository.deleteById(nombre);
        return existePorId(nombre);
    }
}
