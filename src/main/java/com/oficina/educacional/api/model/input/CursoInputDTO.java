package com.oficina.educacional.api.model.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CursoInputDTO {

    @ApiModelProperty(name = "nome do curso")
    private String name;
}
