package edu.cscc.mvc.simple;

import edu.cscc.designpatterns.repository.Order;

public class OrdersControllerImpl implements OrdersController {
    private Order model;

    public OrdersControllerImpl(Order order) {
        this.model = order;
    }

    @Override
    public void show() {
        OrdersView ordersView = new OrdersViewImpl(this.model);
        ordersView.show();
    }
}
