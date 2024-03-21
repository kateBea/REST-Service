package org.pizzabackend.pizzabackend.servicio;

import org.pizzabackend.pizzabackend.modelo.Cliente;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IClienteService {

    // Consulta
    Optional<Cliente> consultarPorId(String dni);
    boolean existePorId(String dni);
    Set<Cliente> consultarTodos();

    // Inserción

    /**
     * Registra un nuevo cliente en la base de datos, si el cliente
     * ya existía, se lanza una excepción de tipo RuntimeException.
     * @param nuevo Nuevo cliente a registrar.
     * @return Optional con el cliente como se ha registrado a la base de datos.
     * */
    Optional<Cliente> registrar(Cliente nuevo);

    // Actualización
    Optional<Cliente> actualizar(Cliente nuevo);

    // Borrado
    boolean borrarPorId(String dni);
}
