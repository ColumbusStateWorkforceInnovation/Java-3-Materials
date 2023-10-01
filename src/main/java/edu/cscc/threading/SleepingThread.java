package edu.cscc.threading;

import java.util.stream.IntStream;

public class SleepingThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println(this.getName() + " is " + "sleeping for 10 seconds...");
            Thread.sleep(10000l); //Sleep for 10 seconds.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        IntStream range = IntStream.range(0, 100);
        range.forEach(value -> {
            System.out.println(this.getName() + ": " + value);
        });
    }
}
