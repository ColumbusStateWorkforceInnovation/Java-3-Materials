package edu.cscc.json;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testProductConstructorAndGetters() {
        String sku = "SKU123";

        Product product = new Product(sku);

        assertEquals(sku, product.getSku());
    }

    @Test
    void testToString() {
        String sku = "SKU123";

        Product product = new Product(sku);

        String expected = "Product{sku='SKU123'}";
        assertEquals(expected, product.toString());
    }
}
