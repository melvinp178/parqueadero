package com.home.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nombre")
        private String nombre;
    @Column(name = "contrasena")
    private String contrasena;
        @ManyToOne
        @JoinColumn(name = "rol_id")
        private Rol rol;
        @ManyToOne
        @JoinColumn(name = "persona_id")
        private Persona persona;
        @OneToMany(mappedBy = "usuario")
        private List<Vehiculo> vehiculos;

}
