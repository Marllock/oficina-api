package com.oficina.educacional.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IntegrityException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public IntegrityException(String message) {
        super(message);
    }
}
