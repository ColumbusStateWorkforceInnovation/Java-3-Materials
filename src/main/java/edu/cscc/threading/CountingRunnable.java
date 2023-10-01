package edu.cscc.threading;

import java.util.stream.IntStream;

public class CountingRunnable implements Runnable {
    @Override
    public void run() {
        IntStream range = IntStream.range(0, 100);
        range.forEach(value -> {
            System.out.println(Thread.currentThread().getName() + ": " + value);
        });
    }
}
