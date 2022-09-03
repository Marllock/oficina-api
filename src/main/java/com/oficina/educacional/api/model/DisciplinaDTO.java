package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Course;
import org.hibernate.validator.constraints.Length;

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

    private Course cursoId;
}
