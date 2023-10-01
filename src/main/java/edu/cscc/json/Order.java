package edu.cscc.json;

public class Order {
    private Customer customer;
    private Product product;
    private int itemCount;

    public Order() {
    }

    public Order(Customer customer, Product product, int itemCount) {
        this.customer = customer;
        this.product = product;
        this.itemCount = itemCount;
    }

    //Getters and Setters
    //toString() method

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", product=" + product +
                ", itemCount=" + itemCount +
                '}';
    }
}
