package edu.cscc.mvc.simple;

import edu.cscc.designpatterns.repository.Order;

import java.util.Scanner;

public class OrdersViewImpl implements OrdersView {
    private final OrdersController controller;
    private Order model;

    public OrdersViewImpl(Order model, OrdersController controller) {
        this.model = model;
        this.controller = controller;
    }

    @Override
    public void show() {
        System.out.println("************");
        System.out.println("Order ID: " + model.getId());
        System.out.println("Order total: " + model.getTotal());
        System.out.println("Order customer name: " + model.getCustomerName());
        System.out.println("Order item count: " + model.getItemCount());
        controller.edit();
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Order total: ");
        Double orderTotal = scanner.nextDouble();
        System.out.print("Order Item Count: ");
        Integer itemCount = scanner.nextInt();
        controller.save(new Order(orderTotal, customerName, itemCount));
    }
}
