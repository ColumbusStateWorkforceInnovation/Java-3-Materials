package edu.cscc.json;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    @Test
    void testOrderConstructorAndGetters() {
        Customer customer = new Customer("John", "Doe");
        Product product = new Product("SKU123");
        int itemCount = 5;

        Order order = new Order(customer, product, itemCount);

        assertEquals(customer, order.getCustomer());
        assertEquals(product, order.getProduct());
        assertEquals(itemCount, order.getItemCount());
    }

    @Test
    void testToString() {
        Customer customer = new Customer("John", "Doe");
        Product product = new Product("SKU123");
        int itemCount = 5;

        Order order = new Order(customer, product, itemCount);

        String expected = "Order{customer=Customer{firstName='John', lastName='Doe'}, product=Product{sku='SKU123'}, itemCount=5}";
        assertEquals(expected, order.toString());
    }
}
