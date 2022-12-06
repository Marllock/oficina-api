package com.oficina.educacional.api.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeInputDTO {
    @Schema(
        description = "Class unique identifier",
        example = "12",
        required = true
    )
    private long classId;

    @Schema(
        description = "Student unique identifier",
        example = "123",
        required = true
    )
    private long studentId;

    @Schema(
        description = "Students grade",
        example = "75",
        required = true
    )
    private double score;
}
