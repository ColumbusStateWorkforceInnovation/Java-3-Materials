package edu.cscc.mvc.withRouting;

import edu.cscc.designpatterns.repository.Order;
import edu.cscc.designpatterns.repository.OrderRepository;
import edu.cscc.mvc.withRouting.framework.MVCContext;
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
    public void itRendersTheShowView() {
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", order.getId().toString());

        context.setRequest(new Request("Orders", "show", params));
        ordersController.show();

        assertEquals(ShowOrder.class, context.getView().getClass());
    }

    @Test
    public void itRendersTheEditView() {
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", order.getId().toString());

        context.setRequest(new Request("Orders", "edit", params));
        ordersController.edit();

        assertEquals(EditOrder.class, context.getView().getClass());
    }

    @Test
    public void itRendersTheShowViewOnSave() {
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", order.getId().toString());
        params.put("customerName", "Doc Brown");
        params.put("itemCount", 3);
        params.put("orderTotal", 15.0);

        context.setRequest(new Request("Orders", "save", params));
        ordersController.save();

        assertEquals(ShowOrder.class, context.getView().getClass());
    }

    @Test
    public void itSavesTheOrder() {
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", order.getId().toString());
        params.put("customerName", "Doc Brown");
        params.put("itemCount", 3);
        params.put("orderTotal", 15.0);

        context.setRequest(new Request("Orders", "save", params));
        ordersController.save();

        Order updatedOrder = orderRepository.read(order.getId());
        assertEquals("Doc Brown", updatedOrder.getCustomerName());
        assertEquals(3, updatedOrder.getItemCount());
        assertEquals(15.0, updatedOrder.getTotal());
    }
}