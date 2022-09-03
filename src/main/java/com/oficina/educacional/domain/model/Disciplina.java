package com.oficina.educacional.domain.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "disciplina")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disciplina_id", nullable = false)
    private Long id;

    @NotBlank
    private String disciplinaCode;

    @NotBlank
    @Length(max = 25)
    @Column(name = "disciplina_name")
    private String name;

    @NotBlank
    @Length(max = 25)
    @Column(name = "disciplina_name_normalized")
    private String nameNormalized;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Course cursoId;
}