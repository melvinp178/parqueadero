package com.home.demo.controller;

import com.home.demo.dto.ZonaDto;
import com.home.demo.service.ZonaService;
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
@RequestMapping("/zona")
public class ZonaController {
    @Autowired
    private ZonaService zonaService;

    @GetMapping
    public List<ZonaDto> getAllZonas() {
        return zonaService.getAllZonas();
    }

    @GetMapping("/{id}")
    public ZonaDto getZonaById(@PathVariable Long id) {
        return zonaService.getZonaById(id)
                .orElseThrow(() -> new RuntimeException("Zona no encontrada con ID: " + id));
    }

    @PostMapping
    public ZonaDto saveZona(@RequestBody ZonaDto zonaDto) {
        return zonaService.saveZona(zonaDto);
    }

    @DeleteMapping("/{id}")
    public void deleteZona(@PathVariable Long id) {
        zonaService.deleteZona(id);
    }
}
