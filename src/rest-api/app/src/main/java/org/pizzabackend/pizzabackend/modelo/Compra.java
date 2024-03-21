package org.pizzabackend.pizzabackend.modelo;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "COMPRA")
public class Compra {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private float coste;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "PIZZA_COMPRADA",
        joinColumns = @JoinColumn(name = "Compra", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "Pizza", nullable = false)
    )
    private Set<Pizza> pizzas;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;
}
