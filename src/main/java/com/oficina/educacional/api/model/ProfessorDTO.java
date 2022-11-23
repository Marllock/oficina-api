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

    @Schema(
        description = "Relation between professor and user",
        required = true
    )
    private User user;

    @Schema(
        description = "Relation between professor and course",
        required = true
    )
    private Course professorCourse;
}
