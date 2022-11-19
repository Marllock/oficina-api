package com.oficina.educacional.api.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplineInputDTO {
    private String disciplineCode;
    private String disciplineName;
    private Long courseId;
}
