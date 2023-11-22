package com.home.demo.controller;

import com.home.demo.dto.PersonaDto;
import com.home.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "*")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<PersonaDto> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @GetMapping("/{id}")
    public PersonaDto getPersonaById(@PathVariable Long id) {
        return personaService.getPersonaById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con ID: " + id));
    }

    @PostMapping
    public PersonaDto savePersona(@RequestBody PersonaDto personaDto) {
        return personaService.savePersona(personaDto);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
    }

}
