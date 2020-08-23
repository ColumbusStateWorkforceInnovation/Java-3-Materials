package edu.cscc.mvc.withRouting;

import edu.cscc.mvc.withRouting.framework.MVCContext;
import edu.cscc.mvc.withRouting.framework.MVCView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeControllerTest {
    private MVCContext context;
    private HomeController homeController;

    @BeforeEach
    public void setUp() {
        context = new MVCContext();
        homeController = new HomeController(context);
    }

    @Test
    public void itRendersTheHomeIndexView() {
        homeController.index();

        MVCView view = context.getView();
        assertEquals(HomeIndex.class, view.getClass());
    }

    @Test
    public void itRendersTheGoodbyeView() {
        homeController.goodbye();

        MVCView view = context.getView();
        assertEquals(GoodbyeView.class, view.getClass());
    }
}