package edu.cscc.mvc.withRouting;

import edu.cscc.designpatterns.repository.Order;
import edu.cscc.designpatterns.repository.OrderRepository;
import edu.cscc.mvc.withRouting.framework.MVCContext;
import edu.cscc.mvc.withRouting.framework.Request;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        OrderRepository orderRepository = OrderRepository.getInstance();
        Order order = orderRepository.create(new Order(10.00, "Marty McFly", 2));

        Map<String, Object> params = new HashMap<>();
        params.put("orderId", order.getId());

        MVCContext mvcContext = new MVCContext();
        try {
            mvcContext.processRequest(new Request("Orders", "show", params));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
