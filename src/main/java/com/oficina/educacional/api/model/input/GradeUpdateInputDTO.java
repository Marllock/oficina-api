package com.oficina.educacional.api.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeUpdateInputDTO {
    private String gradeId;
    private double score;
}
