package org.pizzabackend.pizzabackend.repositorio;

import org.pizzabackend.pizzabackend.modelo.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPizzaRepository extends CrudRepository<Pizza, String> {

}
