package com.aluraforo.desafio_foro.domain.foro;

import com.aluraforo.desafio_foro.domain.foro.Foro;
import com.aluraforo.desafio_foro.domain.foro.ForoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ForoService {
    @Autowired
    private ForoRepository foroRepository;

    public Foro registrarTopico(Foro foro) {
        if (foroRepository.existsByTituloAndMensaje(foro.getTitulo(), foro.getMensaje())) {
            throw new IllegalArgumentException("El tópico ya existe");
        }
        foro.setStatus("activo");
        return foroRepository.save(foro);
    }

    public Page<Foro> listarTopicos(Pageable pageable) {
        return foroRepository.findAll(pageable);
    }

    public Page<Foro> listarTopicosOrdenadosPorFecha(Pageable pageable) {
        return foroRepository.findAllByOrderByFechaCreacionAsc(pageable);
    }

    public Page<Foro> buscarTopicos(String curso, Integer anio, Pageable pageable) {
        return foroRepository.findByCursoAndAnio(curso, anio, pageable);
    }

    public Optional<Foro> obtenerTopicoPorId(Long id) {
        return foroRepository.findById(id);
    }

    public Foro actualizarTopico(Long id, Foro foroActualizado) {
        Optional<Foro> topicoExistente = foroRepository.findById(id);
        if (topicoExistente.isPresent()) {
            Foro foro = topicoExistente.get();
            foro.setTitulo(foroActualizado.getTitulo());
            foro.setMensaje(foroActualizado.getMensaje());
            foro.setAutor(foroActualizado.getAutor());
            foro.setCurso(foroActualizado.getCurso());
            return foroRepository.save(foro);
        } else {
            throw new IllegalArgumentException("El tópico no existe");
        }
    }

    public void eliminarTopico(Long id) {
        if (foroRepository.existsById(id)) {
            foroRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El tópico no existe");
        }
    }

}

