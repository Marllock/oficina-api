package com.oficina.educacional.api.exceptionhandler;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Getter
@Builder
public class ExceptionResponse {
    private String message;
    private Integer status;
    private List<Field> fields;

    @Getter
    @Builder
    public static class Field {
        private String name;
        private String message;
    }
}
