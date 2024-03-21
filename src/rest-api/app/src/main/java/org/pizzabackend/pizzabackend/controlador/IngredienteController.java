package org.pizzabackend.pizzabackend.controlador;

import org.pizzabackend.pizzabackend.modelo.Ingrediente;
import org.pizzabackend.pizzabackend.servicio.IIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pizzeria/ingredientes")
public class IngredienteController {

    @Autowired
    @Qualifier("ingredienteServiceImpl")
    IIngredienteService ingredienteService;

    @GetMapping(value = "consultartodos")
    ResponseEntity<List<Ingrediente>> consultarTodos() {
        List<Ingrediente> ingredientes = ingredienteService
            .consultarTodos().stream().toList();

        return ResponseEntity.ok(ingredientes);
    }
}
