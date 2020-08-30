package edu.cscc.xml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OrdersDocument implements Serializable {
    @XmlElement(name = "Orders")
    private Orders orders;

    public OrdersDocument() {
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrdersDocument{" +
                "orders=" + orders +
                '}';
    }
}
