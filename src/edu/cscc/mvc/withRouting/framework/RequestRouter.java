package edu.cscc.mvc.withRouting.framework;

import edu.cscc.mvc.withRouting.framework.exceptions.RoutingException;

import java.lang.reflect.Method;

public class RequestRouter {

    private final MVCContext context;

    public RequestRouter(MVCContext context) {
        this.context = context;
    }

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
