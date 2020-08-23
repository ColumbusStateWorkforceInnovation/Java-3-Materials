package edu.cscc.mvc.withRouting.framework;

import java.util.HashMap;
import java.util.Map;

public abstract class ApplicationView implements MVCView {
    protected MVCContext context;

    public ApplicationView(MVCContext context) {
        this.context = context;
        this.context.setRequest(new ExitRequest());
    }

    protected void route(String resource, String action) {
        route(resource, action, new HashMap());
    }

    protected void route(String resource, String action, Map params) {
        context.route(new Request(resource, action, params));
    }
}
