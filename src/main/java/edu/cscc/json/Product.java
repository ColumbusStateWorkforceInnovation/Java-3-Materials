/**
 * The Product class represents a product with a Stock Keeping Unit (SKU) identifier.
 * It provides methods to access and modify product information.
 */
package edu.cscc.json;

public class Product {
    private String sku;

    /**
     * Constructs an empty Product object with a default value for the SKU.
     */
    public Product() {
    }

    /**
     * Constructs a Product object with the provided SKU.
     *
     * @param sku The Stock Keeping Unit (SKU) identifier for the product.
     */
    public Product(String sku) {
        this.sku = sku;
    }

    /**
     * Gets the Stock Keeping Unit (SKU) identifier for the product.
     *
     * @return The SKU of the product.
     */
    public String getSku() {
        return sku;
    }

    /**
     * Sets the Stock Keeping Unit (SKU) identifier for the product.
     *
     * @param sku The SKU of the product.
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * Returns a string representation of the Product object.
     *
     * @return A string representation of the Product object.
     */
    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                '}';
    }
}
