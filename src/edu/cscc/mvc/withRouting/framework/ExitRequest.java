package edu.cscc.mvc.withRouting.framework;

public class ExitRequest extends Request {

    public ExitRequest() {
        super(null, null);
    }

    public boolean isExit() {
        return true;
    }
}
