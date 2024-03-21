package org.pizzabackend.pizzabackend.repositorio;

import org.pizzabackend.pizzabackend.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, String> {

}
