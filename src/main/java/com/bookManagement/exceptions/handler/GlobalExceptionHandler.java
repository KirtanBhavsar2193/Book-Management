package com.bookManagement.exceptions.handler;

import com.bookManagement.exceptions.DataNotFoundException;
import com.bookManagement.models.errors.ErrorRespons;
import com.bookManagement.models.errors.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.example.shoppingCart")
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ErrorRespons handlerDataNotFoundException(DataNotFoundException ex) {
        ErrorRespons errorResponse = new ErrorRespons(ex.getMessage(), ErrorType.MISSING_DATA);

        return errorResponse;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorRespons> handlerGlobalException(Exception ex) {
        ErrorRespons errorResponse = new ErrorRespons("An Unexpected Error Occurred", ErrorType.INTERNAL_ERROR);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
