package edu.cscc.mvc.withRouting.framework;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private final String resource;
    private String action;
    private final Map<String, Object> params;

    public Request(String resource, String action) {
        this.resource = resource;
        this.action = action;
        this.params = new HashMap<>();
    }

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

    public boolean isExit() {
        return false;
    }
}
