package com.oficina.educacional.api.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CourseUpdateInputDTO {
    @Schema(
        description = "Course Name",
        example = "Ensino Médio",
        required = true
    )
    private String courseName;

    @Schema(
        description = "Course status",
        example = "Active",
        required = true
    )
    private Boolean courseIsActive;

    @Schema(
        description = "Course code",
        required = true
    )
    private String courseCode;
}
