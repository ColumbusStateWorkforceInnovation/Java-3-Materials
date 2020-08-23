package edu.cscc.mvc.withRouting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HomeControllerTest extends MVCTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void itCanRouteToHomeIndex() {
        assertRouteExists("Home", "index", HomeController.class);
    }

    @Test
    public void itRendersTheHomeIndexView() {
        routeRequest("Home", "index");

        assertViewRendered(HomeIndex.class);
    }

    @Test
    public void itCanRouteToHomeGoodbye() {
        assertRouteExists("Home", "goodbye", HomeController.class);
    }

    @Test
    public void itRendersTheGoodbyeView() {
        routeRequest("Home", "goodbye");

        assertViewRendered(GoodbyeView.class);
    }
}