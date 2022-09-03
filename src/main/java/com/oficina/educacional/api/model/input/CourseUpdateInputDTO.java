package com.oficina.educacional.api.model.input;

import lombok.Data;

@Data
public class CourseUpdateInputDTO {

    private String courseName;

    private Boolean courseIsActive;

    private String courseCode;
}
