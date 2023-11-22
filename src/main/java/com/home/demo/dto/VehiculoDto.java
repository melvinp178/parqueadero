package com.home.demo.dto;

import com.home.demo.entity.Parqueadero;
import com.home.demo.entity.TipoVehiculo;
import com.home.demo.entity.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombre;
    private String marca;
    private String placa;
    private Long usuarioId;
    private Long tipoVehiculoId;
    private Long parqueaderoId;
}
