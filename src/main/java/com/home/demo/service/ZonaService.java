package com.home.demo.service;

import com.home.demo.dto.VehiculoDto;
import com.home.demo.dto.ZonaDto;
import com.home.demo.entity.Vehiculo;
import com.home.demo.entity.Zona;
import com.home.demo.repository.VehiculoRepository;
import com.home.demo.repository.ZonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ZonaService {
    @Autowired
    private ZonaRepository zonaRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<ZonaDto> getAllZonas() {
        List<Zona> zonas = zonaRepository.findAll();
        return zonas.stream()
                .map(zona -> modelMapper.map(zona, ZonaDto.class))
                .collect(Collectors.toList());
    }

    public Optional<ZonaDto> getZonaById(Long id) {
        Optional<Zona> zonaOptional = zonaRepository.findById(id);
        return zonaOptional.map(zona -> modelMapper.map(zona, ZonaDto.class));
    }

    public ZonaDto saveZona(ZonaDto zonaDto) {
        Zona zona = new Zona();
        zona.setNombre(zonaDto.getNombre());
        Zona savedZona = zonaRepository.save(zona);
        return modelMapper.map(savedZona, ZonaDto.class);
    }

    public void deleteZona(Long id) {
        zonaRepository.deleteById(id);
    }
}
