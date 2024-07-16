package com.aluraforo.desafio_foro.domain.foro;

import com.aluraforo.desafio_foro.domain.foro.Foro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface ForoRepository extends JpaRepository<Foro, Long> {
    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    Page<Foro> findAllByOrderByFechaCreacionAsc(Pageable pageable);

    @Query("SELECT f FROM Foro f WHERE (:curso IS NULL OR f.curso = :curso) AND (:anio IS NULL OR YEAR(f.fechaCreacion) = :anio)")
    Page<Foro> findByCursoAndAnio(@Param("curso") String curso, @Param("anio") Integer anio, Pageable pageable);
}


