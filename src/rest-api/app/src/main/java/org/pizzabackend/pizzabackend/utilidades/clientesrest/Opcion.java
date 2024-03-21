package org.pizzabackend.pizzabackend.utilidades.clientesrest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public abstract class Opcion {
    private String description;

    public abstract void accion();
}
