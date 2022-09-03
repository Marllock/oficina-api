package com.oficina.educacional.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerErrorException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ServerErrorException(String message) {
        super(message);
    }
}
