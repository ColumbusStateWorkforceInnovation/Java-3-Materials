package edu.cscc.mvc.withRouting.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * A request to route to a given resource and perform
 * a given action with a set of params to support the requested action.
 * This class works with the {@link RequestRouter} and abstracts away
 * the details of where a request os going and how it is processed.
 */
public class Request {

    private final String resource;
    private String action;
    private final Map<String, Object> params;

    /**
     * Create a request with no parameters.
     * See {@link Request#Request(String, String, Map)}.
     */
    public Request(String resource, String action) {
        this.resource = resource;
        this.action = action;
        this.params = new HashMap<>();
    }

    /**
     * Creates a request to route to a resource to perform a given action.
     * @param resource The resource to be routed to. Should be prefix of the controller
     *                 being requested.
     * @param action The action to perform on the resource, which maps to a method on the
     *               {@link ApplicationController} instance the request will be routed to.
     * @param params A set of parameters to be used by the method specified by the action on
     *               the controller resource.
     */
    public Request(String resource, String action, Map<String, Object> params) {
        this.resource = resource;
        this.action = action;
        this.params = params;
    }

    public String getResource() {
        return resource;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "Request{" +
                "resource='" + resource + '\'' +
                ", action='" + action + '\'' +
                ", params=" + params +
                '}';
    }

    /**
     * Indicates that the application should not exit when this request is received.
     * @return false always.
     */
    public boolean isExit() {
        return false;
    }
}
