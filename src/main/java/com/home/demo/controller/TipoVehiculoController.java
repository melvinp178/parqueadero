package com.home.demo.controller;

import com.home.demo.dto.TipoVehiculoDto;
import com.home.demo.service.TipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipo-vehiculo")
public class TipoVehiculoController {
    @Autowired
    private TipoVehiculoService tipoVehiculoService;

    @GetMapping
    public List<TipoVehiculoDto> getAllTiposVehiculo() {
        return tipoVehiculoService.getAllTiposVehiculo();
    }

    @GetMapping("/{id}")
    public TipoVehiculoDto getTipoVehiculoById(@PathVariable Long id) {
        return tipoVehiculoService.getTipoVehiculoById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de vehículo no encontrado con ID: " + id));
    }

    @PostMapping
    public TipoVehiculoDto saveTipoVehiculo(@RequestBody TipoVehiculoDto tipoVehiculoDto) {
        return tipoVehiculoService.saveTipoVehiculo(tipoVehiculoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTipoVehiculo(@PathVariable Long id) {
        tipoVehiculoService.deleteTipoVehiculo(id);
    }
}
