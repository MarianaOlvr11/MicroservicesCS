package com.mari.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST) // retorna esse codigo de erro
public class UnsuportedMathOperationException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public UnsuportedMathOperationException(String message) {
        super(message);
    }

}
