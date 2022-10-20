package com.oficina.educacional.api.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UserDTO {

    private long userId;
    private String userName;
    private String userEmail;
    private LocalDate userBirthdate;
    private String userTelephone;
    private String userProfile;
}
