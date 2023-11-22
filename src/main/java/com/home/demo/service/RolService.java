package com.home.demo.service;

import com.home.demo.dto.RolDto;
import com.home.demo.entity.Rol;
import com.home.demo.repository.RolRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<RolDto> getAllRoles() {
        List<Rol> roles = rolRepository.findAll();
        return roles.stream()
                .map(rol -> modelMapper.map(rol, RolDto.class))
                .collect(Collectors.toList());
    }

    public Optional<RolDto> getRolById(Long id) {
        Optional<Rol> rolOptional = rolRepository.findById(id);
        return rolOptional.map(rol -> modelMapper.map(rol, RolDto.class));
    }

    public RolDto saveRol(RolDto rolDto) {
        Rol rol = modelMapper.map(rolDto, Rol.class);
        Rol savedRol = rolRepository.save(rol);
        return modelMapper.map(savedRol, RolDto.class);
    }

    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }
}
