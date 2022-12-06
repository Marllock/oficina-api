package com.oficina.educacional.api.model.input;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseInputDTO {

    @NotBlank
    @Schema(
        description = "Course name",
        example = "Ensino Médio",
        required = true
    )
    private String courseName;

    @Schema(
        description = "Course indentifier",
        example = "AS31A",
        required = true
    )
    @NotBlank
    @Pattern(regexp = "[A-Z]{2}\\d{2}[A-Z]")
    private String courseCode;
}
