package com.oficina.educacional.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.CONFLICT)
public class EntityInUseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public EntityInUseException(String message) {
        super(message);
    }
}
