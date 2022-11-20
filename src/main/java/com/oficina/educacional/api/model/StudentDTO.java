package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.User;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class StudentDTO {

    @Schema(
        description = "Student unique identifier",
        example = "1",
        required = true
    )
    private long studentId;

    @Schema(
        description = "Student user related entity",
        required = true
    )
    private User user;

    @Schema(
        description = "Student course related entity",
        required = true
    )
    private Course studentCourse;
}
