package edu.cscc.threading;

public class OrderIdGenerator {

    private int currentId;

    public String generateId() {
        return "339458" + "" + ++currentId;
    }
}
