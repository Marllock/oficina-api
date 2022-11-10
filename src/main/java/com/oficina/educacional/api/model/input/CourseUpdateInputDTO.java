package com.oficina.educacional.api.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CourseUpdateInputDTO {

    private String courseName;
    private Boolean courseIsActive;
    private String courseCode;
}
