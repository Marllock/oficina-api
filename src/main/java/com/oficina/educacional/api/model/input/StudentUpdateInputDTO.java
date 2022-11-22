package com.oficina.educacional.api.model.input;

import com.oficina.educacional.domain.model.Address;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentUpdateInputDTO {
    @Schema(
        description = "Users telephone",
        example = "(22)922129801",
        required = true
    )
    private String userTelephone;

    @Schema(
        description = "Users Address",
        example = "Rua Joaquim Dias Castanho,981,Cornélio Procópio, Paraná,Do lado da UTFPR, 863000-000",
        required = true
    )
    private Address userAddress;

    @Schema(
        description = "Users Status",
        example = "Active",
        required = true
    )
    private boolean userIsActive;

    @Schema(
        description = "Course unique identifier",
        example = "123",
        required = true
    )
    private long courseId;
}
