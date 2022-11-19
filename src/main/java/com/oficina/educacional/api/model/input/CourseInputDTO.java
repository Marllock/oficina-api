package com.oficina.educacional.api.model.input;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
public class CourseInputDTO {

    @NotBlank
    private String courseName;

    @NotBlank
    @Pattern(regexp = "[A-Z]{2}\\d{2}[A-Z]")
    private String courseCode;
}
