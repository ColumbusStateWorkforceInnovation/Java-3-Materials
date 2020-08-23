package edu.cscc.mvc.withRouting;

import edu.cscc.designpatterns.repository.Order;
import edu.cscc.designpatterns.repository.OrderRepository;
import edu.cscc.mvc.withRouting.framework.MVCContext;
import edu.cscc.mvc.withRouting.framework.MVCView;
import edu.cscc.mvc.withRouting.framework.Request;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrdersControllerTest {

    private MVCContext context;
    private OrdersController ordersController;
    private OrderRepository orderRepository;
    private Order order;

    @BeforeEach
    public void setUp() {
        context = new MVCContext();
        ordersController = new OrdersController(context);
        orderRepository = OrderRepository.getInstance();

        order = new Order(15, "Marty McFly", 2);
        orderRepository.create(order);
    }

    @Test
    public void itRendersTheSelectOrderView() {
        context.setRequest(new Request("Orders", "select"));
        ordersController.select();

        assertEquals(SelectOrder.class, context.getView());
    }

    @Test
    public void itRendersTheShowViewWithTheOrderModel() {
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", order.getId().toString());

        context.setRequest(new Request("Orders", "show", params));
        ordersController.show();

        assertEquals(ShowOrder.class, context.getView().getClass());
        ShowOrder view = (ShowOrder)context.getView();

        assertEquals(order.getId(), view.getOrder().getId());
    }
}