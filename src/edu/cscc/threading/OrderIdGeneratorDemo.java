package edu.cscc.threading;

public class OrderIdGeneratorDemo {
    public static void main(String[] args) {

        OrderIdGenerator orderIdGenerator = new OrderIdGenerator();
        Runnable orderGeneratorLambda = () -> {
            while(true) {
                try {
                    Thread.sleep(100l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (orderIdGenerator) {
                    System.out.println(orderIdGenerator.generateId());
                }
            }
        };

        new Thread(orderGeneratorLambda).start();
        new Thread(orderGeneratorLambda).start();
        new Thread(orderGeneratorLambda).start();
    }
}
