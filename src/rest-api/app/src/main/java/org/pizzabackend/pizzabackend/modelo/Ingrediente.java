package org.pizzabackend.pizzabackend.modelo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)


@Entity
@Table(name = "INGREDIENTE")
public class Ingrediente {

    @NonNull
    @EqualsAndHashCode.Include
    @Id
    @Column
    private String nombre;
}
