package com.aluraforo.desafio_foro.controller;

import com.aluraforo.desafio_foro.domain.foro.Foro;
import com.aluraforo.desafio_foro.domain.foro.ForoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
@Validated
public class ForoController {
    @Autowired
    private ForoService foroService;

    @PostMapping
    public ResponseEntity<Foro> registrarTopico(@Valid @RequestBody Foro foro) {
        Foro nuevoForo = foroService.registrarTopico(foro);
        return ResponseEntity.ok(nuevoForo);
    }

    @GetMapping
    public ResponseEntity<Page<Foro>> listarTopicos(@PageableDefault(size = 10) Pageable pageable) {
        Page<Foro> topicos = foroService.listarTopicos(pageable);
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/ordenados")
    public ResponseEntity<Page<Foro>> listarTopicosOrdenadosPorFecha(@PageableDefault(size = 10) Pageable pageable) {
        Page<Foro> topicos = foroService.listarTopicosOrdenadosPorFecha(pageable);
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Page<Foro>> buscarTopicos(
            @RequestParam(required = false) String curso,
            @RequestParam(required = false) Integer anio,
            @PageableDefault(size = 10) Pageable pageable) {
        Page<Foro> topicos = foroService.buscarTopicos(curso, anio, pageable);
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foro> obtenerTopicoPorId(@PathVariable Long id) {
        Optional<Foro> topico = foroService.obtenerTopicoPorId(id);
        return topico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Foro> actualizarTopico(@PathVariable Long id, @Valid @RequestBody Foro foroActualizado) {
        try {
            Foro foro = foroService.actualizarTopico(id, foroActualizado);
            return ResponseEntity.ok(foro);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        try {
            foroService.eliminarTopico(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
