package com.oficina.educacional.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Address {
	@Schema(
        description = "User Street",
        example = "Rua Dos Andradas",
        required = true
    )
    private String userStreet;

    @Schema(
        description = "User Street Number",
        example = "123",
        required = true
    )    
    private String userStreetNumber;

    @Schema(
        description = "User Address Complement",
        example = "Apto 213",
        required = false
    )
    private String userComplement;

    @Schema(
        description = "User District",
        example = "Downtown",
        required = true
    )
    private String userDistrict;

    @Schema(
        description = "User CEP",
        example = "28960000",
        required = true
    )
    private String userZipCode;

    @Schema(
        description = "User State",
        example = "Rio de Janeiro",
        required = true
    )
    private String userState;

    @Schema(
        description = "User City",
        example = "Iguaba Grande",
        required = true
    )
    private String userCity;
}
