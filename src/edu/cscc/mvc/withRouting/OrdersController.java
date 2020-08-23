package edu.cscc.mvc.withRouting;

import edu.cscc.designpatterns.repository.Order;
import edu.cscc.designpatterns.repository.OrderRepository;
import edu.cscc.mvc.withRouting.framework.ApplicationController;
import edu.cscc.mvc.withRouting.framework.MVCContext;
import edu.cscc.mvc.withRouting.framework.Request;

import java.util.List;
import java.util.UUID;

public class OrdersController extends ApplicationController {

    private final OrderRepository orderRepository;

    public OrdersController(MVCContext context) {
        super(context);
        orderRepository = OrderRepository.getInstance();
    }

    public void index() {
        List<Order> orders = orderRepository.readAll();
        render(new OrdersIndex(context, orders));
    }

    public void show() {
        Order order = orderRepository.read(getOrderIdFromParams());
        render(new ShowOrder(context, order));
    }

    public void select() {
        render(new SelectOrder(context));
    }

    private UUID getOrderIdFromParams() {
        return UUID.fromString((String) getRequest().getParams().get("orderId"));
    }

    private Request getRequest() {
        return context.getRequest();
    }
}
