package edu.cscc.designpatterns.repository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {
    OrderRepository instance = new OrderRepositoryImpl();
    static OrderRepository getInstance() {
        return instance;
    }

    Order create(Order order);

    Order read(UUID id);

    Order update(Order order);
}
