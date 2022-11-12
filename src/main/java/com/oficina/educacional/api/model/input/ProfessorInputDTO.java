package com.oficina.educacional.api.model.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfessorInputDTO extends UserInputDTO {
    private long courseId;
}
