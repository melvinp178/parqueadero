package com.home.demo.controller;

import com.home.demo.dto.ParqueaderoDto;
import com.home.demo.service.ParqueaderoService;
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
@RequestMapping("/parqueadero")
public class ParqueaderoController {
    @Autowired
    private ParqueaderoService parqueaderoService;

    @GetMapping
    public List<ParqueaderoDto> getAllParqueaderos() {
        return parqueaderoService.getAllParqueaderos();
    }

    @GetMapping("/{id}")
    public ParqueaderoDto getParqueaderoById(@PathVariable Long id) {
        return parqueaderoService.getParqueaderoById(id)
                .orElseThrow(() -> new RuntimeException("Parqueadero no encontrado con ID: " + id));
    }

    @PostMapping
    public ParqueaderoDto saveParqueadero(@RequestBody ParqueaderoDto parqueaderoDto) {
        return parqueaderoService.saveParqueadero(parqueaderoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteParqueadero(@PathVariable Long id) {
        parqueaderoService.deleteParqueadero(id);
    }
}
