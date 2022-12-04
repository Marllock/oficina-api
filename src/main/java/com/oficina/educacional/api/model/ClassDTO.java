package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.Professor;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassDTO {

    @Schema(implementation = Course.class)
    private Course classCourse;

    @Schema(implementation = Professor.class)
    private Professor classProfessor;

    @Schema(
        description = "class status",
        example = "true",
        required = true
    )
    private boolean classIsActive;
}
