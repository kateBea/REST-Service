package org.pizzabackend.pizzabackend.controlador;

import org.pizzabackend.pizzabackend.modelo.Compra;
import org.pizzabackend.pizzabackend.servicio.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "pizzeria/compras")
public class CompraController {

    @Autowired
    @Qualifier("compraServiceImpl")
    ICompraService compraService;

    @GetMapping(value = "consultartodas")
    ResponseEntity<List<Compra>> consultarTodos() {
        List<Compra> compras = compraService
                .consultarTodas().stream().toList();

        return ResponseEntity.ok(compras);
    }

    @GetMapping("consultar/{id}")
    ResponseEntity<Compra> consultarCompra(@PathVariable Long id) {
        ResponseEntity<Compra> response;

        Optional<Compra> result = compraService.consultarPorId(id);
        response = ResponseEntity.of(result);

        return response;
    }
}
