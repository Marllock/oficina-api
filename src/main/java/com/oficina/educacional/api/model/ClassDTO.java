package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.Professor;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassDTO {
    @Schema(
        description = "Course of a class",
        example = "Ensino fundamental",
        required = true
    )
    private Course classCourse;

    @Schema(
        description = "Professor of that class",
        example = "Ricardo",
        required = true
    )
    private Professor classProfessor;

    @Schema(
        description = "Class status",
        example = "active",
        required = true
    )
    private boolean classIsActive;
}
