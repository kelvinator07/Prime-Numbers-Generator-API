package com.primegenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PrimeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PrimeErrorResponse> handleException(Exception exception) {

        PrimeErrorResponse response = new PrimeErrorResponse();

        if (exception instanceof RuntimeException) {

            response.setMessage(exception.getMessage());
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setTimeStamp(System.currentTimeMillis());

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        }

        return new ResponseEntity<>(new PrimeErrorResponse(500, "Something went wrong. Please try again", System.currentTimeMillis()), HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
