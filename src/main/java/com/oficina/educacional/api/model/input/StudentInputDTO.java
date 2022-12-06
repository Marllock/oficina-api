package com.oficina.educacional.api.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentInputDTO extends UserInputDTO {
    @Schema(
        description = "Course unique identifier",
        example = "123",
        required = true
    )
    private long courseId;
}
