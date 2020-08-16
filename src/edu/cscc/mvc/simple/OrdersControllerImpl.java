package edu.cscc.mvc.simple;

import edu.cscc.designpatterns.repository.Order;

public class OrdersControllerImpl implements OrdersController {
    private Order model;

    public OrdersControllerImpl(Order order) {
        this.model = order;
    }

    @Override
    public void show() {
        OrdersView ordersView = new OrdersViewImpl(this.model, this);
        ordersView.show();
    }

    // other methods

    @Override
    public void save(Order order) {
        this.model.setTotal(order.getTotal());
        this.model.setCustomerName(order.getCustomerName());
        this.model.setItemCount(order.getItemCount());

        OrdersView ordersView = new OrdersViewImpl(this.model, this);
        ordersView.show();
    }

    @Override
    public void edit() {
        OrdersView ordersView = new OrdersViewImpl(this.model, this);
        ordersView.edit();
    }
}
