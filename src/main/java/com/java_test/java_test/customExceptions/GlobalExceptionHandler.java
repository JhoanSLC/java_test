package com.java_test.java_test.customExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

// This annotation indicates that this class handles global exceptions for all controllers
@ControllerAdvice
public class GlobalExceptionHandler {

    // This method handles ResourceNotFoundException and returns a custom error message with a 404 status
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(ResourceNotFoundException ex) {
        // Return the exception message with a 404 Not Found status
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // This method handles validation exceptions when request parameters or body do not meet validation criteria
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Extract the first validation error message from the exception
        String error = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        // Return the error message with a 400 Bad Request status
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // This method handles all other general exceptions and returns a generic error message with a 500 status
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        // Return a generic error message with a 500 Internal Server Error status
        return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
