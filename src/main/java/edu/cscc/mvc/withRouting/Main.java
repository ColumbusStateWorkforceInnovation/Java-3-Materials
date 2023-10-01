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
        orderRepository.create(new Order(10.00, "Marty McFly", 2));

        MVCContext mvcContext = new MVCContext();
        try {
            mvcContext.processRequest(new Request("Home", "index"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
