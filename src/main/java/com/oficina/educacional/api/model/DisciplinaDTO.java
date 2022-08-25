package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Curso;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

public class DisciplinaDTO {

    private Long id;

    @NotBlank
    private String disciplinaCode;

    @NotBlank
    @Length(max = 25)
    private String name;

    @NotBlank
    @Length(max = 25)
    private String nameNormalized;

    private Curso cursoId;
}
