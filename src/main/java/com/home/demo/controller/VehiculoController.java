package com.home.demo.controller;

import com.home.demo.dto.VehiculoDto;
import com.home.demo.service.VehiculoService;
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
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public List<VehiculoDto> getAllVehiculos() {
        return vehiculoService.getAllVehiculos();
    }

    @GetMapping("/{id}")
    public VehiculoDto getVehiculoById(@PathVariable Long id) {
        return vehiculoService.getVehiculoById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con ID: " + id));
    }

    @PostMapping
    public VehiculoDto saveVehiculo(@RequestBody VehiculoDto vehiculoDto) {
        return vehiculoService.saveVehiculo(vehiculoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteVehiculo(@PathVariable Long id) {
        vehiculoService.deleteVehiculo(id);
    }
}
