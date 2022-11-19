package com.oficina.educacional.api.model;

import lombok.Getter;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
public class GradeDTO {
        @Schema(
        description = "Grade unique identifier",
        example = "1",
        required = true
    )
    private String gradeId;

        @Schema(
        description = "Grade student related entity",
        required = true
    )
    private StudentDTO gradeStudent;

        @Schema(
        description = "Grade class related entity",
        required = true
    )
    private ClassDTO gradeClass;
}
