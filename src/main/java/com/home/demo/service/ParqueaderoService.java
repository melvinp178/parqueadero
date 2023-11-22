package com.home.demo.service;

import com.home.demo.dto.ParqueaderoDto;
import com.home.demo.entity.Parqueadero;
import com.home.demo.entity.Zona;
import com.home.demo.repository.ParqueaderoRepository;
import com.home.demo.repository.ZonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParqueaderoService {

    @Autowired
    private ParqueaderoRepository parqueaderoRepository;

    @Autowired
    private ZonaRepository repository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<ParqueaderoDto> getAllParqueaderos() {
        List<Parqueadero> parqueaderos = parqueaderoRepository.findAll();
        return parqueaderos.stream()
                .map(parqueadero -> modelMapper.map(parqueadero, ParqueaderoDto.class))
                .collect(Collectors.toList());
    }

    public Optional<ParqueaderoDto> getParqueaderoById(Long id) {
        Optional<Parqueadero> parqueaderoOptional = parqueaderoRepository.findById(id);
        return parqueaderoOptional.map(parqueadero -> modelMapper.map(parqueadero, ParqueaderoDto.class));
    }

    public ParqueaderoDto saveParqueadero(ParqueaderoDto parqueaderoDto) {
        Parqueadero parqueadero = modelMapper.map(parqueaderoDto, Parqueadero.class);
        parqueadero.setZona(repository.findById(parqueaderoDto.getZonaId()).get());
        Parqueadero savedParqueadero = parqueaderoRepository.save(parqueadero);
        return modelMapper.map(savedParqueadero, ParqueaderoDto.class);
    }

    public void deleteParqueadero(Long id) {
        parqueaderoRepository.deleteById(id);
    }
}
