package edu.cscc.mvc.withRouting;

import edu.cscc.mvc.withRouting.framework.ApplicationController;
import edu.cscc.mvc.withRouting.framework.MVCContext;

public class HomeController extends ApplicationController {
    public HomeController(MVCContext context) {
        super(context);
    }

    public void index() {
        render(new HomeIndex(context));
    }
}
