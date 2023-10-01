package edu.cscc.designpatterns.repository;

public class Main {
    public static void main(String[] args) {
        OrderRepository orderRepository = new OrderRepositoryImpl();

        Order order = new Order(null, 100.00, "John Smith", 5);
        order = orderRepository.create(order);
        System.out.println("Order id: " + order.getId());

        order.setTotal(5);
        orderRepository.update(order);

        order = orderRepository.read(order.getId());
        System.out.println("Order total: " + order.getTotal());
    }
}
