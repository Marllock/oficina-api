package com.oficina.educacional.api.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeUpdateInputDTO {
    @Schema(
        description = "Grade unique identifier",
        example = "123",
        required = true
    )
    private String gradeId;

    @Schema(
        description = "Students grade",
        example = "75",
        required = true
    )
    private double score;
}
