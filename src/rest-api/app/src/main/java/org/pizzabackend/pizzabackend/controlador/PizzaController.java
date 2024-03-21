package org.pizzabackend.pizzabackend.controlador;

import org.pizzabackend.pizzabackend.modelo.Pizza;
import org.pizzabackend.pizzabackend.servicio.IPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "pizzeria/pizzas")
public class PizzaController {

    @Autowired
    @Qualifier("pizzaServiceImpl")
    IPizzaService pizzaService;

    @GetMapping(value = "consultartodas")
    ResponseEntity<List<Pizza>> consultarTodos() {
        List<Pizza> pizzas = pizzaService
                .consultarTodas().stream().toList();

        return ResponseEntity.ok(pizzas);
    }
}
