package edu.cscc.mvc.withRouting.framework;

import edu.cscc.mvc.withRouting.framework.exceptions.RoutingException;

import java.lang.reflect.Method;

/**
 * This class is responsible for routing {@link Request}s to the appropriate
 * controller and controller method. It is a framework object and should not be
 * called directly.
 */
public class RequestRouter {

    private MVCContext context;

    /**
     * This constructor is used by the framework and should not be invoked
     * directly.
     * @param context
     */
    public RequestRouter(MVCContext context) {
        this.context = context;
    }

    /**
     * Routes the Request object by looking for a class in the edu.cscc.mvc.withRouting package
     * that starts with the request.resource value and ends with the word "Controller". It then
     * looks for a method on that controller that matches the request.action name. This combination
     * of resource and action will be invoked by the {@link MVCContext} when the request is processed.
     * @param request The {@link Request} to be processed.
     * @throws {@link RoutingException} when a controller class and accompanying method cannot be found
     * based on the request.
     */
    public void onRequest(Request request) {
        try {
            context.setRequest(request);
            Class resourceClass = Class.forName(getResourceClass(request));
            Object instance = resourceClass
                    .getConstructor(MVCContext.class)
                    .newInstance(context);
            Method action = resourceClass.getDeclaredMethod(request.getAction());
            context.updateContext(instance, action);
        } catch(Exception ex) {
            System.err.println(ex);
            throw new RoutingException("Couldn't route resource " + request.getResource() + "Controller: " + ex);
        }
    }

    private String getResourceClass(Request request) {
        return "edu.cscc.mvc.withRouting." + request.getResource() + "Controller";
    }
}
