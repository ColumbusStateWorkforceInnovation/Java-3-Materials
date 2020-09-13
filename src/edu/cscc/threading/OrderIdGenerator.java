package edu.cscc.threading;

public class OrderIdGenerator {

    private int currentId;

    public synchronized String generateId() {
        return "339458" + "" + ++currentId;
    }

    public synchronized int getCurrentId() {
        return currentId;
    }
}
