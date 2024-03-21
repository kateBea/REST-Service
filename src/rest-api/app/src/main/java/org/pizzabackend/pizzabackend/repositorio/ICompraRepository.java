package org.pizzabackend.pizzabackend.repositorio;

import org.pizzabackend.pizzabackend.modelo.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraRepository extends CrudRepository<Compra, Long> {

}
