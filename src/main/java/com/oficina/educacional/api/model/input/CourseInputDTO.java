package com.oficina.educacional.api.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseInputDTO {

    @NotBlank
    private String courseName;

    @NotBlank
    @Pattern(regexp = "[A-Z]{2}\\d{2}[A-Z]")
    private String courseCode;
}
