package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Course;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class DisciplineDTO {

    private Long id;

    @NotBlank
    private String disciplineCode;

    @NotBlank
    @Length(max = 25)
    private String disciplineName;

    @NotBlank
    @Length(max = 25)
    private String disciplineNameNormalized;

    private Course disciplineCourseId;
}
