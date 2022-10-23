package com.oficina.educacional.api.model.input;

import com.oficina.educacional.domain.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInputDTO {

    private String userName;
    private String userEmail;
    private String userDocument;
    private LocalDate userBirthDate;
    private String userTelephone;
    private Address userAddress;
    private long userProfile;
}
