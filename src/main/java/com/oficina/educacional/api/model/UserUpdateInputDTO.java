package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Address;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateInputDTO {
    @Schema(
        description = "User name",
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
        description = "Users address",
        example = "Rua Joaquim Dias Castanho, Londrina, Paraná, 86300-000, Ao lado da Utfpr",
        required = true
    )
    private Address userAddress;

    @Schema(
        description = "Users telephone",
        example = "(22)922354865",
        required = true
    )
    private String userTelephone;

    @Schema(
        description = "Users Status",
        example = "active",
        required = true
    )
    private boolean userIsActive;
}
