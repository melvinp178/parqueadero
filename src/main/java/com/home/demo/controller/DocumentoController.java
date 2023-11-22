package com.home.demo.controller;

import com.home.demo.dto.DocumentoDto;
import com.home.demo.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/documento")
public class DocumentoController {
    @Autowired
    private DocumentoService documentoService;

    @GetMapping
    public List<DocumentoDto> getAllDocumentos() {
        return documentoService.getAllDocumentos();
    }

    @GetMapping("/{id}")
    public DocumentoDto getDocumentoById(@PathVariable Long id) {
        return documentoService.getDocumentoById(id)
                .orElseThrow(() -> new RuntimeException("Documento no encontrado con ID: " + id));
    }

    @PostMapping
    public DocumentoDto saveDocumento(@RequestBody DocumentoDto documentoDto) {
        return documentoService.saveDocumento(documentoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDocumento(@PathVariable Long id) {
        documentoService.deleteDocumento(id);
    }
}
