/**
 * The Order class represents an order placed by a customer for a product with a specified item count.
 * An order includes information about the customer, the product being ordered, and the number of items in the order.
 */
package edu.cscc.json;

public class Order {
    private Customer customer;
    private Product product;
    private int itemCount;

    /**
     * Constructs an empty Order object with default values.
     */
    public Order() {
    }

    /**
     * Constructs an Order object with the provided customer, product, and item count.
     *
     * @param customer  The customer who placed the order.
     * @param product   The product being ordered.
     * @param itemCount The number of items in the order.
     */
    public Order(Customer customer, Product product, int itemCount) {
        this.customer = customer;
        this.product = product;
        this.itemCount = itemCount;
    }

    /**
     * Gets the customer associated with this order.
     *
     * @return The customer who placed the order.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer associated with this order.
     *
     * @param customer The customer who placed the order.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets the product being ordered.
     *
     * @return The product being ordered.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product being ordered.
     *
     * @param product The product being ordered.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets the number of items in the order.
     *
     * @return The number of items in the order.
     */
    public int getItemCount() {
        return itemCount;
    }

    /**
     * Sets the number of items in the order.
     *
     * @param itemCount The number of items in the order.
     */
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    /**
     * Returns a string representation of the Order object.
     *
     * @return A string representation of the Order object.
     */
    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", product=" + product +
                ", itemCount=" + itemCount +
                '}';
    }
}
