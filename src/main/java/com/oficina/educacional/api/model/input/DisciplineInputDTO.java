package com.oficina.educacional.api.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplineInputDTO {
    @Schema(
        description = "Discipline code",
        example = "AS31A",
        required = true
    )
    private String disciplineCode;
    @Schema(
        description = "Discipline name",
        example = "Oficina de integração",
        required = true
    )
    private String disciplineName;

    @Schema(
        description = "Course unique indentifier",
        example = "1",
        required = true
    )
    private Long courseId;
}
