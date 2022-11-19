package com.oficina.educacional.api.model.input;

import com.oficina.educacional.domain.model.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfessorUpdateInputDTO {
    private long courseId;
    private Address userAddress;
    private boolean isActive;
    private String userName;
    private String userEmail;
    private String userTelephone;
}
