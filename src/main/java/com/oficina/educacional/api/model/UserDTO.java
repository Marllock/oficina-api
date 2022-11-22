package com.oficina.educacional.api.model;

import lombok.Data;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class UserDTO {

    @Schema(
        description = "User unique identifier",
        example = "123",
        required = true
    )
    private long userId;

    @Schema(
        description = "User name",
        example = "Ricardo",
        required = true
    )
    private String userName;

    @Schema(
        description = "User e-mail",
        example = "ricardo@gmail.com",
        required = true
    )
    private String userEmail;

    @Schema(
        description = "User birth date",
        example = "02/03/2000",
        required = true
    )
    private LocalDate userBirthdate;

    @Schema(
        description = "User telephone",
        example = "(22)922354865",
        required = true
    )
    private String userTelephone;

    @Schema(
        description = "Users profile level",
        example = "Professor",
        required = true
    )
    private String userProfile;
}
