package com.oficina.educacional.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeDTO {

    @Schema(
        description = "Grade unique identifier",
        example = "123",
        required = true
    )
    private String gradeId;

    @Schema(
        description = "Relation between student and grade",
        required = true
    )
    private StudentDTO gradeStudent;

    @Schema(
        description = "Relation between class and grade",
        required = true
    )
    private ClassDTO gradeClass;
}
