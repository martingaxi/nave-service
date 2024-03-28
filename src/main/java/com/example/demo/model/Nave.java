package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "naves")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "nave", cascade = CascadeType.ALL)
    @Size(min = 1, max = 3, message = "Una nave debe tener mimimo 1 y maximo 3 tripulantes.")
    private List<Tripulante> tripulantes;
}
