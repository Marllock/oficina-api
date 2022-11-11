package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.Professor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassDTO {
    private Course classCourse;
    private Professor classProfessor;
    private boolean classIsActive;
}
