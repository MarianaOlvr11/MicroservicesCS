package com.mari.exceptions.Handler;


import com.mari.exceptions.ExceptionResponse;
import com.mari.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice // agrupa tratamento para goblal e cai nesse
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    // tratar metodo 500, inves disso retorna o 400 bad request
    @ExceptionHandler({Exception.class}) // seta exceções genericas
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){ // trata exceçoes genéricas
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // tratar a execeção de math cridada
    @ExceptionHandler({UnsupportedOperationException.class}) // seta exceções genericas
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request){ // trata exceçoes genéricas
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);// retorna 400 bad request
    }

    // tratar a execeção de recursos nao encontrados cridada
    @ExceptionHandler({ResourceNotFoundException.class}) // seta exceções genericas
    public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(Exception ex, WebRequest request){ // trata exceçoes genéricas
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
