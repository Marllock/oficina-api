package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Course;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class DisciplineDTO {

    @Schema(
        description = "Discipline unique identifier",
        example = "123",
        required = true
    )
    private Long disciplineId;

    @Schema(
        description = "Discipline code",
        example = "AS31A",
        required = true
    )
    @NotBlank
    private String disciplineCode;

    @Schema(
        description = "Name of discipline",
        example = "Matemática",
        required = true
    )
    @NotBlank
    @Length(max = 25)
    private String disciplineName;

    @Schema(
        description = "Name of discipline normalized",
        example = "Matemática",
        required = true
    )
    @NotBlank
    @Length(max = 25)
    private String disciplineNameNormalized;

    @Schema(
        description = "Relation between course and discipline",
        required = true
    )
    private Course disciplineCourseId;
}
