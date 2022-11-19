package com.oficina.educacional.api.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeInputDTO {
    private long classId;
    private long studentId;
    private double score;
}
