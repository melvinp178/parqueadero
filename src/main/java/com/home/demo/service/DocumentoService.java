package com.home.demo.service;

import com.home.demo.dto.DocumentoDto;
import com.home.demo.entity.Documento;
import com.home.demo.repository.DocumentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocumentoService {


    @Autowired
    private DocumentoRepository documentoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<DocumentoDto> getAllDocumentos() {
        List<Documento> documentos = documentoRepository.findAll();
        return documentos.stream()
                .map(documento -> modelMapper.map(documento, DocumentoDto.class))
                .collect(Collectors.toList());
    }

    public Optional<DocumentoDto> getDocumentoById(Long id) {
        Optional<Documento> documentoOptional = documentoRepository.findById(id);
        return documentoOptional.map(documento -> modelMapper.map(documento, DocumentoDto.class));
    }

    public DocumentoDto saveDocumento(DocumentoDto documentoDto) {
        Documento documento = modelMapper.map(documentoDto, Documento.class);
        Documento savedDocumento = documentoRepository.save(documento);
        return modelMapper.map(savedDocumento, DocumentoDto.class);
    }

    public void deleteDocumento(Long id) {
        documentoRepository.deleteById(id);
    }
}
