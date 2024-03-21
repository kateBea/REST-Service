package org.pizzabackend.pizzabackend.utilidades;

import org.pizzabackend.pizzabackend.modelo.Cliente;
import org.pizzabackend.pizzabackend.modelo.Ingrediente;
import org.pizzabackend.pizzabackend.modelo.Masa;
import org.pizzabackend.pizzabackend.modelo.Pizza;
import org.pizzabackend.pizzabackend.servicio.IClienteService;
import org.pizzabackend.pizzabackend.servicio.ICompraService;
import org.pizzabackend.pizzabackend.servicio.IIngredienteService;
import org.pizzabackend.pizzabackend.servicio.IPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;


/**
 * Datos iniciales para pruebas
 * */

@Order(0)
@Component
public class CargarDatos implements CommandLineRunner {

    @Autowired
    @Qualifier("ingredienteServiceImpl")
    IIngredienteService ingredienteService;

    @Autowired
    @Qualifier("clienteServiceImpl")
    IClienteService clienteService;

    @Autowired
    @Qualifier("pizzaServiceImpl")
    IPizzaService pizzaService;

    @Autowired
    @Qualifier("compraServiceImpl")
    ICompraService compraService;

    @Override
    public void run(String... args) throws Exception {
        System.err.println("=============================================");
        System.err.println("         Cargando datos para pruebas         ");
        System.err.println("=============================================");

        // Ingredientes
        Ingrediente i1 = Ingrediente.builder().nombre("Mozzarella").build();
        Ingrediente i2 = Ingrediente.builder().nombre("Salami").build();
        Ingrediente i3 = Ingrediente.builder().nombre("Atún").build();
        Ingrediente i4 = Ingrediente.builder().nombre("Pepperoni").build();
        Ingrediente i5 = Ingrediente.builder().nombre("Champiñones").build();

        Set.of(i1, i2, i3, i4, i5).forEach(i -> ingredienteService.registrar(i));

        // Pizzas
        Pizza p1 = Pizza.builder()
                .ingredientes(Set.of(i1, i2))
                .masa(Masa.ROLL)
                .nombre("Al gusto")
                .build();

        Set.of(p1).forEach(p -> pizzaService.registrar(p));

        // Clientes
        Cliente c1 = Cliente.builder()
                .nombre("Hugo")
                .contrasenia("123")
                .email("hugo@unmail.com")
                .dni("12345678K")
                .telefono("622 11 22 33")
                .fechaNacimiento(LocalDate.now().minusYears(18))
                .build();
        
        Set.of(c1).forEach(c -> clienteService.registrar(c));
    }
}
