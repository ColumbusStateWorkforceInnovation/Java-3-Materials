package edu.cscc.json;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    void testCustomerConstructorAndGetters() {
        String firstName = "John";
        String lastName = "Doe";

        Customer customer = new Customer(firstName, lastName);

        assertEquals(firstName, customer.getFirstName());
        assertEquals(lastName, customer.getLastName());
    }

    @Test
    void testToString() {
        String firstName = "John";
        String lastName = "Doe";

        Customer customer = new Customer(firstName, lastName);

        String expected = "Customer{firstName='John', lastName='Doe'}";
        assertEquals(expected, customer.toString());
    }
}
