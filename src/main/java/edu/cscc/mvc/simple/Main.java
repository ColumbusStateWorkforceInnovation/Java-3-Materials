package edu.cscc.mvc.simple;

import edu.cscc.designpatterns.repository.Order;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(UUID.randomUUID(), 10.00, "Marty McFly", 1);

        OrdersController ordersController = new OrdersControllerImpl(order);
        ordersController.show();
    }
}
