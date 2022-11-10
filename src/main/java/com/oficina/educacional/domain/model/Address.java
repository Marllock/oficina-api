package com.oficina.educacional.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Address {

    private String userStreet;
    private String userStreetNumber;
    private String userComplement;
    private String userDistrict;
    private String userZipCode;
    private String userState;
    private String userCity;
}
