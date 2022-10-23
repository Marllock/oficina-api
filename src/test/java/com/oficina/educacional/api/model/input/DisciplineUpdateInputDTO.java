package com.oficina.educacional.api.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplineUpdateInputDTO {
    private String disciplineName;
    private String disciplineCode;
    private long courseId;

}
