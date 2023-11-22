package com.home.demo.service;

import com.home.demo.dto.TipoVehiculoDto;
import com.home.demo.entity.TipoVehiculo;
import com.home.demo.repository.TipoVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoVehiculoService {

    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<TipoVehiculoDto> getAllTiposVehiculo() {
        List<TipoVehiculo> tiposVehiculo = tipoVehiculoRepository.findAll();
        return tiposVehiculo.stream()
                .map(tipoVehiculo -> modelMapper.map(tipoVehiculo, TipoVehiculoDto.class))
                .collect(Collectors.toList());
    }

    public Optional<TipoVehiculoDto> getTipoVehiculoById(Long id) {
        Optional<TipoVehiculo> tipoVehiculoOptional = tipoVehiculoRepository.findById(id);
        return tipoVehiculoOptional.map(tipoVehiculo -> modelMapper.map(tipoVehiculo, TipoVehiculoDto.class));
    }

    public TipoVehiculoDto saveTipoVehiculo(TipoVehiculoDto tipoVehiculoDto) {
        TipoVehiculo tipoVehiculo = modelMapper.map(tipoVehiculoDto, TipoVehiculo.class);
        TipoVehiculo savedTipoVehiculo = tipoVehiculoRepository.save(tipoVehiculo);
        return modelMapper.map(savedTipoVehiculo, TipoVehiculoDto.class);
    }

    public void deleteTipoVehiculo(Long id) {
        tipoVehiculoRepository.deleteById(id);
    }
}
