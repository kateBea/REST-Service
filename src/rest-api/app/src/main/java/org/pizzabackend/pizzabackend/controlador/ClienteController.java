package org.pizzabackend.pizzabackend.controlador;


import org.pizzabackend.pizzabackend.modelo.Cliente;
import org.pizzabackend.pizzabackend.servicio.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "pizzeria/clientes")
public class ClienteController {

    @Autowired
    @Qualifier("clienteServiceImpl")
    IClienteService clienteService;

    @GetMapping(value = "consultartodos")
    ResponseEntity<List<Cliente>> consultarTodos() {
        List<Cliente> clientes = clienteService
                .consultarTodos().stream().toList();

        return ResponseEntity.ok(clientes);
    }

    @GetMapping("consultar/{dni}")
    ResponseEntity<Boolean> existe(@PathVariable String dni) {
        ResponseEntity<Boolean> response;

        boolean result = clienteService.existePorId(dni);
        response = result ? new ResponseEntity<>(true, HttpStatus.FOUND)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);

        return response;
    }

    @PostMapping("registrar")
    ResponseEntity<Boolean> registrar(@RequestBody Cliente nuevo) {
        ResponseEntity<Boolean> response;

        Optional<Cliente> result = Optional.empty();

        try {
            result = clienteService.registrar(nuevo);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        response = ResponseEntity.ok(result.isPresent());

        return response;
    }
}
