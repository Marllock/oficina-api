package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.Professor;
import lombok.Getter;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
public class ClassDTO {

    @Schema(
        description = "Class course entity",
        required = true
    )
    private Course classCourse;

    @Schema(
        description = "class professor entity",
        required = true
    )
    private Professor classProfessor;

    @Schema(
        description = "class status",
        example = "true",
        required = true
    )
    private boolean classIsActive;
}
