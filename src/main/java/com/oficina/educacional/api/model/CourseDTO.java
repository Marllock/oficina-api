package com.oficina.educacional.api.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
public class CourseDTO implements Serializable {

    @Schema(
        description = "Course entity Id",
        example = "1",
        required = true
    )
    private Long courseId;

    @Schema(
        description = "Course entity name",
        example = "Engenhadia de Computação",
        required = true
    )
    @NotBlank
    private String courseName;

    @Schema(
        description = "Course entity name normalized",
        example = "engenharia_de_computacao",
        required = false
    )
    @NotBlank
    private String courseNormalizedName;
}
