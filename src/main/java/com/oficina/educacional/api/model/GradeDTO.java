package com.oficina.educacional.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeDTO {
        @Schema(
        description = "Grade unique identifier",
        example = "1",
        required = true
    )
    private String gradeId;

    @Schema(implementation = StudentDTO.class)
    private StudentDTO gradeStudent;

    @Schema(implementation = ClassDTO.class)
    private ClassDTO gradeClass;
}
