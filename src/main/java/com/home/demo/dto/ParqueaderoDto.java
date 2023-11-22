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
public class ParqueaderoDto {

    private Long id;

    private String nombre;
    @JsonIgnore
    private List<VehiculoDto> vehiculosDto;
    private Long zonaId;
}
