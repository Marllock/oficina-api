package com.oficina.educacional.api.model.input;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(example = "Introdução a Análise de Sistemas")
    private String courseName;

    @NotBlank
    @Pattern(regexp = "[A-Z]{2}\\d{2}[A-Z]")
    @ApiModelProperty(example = "AS31B")
    private String courseCode;
}
