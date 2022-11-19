package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.User;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class ProfessorDTO {

    @Schema(
        description = "Professor unique identifier",
        example = "1",
        required = true
    )
    private long professorId;

        @Schema(
        description = "Professor user related entity",
        required = true
    )
    private User user;

        @Schema(
        description = "Professor course related entity",
        required = true
    )
    private Course professorCourse;
}
