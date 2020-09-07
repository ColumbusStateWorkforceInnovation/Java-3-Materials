package edu.cscc.threading;

import java.util.stream.IntStream;

public class ThreadingDemo {
    public static void main(String[] args) {
        CountingThread firstThread = new CountingThread();
        CountingThread secondThread = new CountingThread();

        Thread threadWithRunnableClass = new Thread(new CountingRunnable());

        Runnable countingRunnable = new Runnable() {
            @Override
            public void run() {
                IntStream range = IntStream.range(0, 100);
                range.forEach(value -> {
                    System.out.println(Thread.currentThread().getName() + ": " + value);
                });
            }
        };
        Thread threadWithAnonymousRunnable = new Thread(countingRunnable);

        Thread threadWithLambdaRunnable = new Thread(() -> {
            IntStream range = IntStream.range(0, 100);
            range.forEach(value -> {
                System.out.println(Thread.currentThread().getName() + ": " + value);
            });
        });

        threadWithLambdaRunnable.start();
        threadWithRunnableClass.start();
        threadWithAnonymousRunnable.start();
        secondThread.start();
        firstThread.start();
    }
}
