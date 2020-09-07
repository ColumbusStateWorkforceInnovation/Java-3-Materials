package edu.cscc.threading;

import java.util.stream.IntStream;

public class CountingThread extends Thread {

    private int startingPosition;
    private int endingPosition;

    public CountingThread() {
        startingPosition = 0;
        endingPosition = 100;
    }

    public CountingThread(int startingPosition, int endingPosition) {

        this.startingPosition = startingPosition;
        this.endingPosition = endingPosition;
    }
    @Override
    public void run() {
        IntStream range = IntStream.range(startingPosition, endingPosition);
        range.forEach(value -> {
            System.out.println(this.getName() + ": " + value);
        });
    }
}
