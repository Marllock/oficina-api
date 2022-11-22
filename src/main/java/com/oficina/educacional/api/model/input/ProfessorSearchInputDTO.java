package com.oficina.educacional.api.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorSearchInputDTO {
    @Schema(
        description = "User unique identifier",
        example = "123",
        required = true
    )
    private Long userId;

    @Schema(
        description = "Course unique identifier",
        example = "123",
        required = true
    )
    private Long courseId;

    @Schema(
        description = "Page",
        example = "1",
        required = true
    )
    private int page;

    @Schema(
        description = "Elements by page",
        example = "50",
        required = true
    )
    private int perPage;

    @Schema(
        description = "Users name",
        example = "Ricardo",
        required = true
    )
    private String userName;

    @Schema(
        description = "Users e-mail",
        example = "ricardo@gmail.com",
        required = true
    )
    private String userEmail;

    @Schema(
        description = "Users city name",
        example = "Londrina",
        required = true
    )
    private String userCity;

    @Schema(
        description = "Users state",
        example = "Paraná",
        required = true
    )
    private String userState;

    @Schema(
        description = "Users profile level",
        example = "Professor",
        required = true
    )
    private Long userProfile;
}
