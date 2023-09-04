package edu.cscc.designpatterns.repository;

import java.util.UUID;

public class Order {
    private UUID id;
    private double total;
    private String customerName;
    private int itemCount;

    public Order(double total, String customerName, int itemCount) {
        this.total = total;
        this.customerName = customerName;
        this.itemCount = itemCount;
    }

    public Order(UUID id, double total, String customerName, int itemCount) {
        this.id = id;
        this.total = total;
        this.customerName = customerName;
        this.itemCount = itemCount;
    }

    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

    public double getTotal() { return total; }

    public void setTotal(double total) { this.total = total; }

    public String getCustomerName() { return customerName; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public int getItemCount() { return itemCount; }

    public void setItemCount(int itemCount) { this.itemCount = itemCount; }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", total=" + total +
                ", customerName='" + customerName + '\'' +
                ", itemCount=" + itemCount +
                '}';
    }
}
