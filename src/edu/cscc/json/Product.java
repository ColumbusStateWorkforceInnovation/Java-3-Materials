package edu.cscc.json;

public class Product {
    private String sku;

    public Product() {
    }

    public Product(String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                '}';
    }
}
