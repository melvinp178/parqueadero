package com.home.demo.service;

import com.home.demo.dto.UsuarioDto;
import com.home.demo.entity.Usuario;
import com.home.demo.repository.PersonaRepository;
import com.home.demo.repository.RolRepository;
import com.home.demo.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PersonaRepository personaRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<UsuarioDto> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDto.class))
                .collect(Collectors.toList());
    }

    public Optional<UsuarioDto> getUsuarioById(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.map(usuario -> modelMapper.map(usuario, UsuarioDto.class));
    }

    public UsuarioDto saveUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return modelMapper.map(savedUsuario, UsuarioDto.class);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
