package com.oficina.educacional.api.model.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CourseInputDTO {

    @ApiModelProperty(example = "Introdução a Análise de Sistemas")
    private String courseName;

    @ApiModelProperty(example = "AS31B")
    private String courseCode;
}
