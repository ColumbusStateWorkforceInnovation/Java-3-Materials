package edu.cscc.designpatterns.repository;

import java.util.*;

public class OrderRepositoryImpl implements OrderRepository {

    private static Set<Order> orders;

    public OrderRepositoryImpl() {
        orders = new HashSet<>();
    }

    @Override
    public Order create(Order order) {
        order.setId(UUID.randomUUID());
        orders.add(order);

        return order;
    }

    @Override
    public Order read(UUID id) {
        Optional<Order> found =
                orders.stream()
                        .filter(order -> order.getId() == id)
                        .findFirst();

        return found.get();
    }

    @Override
    public List<Order> readAll() {
        return null;
    }

    @Override
    public Order update(Order order) {
        Order toUpdate = read(order.getId());
        toUpdate.setCustomerName(order.getCustomerName());
        toUpdate.setItemCount(order.getItemCount());
        toUpdate.setTotal(order.getTotal());

        return toUpdate;
    }

    @Override
    public Order delete(Order order) {
        return null;
    }
}
