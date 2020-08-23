package edu.cscc.mvc.withRouting.framework.exceptions;

public class RenderingException extends RuntimeException {
    public RenderingException(Exception ex) {
        super(ex);
    }

    public RenderingException(String message) {
        super(message);
    }
}
