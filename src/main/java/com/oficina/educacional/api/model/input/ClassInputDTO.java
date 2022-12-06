package com.oficina.educacional.api.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassInputDTO {
    @Schema(
        description = "Course unique identifier id",
        example = "1",
        required = true
    )
    private long courseId;
    
    @Schema(
        description = "Professor unique indentifier id",
        example = "1",
        required = true
    )
    private long professorId;
}
