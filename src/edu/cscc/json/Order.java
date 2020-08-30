package edu.cscc.json;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

public class Order implements Serializable {
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
