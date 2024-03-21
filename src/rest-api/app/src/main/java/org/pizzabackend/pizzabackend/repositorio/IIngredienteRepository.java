package org.pizzabackend.pizzabackend.repositorio;

import org.pizzabackend.pizzabackend.modelo.Ingrediente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredienteRepository extends CrudRepository<Ingrediente, String> {

}
