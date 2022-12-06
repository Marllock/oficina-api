package com.oficina.educacional.api.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfessorInputDTO extends UserInputDTO {
    @Schema(
        description = "Course unique identifier",
        example = "123",
        required = true
    )
    private long courseId;
}
