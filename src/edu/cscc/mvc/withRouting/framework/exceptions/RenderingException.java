package edu.cscc.mvc.withRouting.framework.exceptions;

/**
 * This exception should be raised when an error occurs
 * during the view rendering process.
 */
public class RenderingException extends RuntimeException {
    public RenderingException(Exception ex) {
        super(ex);
    }

    public RenderingException(String message) {
        super(message);
    }
}
