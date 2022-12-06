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
        required = false
    )
    private Long userId;

    @Schema(
        description = "Course unique identifier",
        example = "123",
        required = false
    )
    private Long courseId;

    @Schema(
        description = "Page",
        example = "0",
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
        required = false
    )
    private String userName;

    @Schema(
        description = "Users e-mail",
        example = "ricardo@gmail.com",
        required = false
    )
    private String userEmail;

    @Schema(
        description = "Users city name",
        example = "Londrina",
        required = false
    )
    private String userCity;

    @Schema(
        description = "Users state",
        example = "Paraná",
        required = false
    )
    private String userState;

    @Schema(
        description = "Users profile level",
        example = "Professor",
        required = false
    )
    private Long userProfile;
}
