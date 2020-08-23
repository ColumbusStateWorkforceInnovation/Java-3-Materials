package edu.cscc.mvc.withRouting.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the base View class that all developer views should inherit
 * from. Default behavior is to inform the {@link MVCContext} to exit
 * if no routing option is specified by invoking {@link ApplicationView#route(String, String, Map)}.
 */
public abstract class ApplicationView implements MVCView {
    protected MVCContext context;

    /**
     * Sets the context and configures it to exit by default
     * unless a route is specified.
     * @param context The {@link MVCContext}.
     */
    public ApplicationView(MVCContext context) {
        this.context = context;
        this.context.setRequest(new ExitRequest());
    }

    /**
     * Helper method for specifying a route with no parameters.
     * See {@link ApplicationView#route(String, String, Map)}.
     */
    protected void route(String resource, String action) {
        route(resource, action, new HashMap());
    }

    /**
     * Creates a {@link Request} to specify where the user should be routed after the view is rendered. If this method is not called
     * then the appliation will exit.
     * @param resource The name of the controller resource in the edu.cscc.mvc.withRouting package.
     *                 This name should be the prefix of the controller name. So if the controller is called
     *                 "OrdersController" then the resource should be "Orders".
     * @param action The name of a method to call on a resource.
     * @param params A map of parameters to be passed as part of the created request.
     */
    protected void route(String resource, String action, Map<String, Object> params) {
        context.route(new Request(resource, action, params));
    }
}
