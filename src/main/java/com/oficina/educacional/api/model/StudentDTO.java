package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.User;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class StudentDTO {

    @Schema(
        description = "Student unique identifier",
        example = "12",
        required = true
    )
    private long studentId;

    @Schema(
        description = "Relation between Student and user",
        required = true
    )
    private User user;

    @Schema(
        description = "Relation between Student and course",
        required = true
    )
    private Course studentCourse;
}
