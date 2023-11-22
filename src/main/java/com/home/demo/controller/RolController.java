package com.home.demo.controller;

import com.home.demo.dto.RolDto;
import com.home.demo.service.RolService;
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
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping
    public List<RolDto> getAllRoles() {
        return rolService.getAllRoles();
    }

    @GetMapping("/{id}")
    public RolDto getRolById(@PathVariable Long id) {
        return rolService.getRolById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + id));
    }

    @PostMapping
    public RolDto saveRol(@RequestBody RolDto rolDto) {
        return rolService.saveRol(rolDto);
    }

    @DeleteMapping("/{id}")
    public void deleteRol(@PathVariable Long id) {
        rolService.deleteRol(id);
    }
}
