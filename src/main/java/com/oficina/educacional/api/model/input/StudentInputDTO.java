package com.oficina.educacional.api.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentInputDTO extends UserInputDTO {
    private long courseId;
}
