package com.oficina.educacional.api.model.input;

import com.oficina.educacional.domain.model.Address;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfessorUpdateInputDTO {
    @Schema(
        description = "Course unique identifier",
        example = "123",
        required = true
    )
    private long courseId;

    @Schema(
        description = "Users address",
        example = "Rua Joaquim Dias Castanho,981,Cornélio Procópio, Paraná,Do lado da UTFPR, 863000-000",
        required = true
    )
    private Address userAddress;
    @Schema(
        description = "Account status",
        example = "active",
        required = true
    )
    private boolean isActive;

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
        description = "Users telephone",
        example = "(22)922129801",
        required = true
    )
    private String userTelephone;
}
