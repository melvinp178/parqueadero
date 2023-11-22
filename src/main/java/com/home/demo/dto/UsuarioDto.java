package com.home.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private Long id;

    private String nombre;
    private String contrasena;
    private Long rol_id;
    private Long persona_id;
    @JsonIgnore
    private List<VehiculoDto> vehiculosDto;
}
