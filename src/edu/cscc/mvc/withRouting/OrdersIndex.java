package edu.cscc.mvc.withRouting;

import edu.cscc.designpatterns.repository.Order;
import edu.cscc.mvc.withRouting.framework.ApplicationView;
import edu.cscc.mvc.withRouting.framework.ExitRequest;
import edu.cscc.mvc.withRouting.framework.MVCContext;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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

        System.out.println("1. Select an order to view.");
        System.out.println("2. Return home");
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    route("Orders", "select");
                    break;
                case 2:
                    route("Home", "index");
                    break;
            }
        } catch (InputMismatchException ex) {
            this.show();
        }
    }
}
