package edu.cscc.mvc.withRouting.framework;

import edu.cscc.mvc.withRouting.framework.exceptions.RenderingException;
import edu.cscc.mvc.withRouting.framework.exceptions.RoutingException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This is the heart of our MVC framework. It is responsible for
 * starting the application, invoking requests, rendering views,
 * and making request data available to the rest of the application.
 * You don't need to understand how this class works.
 */
public class MVCContext {

    private RequestRouter requestRouter;
    private Request request;
    private Object resource;
    private Method action;
    private MVCView view;

    /**
     * Pass a request to the {@link RequestRouter}.
     * @param request The Request to be routed.
     */
    public void route(Request request) {
        if (requestRouter == null) {
            requestRouter = new RequestRouter(this);
        }
        requestRouter.onRequest(request);
    }

    /**
     * Sets the view object to be rendered next.
     * @param view The {@link MVCView} to be rendered.
     */
    public void render(MVCView view) {
        this.view = view;
    }

    private void render() {
        try {
            if (view == null) {
                throw new RenderingException(
                        "No view specified for: "
                                + resource.getClass().getName()
                                + "." + action.getName()
                                + "()");
            }
            view.show();
        } catch(RoutingException ex) {
            throw new RoutingException(
                    "Current view: "
                    + view.getClass().getName());
        }
    }

    /**
     * Convenience method to set a request manually.
     * You probably want to use it with {@link ExitRequest}
     * @param request The request to be set for processing.
     */
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     * Return the currently set request.
     * @return The {@link Request} object.
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Return the current resource a request was made for.
     * @return This should be a subclass of {@link ApplicationController}.
     */
    public Object getResource() {
        return resource;
    }

    /**
     * Return the current action a request was made for.
     * @return The {@link Method} to be invoked on a subclass of {@link ApplicationController}.
     */
    public Method getAction() {
        return action;
    }

    /**
     * Returns the current view that has been requested to be rendered.
     * @return An instance of {@link MVCView}.
     */
    public MVCView getView() {
        return view;
    }

    /**
     * Sets the requested resource and action.
     * This is a framework method that shouldn't be called directly.
     * @param resource An instance of {@link ApplicationController}.
     * @param action A {@link Method} to be called on the resource.
     */
    public void updateContext(Object resource, Method action) {
        this.resource = resource;
        this.action = action;
    }

    /**
     * This method is used to start the application. It receives an initial request indicating
     * where it should route the user to first, and then begins a processing loop in which it invokes
     * the requested action on a given resource, making the request params available.
     *
     * It will stop processing if an {@link ExitRequest} is set on the context.
     * @param initialRequest The initial request to start the application with.
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void processRequest(Request initialRequest) throws InvocationTargetException, IllegalAccessException {
        route(initialRequest);
        while(true) {
            if (request.isExit()) {
                System.out.println("Goodbye!");
                return;
            }

            action.invoke(resource);
            render();
        }
    }
}
