package org.pizzabackend.pizzabackend.servicio;

import org.pizzabackend.pizzabackend.modelo.Ingrediente;
import org.pizzabackend.pizzabackend.repositorio.IIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class IngredienteServiceImpl implements IIngredienteService {

    @Autowired
    IIngredienteRepository ingredienteRepository;

    @Override
    public Optional<Ingrediente> consultarPorId(String nombre) {
        return ingredienteRepository.findById(nombre);
    }

    @Override
    public boolean existePorId(String nombre) {
        return ingredienteRepository.existsById(nombre);
    }

    @Override
    public Set<Ingrediente> consultarTodos() {
        return StreamSupport.stream(ingredienteRepository.findAll().spliterator(), false)
            .collect(Collectors.toSet());
    }

    @Override
    public Optional<Ingrediente> registrar(Ingrediente nuevo) {
        return Optional.of(ingredienteRepository.save(nuevo));
    }

    @Override
    public Optional<Ingrediente> actualizar(Ingrediente nuevo) {
        return Optional.of(ingredienteRepository.save(nuevo));
    }

    @Override
    public boolean borrarPorId(String nombre) {
        ingredienteRepository.deleteById(nombre);

        return existePorId(nombre);
    }
}
