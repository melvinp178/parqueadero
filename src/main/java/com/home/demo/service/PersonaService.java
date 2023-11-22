package com.home.demo.service;

import com.home.demo.dto.PersonaDto;
import com.home.demo.entity.Persona;
import com.home.demo.repository.DocumentoRepository;
import com.home.demo.repository.PersonaRepository;
import com.home.demo.repository.SexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private DocumentoRepository documentoRepository;
    @Autowired
    private SexoRepository sexoRepository;
    private ModelMapper modelMapper = new ModelMapper();
    public List<PersonaDto> getAllPersonas() {
        List<Persona> personas = personaRepository.findAll();
        return personas.stream()
                .map(persona -> modelMapper.map(persona, PersonaDto.class))
                .collect(Collectors.toList());
    }

    public Optional<PersonaDto> getPersonaById(Long id) {
        Optional<Persona> personaOptional = personaRepository.findById(id);
        return personaOptional.map(persona -> modelMapper.map(persona, PersonaDto.class));
    }

    public PersonaDto savePersona(PersonaDto personaDto) {
        Persona persona = modelMapper.map(personaDto, Persona.class);
        persona.setDocumento(documentoRepository.getById(personaDto.getDocumento_id()));
        persona.setSexo(sexoRepository.getById(personaDto.getSexo_id()));
        Persona savedPersona = personaRepository.save(persona);
        return modelMapper.map(savedPersona, PersonaDto.class);
    }

    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
}
