package org.pizzabackend.pizzabackend.servicio;

import org.pizzabackend.pizzabackend.modelo.Cliente;
import org.pizzabackend.pizzabackend.repositorio.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    IClienteRepository clienteRepository;

    @Override
    public Optional<Cliente> consultarPorId(String dni) {
        return clienteRepository.findById(dni);
    }

    @Override
    public boolean existePorId(String dni) {
        return clienteRepository.existsById(dni);
    }

    @Override
    public Set<Cliente> consultarTodos() {
        return StreamSupport.stream(clienteRepository.findAll().spliterator(), false)
            .collect(Collectors.toSet());
    }

    @Override
    public Optional<Cliente> registrar(Cliente nuevo) {
        nuevo.setFechaAlta(LocalDate.now());

        if (nuevo.getFechaAlta().isAfter(LocalDate.now())) {
            throw new RuntimeException("Fecha de nacimiento inválida");
        }

        return Optional.of(clienteRepository.save(nuevo));
    }

    @Override
    public Optional<Cliente> actualizar(Cliente nuevo) {

        if (nuevo.getFechaAlta().isAfter(LocalDate.now())) {
            throw new RuntimeException("Fecha de nacimiento inválida");
        }

        return Optional.of(clienteRepository.save(nuevo));
    }

    @Override
    public boolean borrarPorId(String dni) {
        clienteRepository.deleteById(dni);
        return existePorId(dni);
    }
}
