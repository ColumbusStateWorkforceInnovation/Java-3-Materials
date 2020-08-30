package edu.cscc.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBDemo {
    public static void main(String[] args) {
        try {
            // Pass a variable list of classes to the class that it will use for
            // marshalling and unmarshalling
            JAXBContext context = JAXBContext.newInstance(OrdersDocument.class, Orders.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            Orders orders = (Orders)unmarshaller.unmarshal(new File("./src/edu/cscc/xml/orders.xml"));
            orders.getOrders().forEach(System.out::println);

            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(orders, new File("output.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
