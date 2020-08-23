package edu.cscc.mvc.withRouting;


import edu.cscc.mvc.withRouting.framework.MVCContext;
import edu.cscc.mvc.withRouting.framework.Request;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MVCTest {
    protected MVCContext context;

    public void setUp() {
        context = new MVCContext();
    }

    protected void assertRouteExists(String resource, String expectedAction, Class controllerClass) {
        context.route(new Request(resource, expectedAction));
        assertEquals(controllerClass, context.getResource().getClass());
        assertEquals(expectedAction, context.getAction().getName());
    }

    protected void assertViewRendered(Class viewClass) {
        assertEquals(viewClass, context.getView().getClass());
    }

    protected void routeRequest(String resource, String action) {
        routeRequest(resource, action, new HashMap<>());
    }

    protected void routeRequest(String resource, String action, Map<String, Object> params) {
        context.route(new Request(resource, action, params));
        try {
            context.getAction().invoke(context.getResource());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
