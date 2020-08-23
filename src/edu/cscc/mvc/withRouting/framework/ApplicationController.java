package edu.cscc.mvc.withRouting.framework;

public abstract class ApplicationController {
    protected final MVCContext context;

    public ApplicationController(MVCContext context) {
        this.context = context;
    }

    public void render(ApplicationView view) {
        context.render(view);
    }
}
