package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.User;
import lombok.Data;

@Data
public class StudentDTO {

    private long studentId;
    private User user;
    private Course studentCourse;
}
