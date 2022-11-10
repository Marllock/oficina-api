package com.oficina.educacional.api.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CourseDTO implements Serializable {

    private Long courseId;

    @NotBlank
    private String courseName;

    @NotBlank
    private String courseNormalizedName;
}
