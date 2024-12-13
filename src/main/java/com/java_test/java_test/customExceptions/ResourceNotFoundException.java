package com.java_test.java_test.customExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class represents a custom exception for handling cases when a requested resource is not found.
 * It is annotated with @ResponseStatus to automatically return a 404 NOT FOUND HTTP status when this exception is thrown.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructor that accepts a custom message to be displayed to the user when a request
     * results in a "resource not found" response.
     * 
     * @param message the custom message that will be shown to the user
     */
    public ResourceNotFoundException(String message){
        super(message);
    }
}
