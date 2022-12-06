package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.User;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProfessorDTO {

    @Schema(
        description = "Professor unique identifier",
        example = "1",
        required = true
    )
    private long professorId;

    @Schema(implementation = User.class)
    private User user;

    @Schema(implementation = Course.class)
    private Course professorCourse;
}
