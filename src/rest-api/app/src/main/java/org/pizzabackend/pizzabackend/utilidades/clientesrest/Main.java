package org.pizzabackend.pizzabackend.utilidades.clientesrest;

import org.pizzabackend.pizzabackend.modelo.Cliente;
import org.pizzabackend.pizzabackend.modelo.Compra;
import org.pizzabackend.pizzabackend.modelo.Pizza;
import org.pizzabackend.pizzabackend.utilidades.FormattedIO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Optional;

public class Main {

    private static final String URLBASE_CLIENTE = "http://localhost:8080/pizzeria/clientes/";
    private static final String URLBASE_COMPRA = "http://localhost:8080/pizzeria/compras/";
    private static final String URLBASE_INGREDIENTE = "http://localhost:8080/pizzeria/ingredientes/";
    private static final String URLBASE_PIZZA = "http://localhost:8080/pizzeria/pizzas/";
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    public static void main(String[] args) {
        int opcion;
        final int SALIR = 4;

        do {
            mostrarMenu();
            opcion = FormattedIO.leerInteger("\nIntroduce un índice: ");
            procesarOpcion(opcion);
        } while (opcion != SALIR);
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> registrarCliente();
            case 2 -> consultarDetallesPedido();
            case 3 -> realizarPedido();
        }
    }

    private static void consultarDetallesPedido() {
        final Long id = FormattedIO.leerInteger("Introduzca el identificador: ").longValue();

        try {
            ResponseEntity<Compra> response = REST_TEMPLATE.getForEntity(
                    URLBASE_COMPRA + "consultar/{id}",
                    Compra.class,
                    id
            );

            Compra compra = response.getBody();

            if (compra != null) {
                System.out.printf("Detalles compra con identificador [%d]:\n", id);
                System.out.println("Cliente: " + compra.getCliente().getNombre());
                System.out.println("Fecha: " + compra.getFecha());
                System.out.println("Pizzas:");

                int indice = 1;
                for (Pizza pizza : compra.getPizzas()) {
                    System.out.printf("%d. %s", indice++, pizza.getNombre());
                }

                System.out.println("Coste total: " + compra.getCoste());
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void realizarPedido() {
        // Mostrar listado de las pizzas, si se elige una al gusto
        // mostramos al cliente la lista de ingredientes de los cuales puede escoger
        // tres como máximo
    }

    private static void registrarCliente() {
        // pedidos datos
        final String dni = FormattedIO.leerCadena("Introduce tu DNI: ");

        // Comprobar si existe el dni, en cuyo caso evitar seguir rellenando el formulario
        if (clienteExiste(dni)) {
            System.err.printf("El cliente con dni %s ya existe\n", dni);
            return;
        }

        final String nombre = FormattedIO.leerCadena("Introduce tu nombre: ");
        final String email = FormattedIO.leerCadena("Introduce tu Email: ");
        final String password = FormattedIO.leerCadena("Introduce tu contraseña: ");
        final String telf = FormattedIO.leerCadena("Introduce tu número de teléfono: ");
        final Optional<Integer> fechaNacimiento =
            Optional.ofNullable(FormattedIO.leerInteger("Introduce tu edad: "));

        Cliente nuevo = Cliente.builder()
                .dni(dni)
                .nombre(nombre)
                .email(email)
                .contrasenia(password)
                .telefono(telf)
                // Se asume usuario es mayor de edad por defecto
                .fechaNacimiento(LocalDate.now().minusYears(fechaNacimiento.orElse(18)))
                .build();

        try {
            ResponseEntity<Boolean> response = REST_TEMPLATE.postForEntity(
                    URLBASE_CLIENTE + "registrar",
                    nuevo,
                    Boolean.class
            );

            if (Boolean.TRUE.equals(response.getBody())) {
                System.out.println("El usuario se ha registrado con éxito.");
            } else {
                System.out.println("Error al registrar usuario. Ya existe.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static boolean clienteExiste(String dni) {
        boolean result = false;

        try {
            var response = REST_TEMPLATE.getForEntity(
                    URLBASE_CLIENTE + "consultar/{dni}",
                    Boolean.class,
                    dni
                    );

            result = Boolean.TRUE.equals(response.getBody());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    private static void mostrarMenu() {
        System.out.println("1. Registrar cliente");
        System.out.println("2. Consultar detalles pedido");
        System.out.println("3. Realizar pedido");
        System.out.println("4. Salir");
    }
}
