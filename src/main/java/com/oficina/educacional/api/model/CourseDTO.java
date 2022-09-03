package com.oficina.educacional.api.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class CourseDTO implements Serializable {

    private final Long cursoId;

    @NotBlank
    private final String name;

    @NotBlank
    private final String normalizedName;
}
