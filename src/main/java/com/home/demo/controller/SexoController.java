package com.home.demo.controller;

import com.home.demo.dto.SexoDto;
import com.home.demo.service.SexoService;
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
@RequestMapping("/sexo")
public class SexoController {

    @Autowired
    private SexoService sexoService;

    @GetMapping
    public List<SexoDto> getAllSexos() {
        return sexoService.getAllSexos();
    }

    @GetMapping("/{id}")
    public SexoDto getSexoById(@PathVariable Long id) {
        return sexoService.getSexoById(id)
                .orElseThrow(() -> new RuntimeException("Sexo no encontrado con ID: " + id));
    }

    @PostMapping
    public SexoDto saveSexo(@RequestBody SexoDto sexoDto) {
        return sexoService.saveSexo(sexoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSexo(@PathVariable Long id) {
        sexoService.deleteSexo(id);
    }
}
