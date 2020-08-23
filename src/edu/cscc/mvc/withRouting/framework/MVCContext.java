package edu.cscc.mvc.withRouting.framework;

import edu.cscc.mvc.withRouting.framework.exceptions.RenderingException;
import edu.cscc.mvc.withRouting.framework.exceptions.RoutingException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MVCContext {

    private Request request;
    private Object resource;
    private Method action;
    private MVCView view;

    public void route(Request request) {
        RequestRouter requestRouter = new RequestRouter(this);
        requestRouter.onRequest(request);
    }

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
            if (request.isExit()) {
                System.out.println("Goodbye!");
            }
        } catch(RoutingException ex) {
            throw new RoutingException(
                    "Current view: "
                    + view.getClass().getName());
        }
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }

    public Object getResource() {
        return resource;
    }

    public Method getAction() {
        return action;
    }

    public MVCView getView() {
        return view;
    }

    public void updateContext(Object resource, Method action) {
        this.resource = resource;
        this.action = action;
    }

    public void processRequest(Request initialRequest) {
        route(initialRequest);
        try {
            action.invoke(resource);
            render();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void resetContext() {
        this.resource = null;
        this.action = null;
        this.view = null;
        this.request = null;
    }
}
