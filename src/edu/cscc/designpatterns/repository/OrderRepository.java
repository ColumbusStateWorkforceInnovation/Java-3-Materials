package edu.cscc.designpatterns.repository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {
    Order create(Order order);

    Order read(UUID id);

    List<Order> readAll();

    Order update(Order order);

    Order delete(Order order);
}
