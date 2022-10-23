package com.oficina.educacional.api.model.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorSearchInputDTO {
    private long userId;
    private long courseId;
    private int page;
    private int perPage;
    private String userName;
    private String userEmail;
    private String userCity;
    private String userState;
    private long userProfile;
}
