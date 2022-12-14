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
        description = "Discipline name",
        example = "Estrutura de Dados",
        required = true
    )
    @NotBlank
    @Length(max = 25)
    private String disciplineName;

    @Schema(
        description = "Discipline name normalized",
        example = "estrutura_de_dados",
        required = true

    )
    @NotBlank
    @Length(max = 25)
    private String disciplineNameNormalized;

    @Schema(implementation = Course.class)
    private Course disciplineCourseId;
}
