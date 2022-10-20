package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.User;
import lombok.Data;

@Data
public class ProfessorDTO {

    private long professorId;
    private User user;
    private Course professorCourse;
}
