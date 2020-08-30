package edu.cscc.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = gson.toJson(new Product()); //returns a JSON-formatted string
        gson.fromJson(json, Product.class); //returns a POJO class from a JSON-formatted string
        Type orderList = new TypeToken<ArrayList<Order>>(){}.getType();
        try {
            List<Order> orders = gson.fromJson(
                    new FileReader("./src/edu/cscc/json/orders.json"),
                    orderList
            );
            orders.forEach(System.out::println);

            String output = gson.toJson(orders);
            FileWriter fileWriter = new FileWriter("output.json");
            fileWriter.write(output);
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
