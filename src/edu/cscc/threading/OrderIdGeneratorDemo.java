package edu.cscc.threading;

public class OrderIdGeneratorDemo {
    public static void main(String[] args) {

        OrderIdGenerator orderIdGenerator = new OrderIdGenerator();
        Runnable orderGeneratorLambda = () -> {
            synchronized (orderIdGenerator) {
                while(orderIdGenerator.getCurrentId() < 1000) {
                    try {
                        Thread.sleep(100l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(orderIdGenerator.generateId());
                }
            }
        };

        new Thread(orderGeneratorLambda).start();
        new Thread(orderGeneratorLambda).start();
        new Thread(orderGeneratorLambda).start();
    }
}
