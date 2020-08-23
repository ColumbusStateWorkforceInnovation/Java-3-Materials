package edu.cscc.mvc.withRouting;

import edu.cscc.designpatterns.repository.Order;
import edu.cscc.designpatterns.repository.OrderRepository;
import edu.cscc.mvc.withRouting.framework.ApplicationController;
import edu.cscc.mvc.withRouting.framework.MVCContext;
import edu.cscc.mvc.withRouting.framework.Request;

import java.util.UUID;

public class OrdersController extends ApplicationController {

    private final OrderRepository orderRepository;

    public OrdersController(MVCContext context) {
        super(context);
        orderRepository = OrderRepository.getInstance();
    }

    public void show() {
        Order order = orderRepository.read(getOrderIdFromParams());
        render(new ShowOrder(context, order));
    }

    public void save() {
        Order updatedOrder = orderRepository.update(toUpdate());
        render(new ShowOrder(context, updatedOrder));
    }

    public void edit() {
        render(new EditOrder(context, getOrderIdFromParams()));
    }

    private UUID getOrderIdFromParams() {
        return (UUID) getRequest().getParams().get("orderId");
    }

    private Request getRequest() {
        return context.getRequest();
    }

    private Order toUpdate() {
        UUID orderId = getOrderIdFromParams();
        String customerName = (String)getRequest().getParams().get("customerName");
        Double orderTotal = (Double)getRequest().getParams().get("orderTotal");
        Integer itemCount = (Integer)getRequest().getParams().get("itemCount");
        Order toUpdate = new Order(orderId, orderTotal, customerName, itemCount);

        return toUpdate;
    }
}
