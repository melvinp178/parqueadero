package com.home.demo.service;

import com.home.demo.dto.SexoDto;
import com.home.demo.entity.Sexo;
import com.home.demo.repository.SexoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SexoService {

    @Autowired
    private SexoRepository sexoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<SexoDto> getAllSexos() {
        List<Sexo> sexos = sexoRepository.findAll();
        return sexos.stream()
                .map(sexo -> modelMapper.map(sexo, SexoDto.class))
                .collect(Collectors.toList());
    }

    public Optional<SexoDto> getSexoById(Long id) {
        Optional<Sexo> sexoOptional = sexoRepository.findById(id);
        return sexoOptional.map(sexo -> modelMapper.map(sexo, SexoDto.class));
    }

    public SexoDto saveSexo(SexoDto sexoDto) {
        Sexo sexo = modelMapper.map(sexoDto, Sexo.class);
        Sexo savedSexo = sexoRepository.save(sexo);
        return modelMapper.map(savedSexo, SexoDto.class);
    }

    public void deleteSexo(Long id) {
        sexoRepository.deleteById(id);
    }
}
