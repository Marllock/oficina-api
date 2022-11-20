package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Course;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class DisciplineDTO {

    @Schema(
        description = "Discipline entity uniqe identifier",
        example = "1",
        required = true
    )
    private Long disciplineId;

    @Schema(
        description = "Discipline code",
        example = "AS31C",
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

    @Schema(
        description = "Discipline Course entity",
        required = true
    )
    private Course disciplineCourseId;
}
