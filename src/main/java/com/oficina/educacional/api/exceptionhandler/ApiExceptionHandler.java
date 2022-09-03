package com.oficina.educacional.api.exceptionhandler;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.googlecode.flyway.core.util.ExceptionUtils;
import com.oficina.educacional.domain.exception.BadRequestException;
import com.oficina.educacional.domain.exception.EmptyResultException;
import com.oficina.educacional.domain.exception.IntegrityException;
import com.oficina.educacional.domain.exception.UnauthorizedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        Throwable rootCause = ExceptionUtils.getRootCause(ex);

        if (rootCause instanceof InvalidFormatException) {
            return handleInvalidFormatException((InvalidFormatException) rootCause, headers, status, request);
        }
        return handleExceptionInternal(ex, "Formato inválido!", new HttpHeaders(), status, request);
    }

    private ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException ex, HttpHeaders headers,
                                                                HttpStatus status, WebRequest request) {
        String path = ex.getPath().stream().map(JsonMappingException.Reference::getFieldName).collect(Collectors.joining("."));
        String message = String.format(
                "A propriedade '%s' recebeu o valor '%s', que é um tipo inválido. "
                        + "Corrija e informe um valor compatível com o tipo %s.",
                path, ex.getValue(), ex.getTargetType().getName());
        return handleExceptionInternal(ex, message, headers, status, request);
    }

    @ExceptionHandler(IntegrityException.class)
    public ResponseEntity<Object> handleIntegrityException(IntegrityException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(EmptyResultException.class)
    public ResponseEntity<Object> handleEmptyResultException(EmptyResultException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {

        if (body == null) {
            body = ExceptionResponse.builder().message(status.getReasonPhrase()).status(status.value()).build();
        } else if (body instanceof String) {
            body = ExceptionResponse.builder().message((String) body).status(status.value()).build();
        }

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        String message = "Um ou mais campos estão inválidos.";
        BindingResult bindingResult = ex.getBindingResult();

        List<ExceptionResponse.Field> fields = bindingResult.getFieldErrors().stream()
                .map(fieldError -> ExceptionResponse.Field.builder().name(fieldError.getField())
                        .message(fieldError.getDefaultMessage()).build())
                .collect(Collectors.toList());

        ExceptionResponse exceptionResponse = createExceptionResponseBuilder(status, message).fields(fields).build();

        return handleExceptionInternal(ex, exceptionResponse, headers, status, request);
    }

    private ExceptionResponse.ExceptionResponseBuilder createExceptionResponseBuilder(HttpStatus status, String message) {

        return ExceptionResponse.builder().message(message).status(status.value());
    }
}
