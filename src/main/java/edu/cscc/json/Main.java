package edu.cscc.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Type orderList = new TypeToken<ArrayList<Order>>(){}.getType();
        try {
            String ordersFilePath = args[0];
            List<Order> orders = gson.fromJson(
                    new FileReader(ordersFilePath),
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
