package com.oficina.educacional.api.model.input;

import com.oficina.educacional.domain.model.Address;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserInputDTO {
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
        description = "Users document numbers",
        example = "117.700.207-77",
        required = true
    )
    private String userDocument;

    @Schema(
        description = "Users birth date",
        example = "02/03/2000",
        required = true
    )
    private LocalDate userBirthDate;

    @Schema(
        description = "Users telephone",
        example = "(22)922354865",
        required = true
    )
    private String userTelephone;

    @Schema(
        description = "Users address",
        example = "Rua Joaquim Dias Castanho,981,Cornélio Procópio, Paraná,Do lado da UTFPR, 863000-000",
        required = true
    )
    private Address userAddress;
    @Schema(
        description = "Users Profile level",
        example = "professor",
        required = true
    )
    private long userProfile;
}
