package edu.cscc.mvc.withRouting;

import edu.cscc.mvc.withRouting.framework.ApplicationView;
import edu.cscc.mvc.withRouting.framework.MVCContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SelectOrder extends ApplicationView {

    public SelectOrder(MVCContext context) {
        super(context);
    }

    @Override
    public void show() {
        System.out.print("Enter order id: ");
        Scanner scanner = new Scanner(System.in);
        String orderId = scanner.next();
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", orderId);
        route("Orders", "show", params);
    }
}
