package com.mari.exceptions;


import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable { // retorna JSON com atributos

    private static final long serialVersionUID = 1L;

    private Date timestamp; // hora do erro
    private String message;
    private String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }


}
