package org.pizzabackend.pizzabackend.servicio;

import org.pizzabackend.pizzabackend.modelo.Compra;
import org.pizzabackend.pizzabackend.repositorio.IClienteRepository;
import org.pizzabackend.pizzabackend.repositorio.ICompraRepository;
import org.pizzabackend.pizzabackend.repositorio.IPizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CompraServiceImpl implements ICompraService {

    @Autowired
    ICompraRepository compraRepository;

    @Autowired
    IClienteRepository clienteRepository;

    @Autowired
    IPizzaRepository pizzaRepository;

    @Override
    public Optional<Compra> consultarPorId(Long id) {
        return compraRepository.findById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return compraRepository.existsById(id);
    }

    @Override
    public Set<Compra> consultarTodas() {
        return StreamSupport.stream(compraRepository.findAll().spliterator(), false)
            .collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public Optional<Compra> registrar(Compra nueva) {
        nueva.setFecha(LocalDate.now());

        if (nueva.getCliente() != null &&
                !clienteRepository.existsById(nueva.getCliente().getDni()))
        {
            throw new RuntimeException("El cliente no existe");
        }

        nueva.getPizzas().forEach(pizza -> {
                    if (!pizzaRepository.existsById(pizza.getNombre()))  {
                        throw new RuntimeException(String.format("Pizza %s no existe", pizza.getNombre()));
                    }
        });

        return Optional.of(compraRepository.save(nueva));
    }

    @Override
    public Optional<Compra> actualizar(Compra nueva) {
        return Optional.of(compraRepository.save(nueva));
    }

    @Override
    public boolean borrarPorId(Long id) {
        compraRepository.existsById(id);
        return existePorId(id);
    }
}
