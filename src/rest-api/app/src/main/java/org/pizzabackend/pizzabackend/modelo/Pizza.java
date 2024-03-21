package org.pizzabackend.pizzabackend.modelo;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)


@Entity
@Table(name = "PIZZA")
public class Pizza {

    @NonNull
    @EqualsAndHashCode.Include
    @Id
    @Column
    private String nombre;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Masa masa;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ingred_item")
    private Set<Ingrediente> ingredientes;

}
