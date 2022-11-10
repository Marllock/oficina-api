package com.oficina.educacional.api.model;

import com.oficina.educacional.domain.model.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateInputDTO {

    private String userName;
    private String userEmail;
    private Address userAddress;
    private String userTelephone;
    private boolean userIsActive;
}
