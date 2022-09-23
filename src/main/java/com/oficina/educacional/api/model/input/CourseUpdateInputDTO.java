package com.oficina.educacional.api.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseUpdateInputDTO {

    private String courseName;

    private Boolean courseIsActive;

    private String courseCode;
}
