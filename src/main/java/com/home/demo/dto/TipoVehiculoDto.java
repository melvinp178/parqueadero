package com.home.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.home.demo.entity.Vehiculo;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
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
public class TipoVehiculoDto {
    private Long id;

    private String nombre;
    @JsonIgnore
    private List<VehiculoDto> vehiculosDto;
}
