package com.oficina.educacional.api.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UserDTO {

    @Schema(
        description = "User entity unique identifier",
        example = "1",
        required = true
    )
    private long userId;

    @Schema(
        description = "User name",
        example = "Marcos Gomes",
        required = true
    )
    private String userName;

    @Schema(
        description = "User email",
        example = "test@gmail.com",
        required = true
    )
    private String userEmail;

        @Schema(
        description = "User telefone",
        example = "22999303392",
        required = true
    )
    private String userTelephone;

        @Schema(
        description = "User Profile Id",
        example = "1",
        required = true
    )
    private Long userProfile;
}
