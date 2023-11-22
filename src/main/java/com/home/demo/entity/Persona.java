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
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo_documento")
    private String tipo_documento;
    @Column(name = "celular")
    private String celular;
    @Column(name = "correo")
    private String correo;

    @ManyToOne
    @JoinColumn(name = "sexo_id")
    private Sexo sexo;
    @ManyToOne
    @JoinColumn(name = "documento_id")
    private Documento documento;
    @OneToMany(mappedBy = "persona")
    private List<Usuario> usuarios;
}
