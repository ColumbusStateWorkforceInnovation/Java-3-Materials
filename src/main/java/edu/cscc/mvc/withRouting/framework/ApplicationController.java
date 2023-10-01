package edu.cscc.mvc.withRouting.framework;

/**
 * This is the base class that all Controllers should inherit from.
 * Make sure that all controllers are in the edu.cscc.mvc.withRouting package
 * and end with the word "Controller".
 */
public abstract class ApplicationController {
    protected final MVCContext context;

    public ApplicationController(MVCContext context) {
        this.context = context;
    }

    /**
     * Inform the {@link MVCContext} what view to render next.
     * @param view An instance of {@link ApplicationView}.
     */
    public void render(ApplicationView view) {
        context.render(view);
    }
}
