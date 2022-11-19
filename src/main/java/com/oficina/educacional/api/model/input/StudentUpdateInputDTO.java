package com.oficina.educacional.api.model.input;

import com.oficina.educacional.domain.model.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentUpdateInputDTO {
    private String userTelephone;
    private Address userAddress;
    private boolean userIsActive;
    private long courseId;
}
