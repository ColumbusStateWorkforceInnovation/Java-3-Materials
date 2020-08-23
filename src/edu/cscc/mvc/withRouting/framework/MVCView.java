package edu.cscc.mvc.withRouting.framework;

/**
 * This is the base View interface used by the
 * {@link MVCContext} when rendering the view.
 */
public interface MVCView {

    /**
     * This is where all view rendering logic should occur.
     */
    void show();
}
