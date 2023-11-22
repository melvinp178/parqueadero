package com.home.demo.service;

import com.home.demo.dto.VehiculoDto;
import com.home.demo.entity.Vehiculo;
import com.home.demo.repository.ParqueaderoRepository;
import com.home.demo.repository.PersonaRepository;
import com.home.demo.repository.TipoVehiculoRepository;
import com.home.demo.repository.UsuarioRepository;
import com.home.demo.repository.VehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;
    @Autowired
    private ParqueaderoRepository parqueaderoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<VehiculoDto> getAllVehiculos() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        return vehiculos.stream()
                .map(vehiculo -> modelMapper.map(vehiculo, VehiculoDto.class))
                .collect(Collectors.toList());
    }

    public Optional<VehiculoDto> getVehiculoById(Long id) {
        Optional<Vehiculo> vehiculoOptional = vehiculoRepository.findById(id);
        return vehiculoOptional.map(vehiculo -> modelMapper.map(vehiculo, VehiculoDto.class));
    }

    public VehiculoDto saveVehiculo(VehiculoDto vehiculoDto) {
        Vehiculo vehiculo = modelMapper.map(vehiculoDto, Vehiculo.class);
        vehiculo.setTipoVehiculo(tipoVehiculoRepository.getById(vehiculoDto.getTipoVehiculoId()));
        vehiculo.setUsuario(usuarioRepository.getById(vehiculoDto.getUsuarioId()));
        vehiculo.setParqueadero(parqueaderoRepository.getById(vehiculoDto.getParqueaderoId()));
        Vehiculo savedVehiculo = vehiculoRepository.save(vehiculo);
        return modelMapper.map(savedVehiculo, VehiculoDto.class);
    }

    public void deleteVehiculo(Long id) {
        vehiculoRepository.deleteById(id);
    }
}
