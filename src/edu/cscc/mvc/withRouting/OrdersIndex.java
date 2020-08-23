package edu.cscc.mvc.withRouting;

import edu.cscc.designpatterns.repository.Order;
import edu.cscc.mvc.withRouting.framework.ApplicationView;
import edu.cscc.mvc.withRouting.framework.MVCContext;

import java.util.List;

public class OrdersIndex extends ApplicationView {
    private List<Order> orders;

    public OrdersIndex(MVCContext context, List<Order> orders) {
        super(context);
        this.orders = orders;
    }

    @Override
    public void show() {
        orders.forEach(order -> {
            System.out.println(order);
        });
    }
}
