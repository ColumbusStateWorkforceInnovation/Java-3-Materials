package edu.cscc.mvc.withRouting;

import edu.cscc.designpatterns.repository.Order;
import edu.cscc.mvc.withRouting.framework.ApplicationView;
import edu.cscc.mvc.withRouting.framework.MVCContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShowOrder extends ApplicationView {
    private Order order;

    public ShowOrder(MVCContext context, Order order) {
        super(context);
        this.order = order;
    }

    @Override
    public void show() {
        System.out.println("************");
        System.out.println("Order ID: " + order.getId());
        System.out.println("Order total: " + order.getTotal());
        System.out.println("Order customer name: " + order.getCustomerName());
        System.out.println("Order item count: " + order.getItemCount());
        Map params = new HashMap<>();
        params.put("orderId", order.getId());
        route("Orders", "edit", params);
    }
}
