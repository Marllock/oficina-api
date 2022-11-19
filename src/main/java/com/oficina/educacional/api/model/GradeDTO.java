package com.oficina.educacional.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeDTO {
    private String gradeId;
    private StudentDTO gradeStudent;
    private ClassDTO gradeClass;
}
