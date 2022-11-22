package com.oficina.educacional.api.model;

import lombok.*;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CourseDTO implements Serializable {

    @Schema(
        description = "Course unique identifier",
        example = "123",
        required = true
    )
    private Long courseId;

    @Schema(
        description = "Course name",
        example = "Ensino fundamental",
        required = true
    )
    @NotBlank
    private String courseName;

    @Schema(
        description = "Name of course normalized",
        example = "Ensino fundamental",
        required = true
    )
    @NotBlank
    private String courseNormalizedName;
}
