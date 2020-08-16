package edu.cscc.mvc.simple;

import edu.cscc.designpatterns.repository.Order;

public class OrdersViewImpl implements OrdersView {
    private Order model;

    public OrdersViewImpl(Order model) {
        this.model = model;
    }

    @Override
    public void show() {
        System.out.println("************");
        System.out.println("Order ID: " + model.getId());
        System.out.println("Order total: " + model.getTotal());
        System.out.println("Order customer name: " + model.getCustomerName());
        System.out.println("Order item count: " + model.getItemCount());
    }
}
