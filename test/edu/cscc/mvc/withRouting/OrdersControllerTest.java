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

class OrdersControllerTest extends MVCTest {

    private OrderRepository orderRepository;
    private Order order;

    @BeforeEach
    public void setUp() {
        super.setUp();
        orderRepository = OrderRepository.getInstance();

        order = new Order(15, "Marty McFly", 2);
        orderRepository.create(order);
    }

    @Test
    public void itCanRouteToOrdersIndex() {
        assertRouteExists("Orders", "index", OrdersController.class);
    }

    @Test
    public void itRendersOrdersIndex() {
        routeRequest("Orders", "index");
        assertViewRendered(OrdersIndex.class);
    }

    @Test
    public void itCanRouteToOrdersSelect() {
        assertRouteExists("Orders", "select", OrdersController.class);
    }


    @Test
    public void itRendersTheSelectOrderView() {
        routeRequest("Orders", "select");

        assertViewRendered(SelectOrder.class);
    }

    @Test
    public void itCanRouteToOrdersShow() {
        assertRouteExists("Orders", "show", OrdersController.class);
    }

    @Test
    public void itRendersTheShowViewWithTheOrderModel() {
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", order.getId().toString());

        routeRequest("Orders", "show", params);

        assertViewRendered(ShowOrder.class);
    }
}