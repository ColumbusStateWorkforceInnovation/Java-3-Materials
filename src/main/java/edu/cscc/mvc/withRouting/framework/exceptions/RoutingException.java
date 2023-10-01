package edu.cscc.mvc.withRouting.framework.exceptions;

/**
 * This exception should be raised when an error occurs
 * during the request routing process.
 */
public class RoutingException extends RuntimeException {
    public RoutingException(String message) {
        super(message);
    }
}
