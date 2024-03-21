package org.pizzabackend.pizzabackend.servicio;

import org.pizzabackend.pizzabackend.modelo.Compra;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface ICompraService {

    // Consulta
    Optional<Compra> consultarPorId(Long id);
    boolean existePorId(Long id);
    Set<Compra> consultarTodas();

    // Inserción
    Optional<Compra> registrar(Compra nueva);

    // Actualización
    Optional<Compra> actualizar(Compra nueva);

    // Borrado
    boolean borrarPorId(Long id);

}
