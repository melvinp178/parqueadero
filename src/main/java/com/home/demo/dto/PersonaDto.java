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
public class PersonaDto {

    private Long id;

    private String nombre;
    private String tipo_documento;
    private String celular;
    private String correo;
    private Long sexo_id;
    private Long documento_id;
    @JsonIgnore
    private List<UsuarioDto> usuariosDto;
}
