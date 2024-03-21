package org.pizzabackend.pizzabackend.modelo;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @EqualsAndHashCode.Include
    @NonNull
    @Id
    @Column(length = 9)
    private String dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String contrasenia;

    @Column(nullable = false, name = "fecha_alta")
    private LocalDate fechaAlta;

    @Column(nullable = false, name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
}
