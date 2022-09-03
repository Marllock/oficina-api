package com.oficina.educacional.api.model.input;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;

@Data
public class CourseUpdateInputDTO {

    private String courseName;

    private Boolean courseIsActive;

    private String courseCode;
}
