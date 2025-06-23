package com.quote.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(QuoteException.class)
    public ResponseEntity<String>handleGlobalException(QuoteException ex)
    {
        return new  ResponseEntity<>("Error :"+ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
