package com.aluraforo.desafio_foro.domain.foro;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Foro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String mensaje;

    @NotBlank
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @NotBlank
    private String status;

    @NotBlank
    private String autor;

    @NotBlank
    private String curso;
}

